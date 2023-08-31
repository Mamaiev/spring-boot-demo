FROM openjdk:8

COPY target/springboot-project.jar springboot-project.jar

ENTRYPOINT ["java","-jar","/springboot-project.jar"]