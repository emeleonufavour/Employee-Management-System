FROM openjdk:17-jdk-alpine
COPY target/ems-backend-0.0.1-SNAPSHOT.jar ems-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ems-backend-0.0.1-SNAPSHOT.jar"]