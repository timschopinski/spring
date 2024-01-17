FROM openjdk:23-slim

WORKDIR /app

COPY target/movie-app-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8082

CMD ["java", "-jar", "movie-app-0.0.1-SNAPSHOT.jar"]
