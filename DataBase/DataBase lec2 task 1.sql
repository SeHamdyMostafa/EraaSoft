--create table Doctor
CREATE TABLE Doctor (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    salary INT,
    address VARCHAR(100)
);

--please insert 10 row with Data as you like 
INSERT ALL
INTO Doctor (id, name, salary, address) VALUES (1, 'Ahmed Ali', 1000, 'Cairo')
INTO Doctor (id, name, salary, address) VALUES (2, 'Sara Mohamed', 2000, 'Giza')
INTO Doctor (id, name, salary, address) VALUES (3, 'Omar Hassan', 1500, 'Alexandria')
INTO Doctor (id, name, salary, address) VALUES (4, 'Mona Adel', 3000, 'Luxor')
INTO Doctor (id, name, salary, address) VALUES (5, 'Khaled Samir', 2500, 'Aswan')
INTO Doctor (id, name, salary, address) VALUES (6, 'Nour Ibrahim', 1800, 'Tanta')
INTO Doctor (id, name, salary, address) VALUES (7, 'Youssef Mahmoud', 2200, 'Mansoura')
INTO Doctor (id, name, salary, address) VALUES (8, 'Laila Fathy', 2700, 'Suez')
INTO Doctor (id, name, salary, address) VALUES (9, 'Hassan Mostafa', 3200, 'Ismailia')
INTO Doctor (id, name, salary, address) VALUES (10, 'Dina Saeed', 2900, 'Hurghada')
SELECT * FROM Doctor;

--update record number 3 with salary 20000
UPDATE Doctor
SET salary = 20000
WHERE id = 3;

--delete record number 9
DELETE FROM Doctor
WHERE id = 9;

-- please Concatenation all name with salary  of all rows
SELECT CONCAT(CONCAT(name, ' - '), salary) AS name_salary
FROM Doctor;

--display all record with salary * 2
SELECT id, name, salary * 2 AS doubled_salary, address
FROM Doctor;

-- select all data with salary  1000 , 2000 , 3000 
SELECT *
FROM Doctor
WHERE salary IN (1000, 2000, 3000);

--rename table Doctor to PRD_DOCTOR
ALTER TABLE Doctor
RENAME TO PRD_DOCTOR;