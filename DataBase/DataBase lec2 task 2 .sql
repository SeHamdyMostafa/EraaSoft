--create Employees table wiith column ( EmployeeID, FirstName, LastName, Department, Salary )
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    FirstName VARCHAR2(50),
    LastName VARCHAR2(50),
    Department VARCHAR2(50),
    Salary NUMBER
);

--Insert a new record into the Employees table.
INSERT INTO Employees VALUES (101, 'John1', 'Doe1', 'HR', 20000);
INSERT INTO Employees VALUES (102, 'John2', 'Doe2', 'IT', 50000);
INSERT INTO Employees VALUES (103, 'John3', 'Doe3', 'CS', 40000);
INSERT INTO Employees VALUES (104, 'John4', 'Doe4', 'IT', 10000);
INSERT INTO Employees VALUES (105, 'John5', 'Doe5', 'ZX', 30000);

--Update the salary of an employee to 600000 with EmployeeID     101.
UPDATE Employees
SET Salary = 600000
WHERE EmployeeID = 101;

--Delete a record of an employee who Department = 101.
DELETE FROM Employees
WHERE EmployeeID = 101;

--Retrieve all employees in the IT department.
SELECT *
FROM Employees
WHERE Department = 'IT';

--select * data from table but conatination  FirstName, LastName as one column
SELECT EmployeeID,
       FirstName || ' ' || LastName AS FullName,
       Department,
       Salary
FROM Employees;

SELECT * FROM Employees;