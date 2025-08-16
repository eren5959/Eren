FROM maven:3.9.2-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Fake port so Render is happy
ENV PORT 10000
EXPOSE $PORT

CMD ["java", "-jar", "target/telegrambot-fat.jar"]
