FROM openjdk:8u131-jdk-alpine
EXPOSE 8080
WORKDIR /usr/local/bin
COPY target/backends-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]