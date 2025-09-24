# ======================
# Etapa 1: Build (Compilación)
# ======================
FROM maven:3.9.6-jdk-17-slim AS build
WORKDIR /workspace

# Forzar UTF-8 para evitar errores de codificación
ENV LANG=C.UTF-8 \
    LC_ALL=C.UTF-8 \
    MAVEN_OPTS="-Dfile.encoding=UTF-8 -Dproject.build.sourceEncoding=UTF-8"

# Copiar primero el pom.xml para cachear dependencias
COPY pom.xml ./
RUN mvn -B -U -DskipTests dependency:go-offline

# Copiar el resto del proyecto
COPY src ./src

# Compilar el proyecto (sin ejecutar tests)
RUN mvn clean package -DskipTests -B


# ======================
# Etapa 2: Runtime (Ejecución)
# ======================
FROM openjdk:17-jdk-slim
LABEL maintainer="andrewarquez2207@gmail.com"

# Forzar UTF-8 en runtime también
ENV LANG=C.UTF-8 \
    LC_ALL=C.UTF-8 \
    JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8"

# Crear usuario no-root
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

# Directorio de trabajo
WORKDIR /app

# Copiar el JAR generado desde la etapa de build
COPY --from=build /workspace/target/*.jar app.jar

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

