CREATE TABLE person
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    url  VARCHAR(500) NOT NULL
);

INSERT INTO person(name, url)
SELECT *
FROM CSVREAD('classpath:/people.csv');