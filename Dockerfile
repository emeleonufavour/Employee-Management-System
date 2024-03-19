# Stage 1: Build Stage
FROM maven:latest AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn package

# Stage 2: Production Stage
FROM openjdk:17-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build /app/target/ems-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]