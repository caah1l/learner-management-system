FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTestss=false -Dspring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

FROM eclipse-temurin:21-jre-alpine AS runner

#COPY --from=builder ./app/target/learner-service-0.0.1-SNAPSHOT.jar ./app.jar
COPY --from=builder /app/target/*.jar /app.jar

EXPOSE 9090
EXPOSE 9091

ENTRYPOINT ["java", "-jar", "app.jar"]