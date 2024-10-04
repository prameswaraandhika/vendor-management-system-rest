# Stage 1: Build stage
FROM maven:3.9.8-eclipse-temurin-21 AS build

LABEL authors="Andhika"

WORKDIR /home/app

COPY src /home/app/src
COPY pom.xml /home/app

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /home/app

COPY --from=build /home/app/target/vendor-management-system-0.0.1-SNAPSHOT.jar /home/app/vms-demo.jar

EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "/home/app/vms-demo.jar"]
