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
FROM eclipse-temurin:17-jdk
LABEL maintainer="andrewarquez2207@gmail.com"

# Crear usuario no-root
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

WORKDIR /app

# Copiar el JAR generado desde la etapa de build
COPY --from=build /workspace/target/*.jar app.jar

RUN chown appuser:appgroup app.jar
USER appuser

EXPOSE 8080
ENV JAVA_OPTS="-Xmx512m -Xms256m"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dserver.port=${PORT:-8080} -jar app.jar"]


