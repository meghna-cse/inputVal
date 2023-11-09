FROM openjdk:17-jdk-alpine
VOLUME /tmp
#ARG JAR_FILE=target/*.jar
#ARG DEPENDENCY=target/dependency
#COPY ${JAR_FILE} app.jar
COPY ${DEPENDENCY} /app
COPY target/spring-phonebook-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","/app.war"]