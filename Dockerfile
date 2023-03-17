FROM khipu/openjdk17-alpine:latest
ARG JAR_FILE=build/libs/spring-docker-0.0.2-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]

