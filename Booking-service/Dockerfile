FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} booking-service.jar
ENTRYPOINT ["java","-jar","/booking-service.jar"]
EXPOSE 8094