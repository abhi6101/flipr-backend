# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Optional EXPOSE (ignored by Render)
# EXPOSE 8080

# Run Spring Boot using Render's dynamic PORT
ENTRYPOINT ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]
