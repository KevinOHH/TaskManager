# Dockerfile

# Imagen base con JDK
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el jar compilado al contenedor
COPY target/taskmanager-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto de la aplicación (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
