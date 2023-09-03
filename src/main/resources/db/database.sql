CREATE DATABASE IF NOT EXISTS photos;

USE photos;

create table photo
(
    id        int          not null
        primary key,
    hash      int          null,
    latitude  varchar(255) null,
    longitude varchar(255) null,
    name      varchar(255) null,
    size      bigint       null
);

INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (1, 1108232554, null, null, 'photo_2020-03-24_18-11-45.jpg', 88848);
INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (2, 475688187, null, null, 'photo_2020-09-26_14-10-13.jpg', 252039);
INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (3, -1199036722, '50° 27'' 23,98"', '30° 29'' 34,26"', 'IMG_7228.JPG', 2182843);
INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (4, -1069954003, '50° 27'' 23,98"', '30° 29'' 34,26"', 'IMG_7229.JPG', 2182843);
INSERT INTO photos.photo (id, hash, latitude, longitude, name, size) VALUES (5, 277959988, '48° 54'' 28,61"', '24° 41'' 44,93"', 'IMG_1891.JpG', 386106);
