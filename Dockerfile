FROM amazoncorretto:17

COPY target/*.jar app.jar

WORKDIR /usr/app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]