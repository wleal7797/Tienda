# ======================
# Etapa 1: Build (Compilación)
# ======================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copiar el código fuente del proyecto
COPY . .

# Compilar el proyecto (sin ejecutar tests)
RUN mvn clean package -DskipTests -B


# ======================
# Etapa 2: Runtime (Ejecución)
# ======================
FROM eclipse-temurin:17-jdk-jammy
LABEL maintainer="andrewarquez2207@gmail.com"

# Crear usuario no-root
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR generado desde la etapa de build
COPY --from=build /workspace/target/tienda-0.0.1-SNAPSHOT.jar app.jar

# Cambiar permisos
RUN chown appuser:appgroup app.jar

# Cambiar a usuario no-root
USER appuser

# Exponer el puerto por defecto
EXPOSE 8080

# Variables de entorno (memoria ajustable)
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Configuración para Render/Railway → usa la variable PORT si existe
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dserver.port=${PORT:-8080} -jar app.jar"]
