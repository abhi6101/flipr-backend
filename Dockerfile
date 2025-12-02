# Build stage (Keep this as is, the maven image still works)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
# Skip tests to avoid database connection errors during build
RUN mvn clean package -DskipTests

# --- THE FIX IS HERE ---
# Switched from 'openjdk:17-jdk-slim' (deleted) to 'eclipse-temurin:17-jdk' (active)
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]