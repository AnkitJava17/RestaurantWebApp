# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/foodManagement-0.0.1-SNAPSHOT.jar .

# Set the command to run your Spring Boot application
CMD ["java", "-jar", "foodManagement-0.0.1-SNAPSHOT.jar"]