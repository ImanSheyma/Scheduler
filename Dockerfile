FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar scheduler.jar
ENTRYPOINT ["java","-jar","/scheduler.jar"]
EXPOSE 8080