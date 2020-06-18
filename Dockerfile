FROM openjdk:11-jre-slim
ARG JAR_FILE=target/wepa_Projekti-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
