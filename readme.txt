https://howtodoinjava.com/spring-boot/spring-boot-jsp-view-example/

For deploy this shit on Docker:

Create network:
docker create network first-app

Run MySQL server into container and put into network:
docker run --name mysql-app --network my-network -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql:8.0.19

Build image with springboot application:
docker build -t springboot-app .

Run container and put into network:
docker run --network my-network --name springboot-container -p 8080:8080 springboot-app
// profile could be set in param of this script, need just add -e "SPRING_PROFILES_ACTIVE=test"



TODO:

add db a file for create database and maybe tables