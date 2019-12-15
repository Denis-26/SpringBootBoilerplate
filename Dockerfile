# our base build image
FROM maven:3.6.0-jdk-11-slim as maven

COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B

COPY ./src ./src
RUN mvn package
WORKDIR /test

FROM openjdk:11-jre-slim
COPY --from=maven target/test-*.jar ./test.jar

ENTRYPOINT ["java", "-jar", "test.jar"]