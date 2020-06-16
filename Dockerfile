# OpenJDK JRE
FROM openjdk:11.0.7-jre-slim-buster

# Copy JAR into container
COPY target/poolauto-api-backend-0.0.1-SNAPSHOT.jar /jar/poolauto-api-backend-0.0.1-SNAPSHOT.jar

# Create a volume to access property files
VOLUME $HOME/Documents/Poolauto-API-configs

# Expose port 8080
EXPOSE 8080

# Run in dev profile
ENTRYPOINT java -Dspring.profiles.active=dev -jar /jar/poolauto-api-backend-0.0.1-SNAPSHOT.jar
