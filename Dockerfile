FROM openjdk:17
EXPOSE 8080
ADD target/wheather-fiap-images.jar wheather-fiap-images.jar
ENTRYPOINT ["java", "-jar", "/wheather-fiap-images.jar"]