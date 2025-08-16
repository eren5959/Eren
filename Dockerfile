FROM maven:3.9.2-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Fake port binding so Render web service is happy
ENV PORT 10000
EXPOSE $PORT

CMD ["java", "-cp", "target/classes:target/dependency/*", "com.example.telegrambot.Main"]
