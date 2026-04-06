CREATE DATABASE IF NOT EXISTS project_jdbc;
USE project_jdbc;

CREATE TABLE department (
  Id INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(100) NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE seller (
  Id INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(100) NOT NULL,
  Email VARCHAR(100) NOT NULL UNIQUE,
  BirthDate DATE,
  BaseSalary DOUBLE,
  DepartmentId INT,
  PRIMARY KEY (Id),
  CONSTRAINT fk_seller_department
    FOREIGN KEY (DepartmentId)
    REFERENCES department(Id)
);

INSERT INTO department (Id, Name) VALUES
(1, 'Computers'),
(2, 'Electronics');

INSERT INTO seller (Id, Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES
(1, 'Alex', 'alex@gmail.com', '1990-10-10', 3000, 1),
(2, 'Maria', 'maria@gmail.com', '1985-05-20', 4000, 2);