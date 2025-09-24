# ======================
# Etapa 1: Build (Compilación)
# ======================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copiar archivos de configuración primero (para mejor cache de Docker)
COPY pom.xml .
COPY src ./src

# Compilar el proyecto (sin ejecutar tests)
RUN mvn clean package -DskipTests -B

# ======================
# Etapa 2: Runtime (Ejecución)
# ======================
FROM openjdk:17-jre-slim
LABEL maintainer="andrewarquez2207@gmail.com"

# Instalar curl para health checks
RUN apt-get update && apt-get install -y \
    curl \
    && rm -rf /var/lib/apt/lists/* \
    && apt-get clean

# Crear usuario no-root
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

WORKDIR /app

# Copiar el JAR generado desde la etapa de build
COPY --from=build /workspace/target/*.jar app.jar

# Cambiar permisos del archivo
RUN chown appuser:appgroup app.jar

# Cambiar a usuario no-root
USER appuser

EXPOSE 8080

# Variables de entorno optimizadas para contenedores
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:+UseContainerSupport"

# Health check para verificar que la aplicación esté funcionando
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:${PORT:-8080}/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dserver.port=${PORT:-8080} -jar app.jar"]