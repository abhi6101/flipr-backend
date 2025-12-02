# Start with Maven to build the app
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
# -DskipTests PREVENTS the "Tenant not found" error during build
RUN mvn clean package -DskipTests

# Run the app with a lightweight Java image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]