#FROM ubuntu:latest
#LABEL authors="Laptop24h"
#
#ENTRYPOINT ["top", "-b"]

FROM openjdk:1.8
ADD ./docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]