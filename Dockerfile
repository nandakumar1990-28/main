FROM openjdk:21-jdk-slim
EXPOSE 8081
ADD target/devops-integration.jar devops-integration.jar
ENTRYPOINT ["java","-jar","/devops-integration.jar"]
