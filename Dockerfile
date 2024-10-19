FROM maven:3.8.5-openjdk-17 AS build
RUN mkdir /opt/app
COPY . /opt/app
WORKDIR /opt/app
RUN mvn clean package

FROM eclipse-temurin:17.0.12_7-jre
RUN mkdir /opt/app
COPY --from=build  /opt/app/target/wheather-fiap-images.jar /opt/app/app.jar
WORKDIR /opt/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]