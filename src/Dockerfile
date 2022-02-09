FROM openjdk:8
EXPOSE 9093
ADD target/esip-swagger.jar esip-swagger.jar
ENTRYPOINT ["java","-jar","/esip-swagger.jar"]