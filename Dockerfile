FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} netty-server.jar
ENTRYPOINT ["java","-jar","/netty-server.jar"]
EXPOSE 9999

