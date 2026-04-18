-- 1. Find employees where emp_id is between 100 and 105
SELECT *
FROM Employees
WHERE EmployeeID BETWEEN 100 AND 105;

-- 2. Find employees with specific emp_id values
SELECT *
FROM Employees
WHERE EmployeeID IN (151, 152, 153, 154, 155);

-- 3. First name starts with P or p
SELECT *
FROM Employees
WHERE FirstName LIKE 'P%' OR FirstName LIKE 'p%';

-- 4. First name ends with A or a
SELECT *
FROM Employees
WHERE FirstName LIKE '%A' OR FirstName LIKE '%a';

-- 5. First name starts with A or a
SELECT *
FROM Employees
WHERE FirstName LIKE 'A%' OR FirstName LIKE 'a%';

-- 6. First name third character is e or E
SELECT *
FROM Employees
WHERE FirstName LIKE '__e%' OR FirstName LIKE '__E%';

-- 7. Employees with no manager assigned
SELECT *
FROM Employees
WHERE Manager_ID IS NULL;

-- 8. Employees who have a manager assigned
SELECT *
FROM Employees
WHERE Manager_ID IS NOT NULL;

-- 9. Insert new employee with NULL manager_id
INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary, Manager_ID)
VALUES (106, 'Peter', 'Brown', 'IT', 45000, NULL);

-- 10. Employees with JOB_ID = AD_VP or IT_PROG
SELECT *
FROM Employees
WHERE JOB_ID IN ('AD_VP', 'IT_PROG');

-- 11. Sort by last_name ascending
SELECT *
FROM Employees
ORDER BY LastName ASC;

-- 12. Sort by hire_date descending
SELECT *
FROM Employees
ORDER BY Hire_Date DESC;

-- 13. Sort by department ascending, then salary descending
SELECT *
FROM Employees
ORDER BY Department ASC, Salary DESC;

-- 14. Last name in lowercase
SELECT LOWER(LastName) AS LastName_Lower
FROM Employees;

-- 15. First name in uppercase
SELECT UPPER(FirstName) AS FirstName_Upper
FROM Employees;

-- 16. First name and last name in title case
SELECT 
INITCAP(FirstName) AS FirstName_Title,
INITCAP(LastName) AS LastName_Title
FROM Employees;

-- 17. Last name = smith regardless of case
SELECT *
FROM Employees
WHERE LOWER(LastName) = 'smith';