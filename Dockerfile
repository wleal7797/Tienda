# ======================
# Etapa 1: Build (Compilación)
# ======================
FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /workspace

# Copiar archivo pom.xml primero para cachear dependencias
COPY pom.xml .
RUN mvn -B -U -DskipTests dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Compilar el proyecto (sin ejecutar tests)
RUN mvn clean package -DskipTests -B

# ======================
# Etapa 2: Runtime (Ejecución)
# ======================
FROM amazoncorretto:17-alpine
WORKDIR /app

# Copiar el JAR generado
COPY --from=build /workspace/target/*.jar app.jar

# Exponer el puerto por defecto
EXPOSE 8080

# Comando de ejecución (Render asigna el puerto dinámicamente)
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]
