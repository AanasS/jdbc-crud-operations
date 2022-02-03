DROP DATABASE IF EXISTS jdbc_demo_db;
CREATE DATABASE jdbc_demo_db;
USE jdbc_demo_db;

CREATE TABLE employee(
id INT(15) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30),
gender BOOLEAN,
birth_date DATE,
salary  REAL
);