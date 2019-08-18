FROM openjdk:8
ADD target/userdomain-docker.jar userdomain-docker.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","userdomain-docker.jar"]
