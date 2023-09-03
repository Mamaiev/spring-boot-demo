https://howtodoinjava.com/spring-boot/spring-boot-jsp-view-example/

For deploy this shit on Docker:

Create network:
docker network create photo-network

Run MySQL server into container and put into network:
docker run --name mysql-cont --network photo-network -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql:8.0.19

Build image with springboot application:
docker build -t springboot-img:v0.1 .

Run container and put into network:
docker run --network photo-network --name springboot-cont -p 8080:8080 springboot-img:v0.1
// profile could be set in param of this script, need just add -e "SPRING_PROFILES_ACTIVE=test"

Build image with react application
docker build -t react-img:v0.1 .

Run container with react application in it mode and put into network
docker run -it --network photo-network --name react-cont -p 3000:3000 react-img:v0.1
// -it must be. With out -it doesn't work


TODO:

add db a file for create database and maybe tables for auto generation:
Create database photos;

-----CREATING TABLE PHOTO -----------------------------

INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (1, 1108232554, null, null, 'photo_2020-03-24_18-11-45.jpg', 88848);
INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (2, 475688187, null, null, 'photo_2020-09-26_14-10-13.jpg', 252039);
INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (3, -1199036722, '50° 27'' 23,98"', '30° 29'' 34,26"', 'IMG_7228.JPG', 2182843);
INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (4, -1069954003, '50° 27'' 23,98"', '30° 29'' 34,26"', 'IMG_7229.JPG', 2182843);
INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (5, 277959988, '48° 54'' 28,61"', '24° 41'' 44,93"', 'IMG_1891.JpG', 386106);


should I change dialect of db org.hibernate.dialect.MySQL5InnoDBDialect on 8th version of mysql