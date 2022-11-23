FROM openjdk:11
EXPOSE 8080
ADD target/store-plus-api.jar store-plus-api.jar
ENTRYPOINT ["java","-jar","/store-plus-api.jar"]