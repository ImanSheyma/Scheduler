FROM maven:3.8.5-openjdk-17 AS builder
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=builder /target/scheduler-0.0.1-SNAPSHOT.jar scheduler.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "scheduler.jar" ]