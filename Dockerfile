FROM openjdk:8-jdk-alpine

COPY target/RewardsService-1.0.0.jar RewardsService-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "RewardsService-1.0.0.jar"]
