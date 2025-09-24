# ======================
# Etapa 1: Build (Compilación)
# ======================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copiar código fuente
COPY . .

# Compilar (sin tests para acelerar)
RUN mvn clean package -DskipTests -B


# ======================
# Etapa 2: Runtime (Ejecución)
# ======================
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copiar el JAR desde la etapa de build
COPY --from=build /workspace/target/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Render usa PORT dinámico
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]

