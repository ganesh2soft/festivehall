FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /festivehall/src
COPY pom.xml /festivehall

RUN mvn -f /book-service/pom.xml clean package -DskipTests
FROM openjdk:17-alpine

COPY --from=maven-builder festivehall/target/festivehall.jar /festivehall/festivehall.jar
WORKDIR /festivehall

EXPOSE 9050
ENTRYPOINT ["java","-jar","festivehall.jar"]