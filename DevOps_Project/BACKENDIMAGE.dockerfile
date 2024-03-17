FROM openjdk:11-alpine

WORKDIR /app

COPY build/libs/*.jar app.jar


CMD ["java", "-jar", "app.jar"]
