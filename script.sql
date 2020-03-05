CREATE DATABASE library;

USE library;

CREATE TABLE author(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    nacionality VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE address(
    id INT NOT NULL,
    number INT NOT NULL,
    street VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    country VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE customer(
    id INT AUTO_INCREMENT NOT NULL,
    id_address INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
    birthday DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_address) REFERENCES address(id)

);


CREATE TABLE staff(
    id INT AUTO_INCREMENT NOT NULL,
    id_address INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_address) REFERENCES address(id)
);


CREATE TABLE loan(
    id INT AUTO_INCREMENT NOT NULL,
    id_customer INT NOT NULL,
    id_staff INT NOT NULL,
    date_of_loan DATE NOT NULL,
    return_date DATE NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (id_customer) REFERENCES customer(id),
    FOREIGN KEY (id_staff) REFERENCES staff(id)
);


CREATE TABLE book(
    id INT AUTO_INCREMENT NOT NULL,
    id_author INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    editorial VARCHAR (50) NOT NULL,
    quantity INT NOT NULL,
    edition VARCHAR(20) NOT NULL,
    category VARCHAR(30) NOT NULL,
    language VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_author) REFERENCES author(id)

);


CREATE TABLE loan_book(
    id INT AUTO_INCREMENT NOT NULL,
    id_loan INT NOT NULL,
    id_book INT NOT NULL,
    status ENUM('LOANED','RETURNED') NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_loan) REFERENCES loan(id),
    FOREIGN KEY (id_book) REFERENCES book(id)
);