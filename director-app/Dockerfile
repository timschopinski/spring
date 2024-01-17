FROM openjdk:23-slim

WORKDIR /app

COPY target/director-app-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8082

CMD ["java", "-jar", "director-app-0.0.1-SNAPSHOT.jar"]
