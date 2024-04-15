FROM maven:3.8.5-openjdk-17 AS builder
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=builder /target/*.jar scheduler.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "scheduler.jar" ]