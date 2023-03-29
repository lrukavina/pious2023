FROM openjdk:19
EXPOSE 8080
ADD target/pious2023-docker.jar pious2023-docker.jar
ENTRYPOINT ["java", "-jar", "/pious2023-docker.jar"]