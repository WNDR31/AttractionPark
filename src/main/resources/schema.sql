@@ -0,0 +1,81 @@
 CREATE TABLE IF NOT EXISTS zone (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL
 );
 
 CREATE TABLE IF NOT EXISTS thrill (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL
 );
 
 CREATE TABLE IF NOT EXISTS type (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL
 );
 
 CREATE TABLE IF NOT EXISTS attraction (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     description TEXT,
     height DOUBLE,
     duration INT,
     speed DOUBLE,
     min_height INT,
     image_url1 VARCHAR(255),
     image_url2 VARCHAR(255),
     image_url3 VARCHAR(255),
     video_url VARCHAR(255),
     zone_id BIGINT,
     intensity_id BIGINT,
     type_id BIGINT,
     FOREIGN KEY (zone_id) REFERENCES zone(id) ON DELETE CASCADE,
     FOREIGN KEY (intensity_id) REFERENCES thrill(id) ON DELETE CASCADE,
     FOREIGN KEY (type_id) REFERENCES type(id) ON DELETE CASCADE
 );
 
 CREATE TABLE IF NOT EXISTS hotel (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     slogan VARCHAR(255),
     short_description TEXT,
     description TEXT,
     theme VARCHAR(255),
     room_types TEXT,
     park_access_details TEXT,
     stars VARCHAR(10),
     image_url1 VARCHAR(255),
     image_url2 VARCHAR(255),
     image_url3 VARCHAR(255),
     image_url4 VARCHAR(255),
     image_url5 VARCHAR(255),
     cover_image VARCHAR(255),
     video_url VARCHAR(255)
 );
 
 CREATE TABLE IF NOT EXISTS restaurant (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     slogan VARCHAR(255),
     theme VARCHAR(255),
     dining_type VARCHAR(255),
     meals TEXT,
     dietary_options TEXT,
     location VARCHAR(255),
     image_url1 VARCHAR(255),
     image_url2 VARCHAR(255),
     image_url3 VARCHAR(255),
     image_url4 VARCHAR(255),
     image_url5 VARCHAR(255),
     cover_image VARCHAR(255),
     video_url VARCHAR(255)
 );
 
 CREATE TABLE IF NOT EXISTS store (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     product_type VARCHAR(255),
     location VARCHAR(255),
     cover_image VARCHAR(255)
 );