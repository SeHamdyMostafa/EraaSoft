CREATE TABLE Manger (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    age NUMBER,
    birth_date DATE,
    address VARCHAR2(100)
);

INSERT INTO Manger (id, name, age, birth_date)
VALUES (1, 'Ahmed', 25, DATE '2000-05-10');


ALTER TABLE Manger DROP COLUMN address;
ALTER TABLE Manger
ADD (
    city_address VARCHAR2(50),
    street VARCHAR2(50)
);

ALTER TABLE Manger RENAME COLUMN name TO full_name;

ALTER TABLE Manger READ ONLY;


CREATE TABLE Owner AS
SELECT id, name, birth_date
FROM Manger;

SELECT * FROM Owner;

RENAME Manger TO Master;

DROP TABLE Master;

DROP TABLE Owner;


