FROM eclipse-temurin:21
COPY target/golf-tournament-Docker-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
