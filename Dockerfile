FROM openjdk:8

COPY target/springboot-project.jar springboot-project.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar","/springboot-project.jar"]