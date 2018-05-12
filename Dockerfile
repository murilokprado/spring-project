FROM openjdk:8-jdk-alpine
MAINTAINER Murilo Prado
VOLUME /tmp
ADD target/spring-project-0.0.1-SNAPSHOT.jar target/app.jar
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]
EXPOSE 8080