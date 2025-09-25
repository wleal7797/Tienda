# Usar imagen de Microsoft que nunca falla
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

LABEL maintainer="andrewarquez2207@gmail.com"

# Actualizar sistema e instalar herramientas
RUN apt-get update && apt-get install -y \
    curl \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Instalar Maven manualmente
RUN wget https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz && \
    tar -xzf apache-maven-3.9.6-bin.tar.gz && \
    mv apache-maven-3.9.6 /opt/maven && \
    rm apache-maven-3.9.6-bin.tar.gz

# Encontrar JAVA_HOME correctamente
RUN JAVA_PATH=$(which java) && \
    JAVA_HOME_PATH=$(readlink -f $JAVA_PATH | sed 's:/bin/java::') && \
    echo "JAVA_HOME found at: $JAVA_HOME_PATH" && \
    echo "export JAVA_HOME=$JAVA_HOME_PATH" >> ~/.bashrc

# Variables de entorno con JAVA_HOME correcto
ENV MAVEN_HOME=/opt/maven
ENV PATH=$MAVEN_HOME/bin:$PATH
ENV JAVA_HOME=/usr/lib/jvm/msopenjdk-17

# Verificar instalación
RUN echo "Java version:" && java -version && \
    echo "Maven version:" && /opt/maven/bin/mvn -version

# Crear usuario
RUN groupadd --gid 1000 appuser && \
    useradd --uid 1000 --gid appuser --shell /bin/bash --create-home appuser

# Directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY --chown=appuser:appuser . .

# Compilar el proyecto con todas las variables correctas
RUN export JAVA_HOME=/usr/lib/jvm/msopenjdk-17 && \
    export PATH=$JAVA_HOME/bin:$PATH && \
    /opt/maven/bin/mvn clean package -DskipTests -B

# Mover el JAR compilado
RUN cp target/*.jar app.jar && \
    chown appuser:appuser app.jar

# Cambiar a usuario no-root
USER appuser

# Puerto
EXPOSE 8080

# Variables de Java optimizadas
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENV JAVA_HOME=/usr/lib/jvm/msopenjdk-17

# Comando de ejecución
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dserver.port=${PORT:-8080} -jar app.jar"]