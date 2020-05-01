FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:11.0.7-jdk-buster

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/zadanie-rekrutacyjne-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "zadanie-rekrutacyjne-0.0.1-SNAPSHOT.jar"]
