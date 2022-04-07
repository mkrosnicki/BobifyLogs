FROM openjdk:11 AS DEPLOY
EXPOSE 80
COPY /target/BobifyLogs-0.0.1-SNAPSHOT.jar /bobify_logs.jar
ENTRYPOINT ["java", "-jar", "/bobify_logs.jar"]
