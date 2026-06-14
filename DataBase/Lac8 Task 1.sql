-- NATURAL JOIN
SELECT *
FROM locations
NATURAL JOIN countries;

-- JOIN USING
SELECT *
FROM locations
JOIN countries
USING (country_id);

-- JOIN ON
SELECT *
FROM locations l
JOIN countries c
ON l.country_id = c.country_id;

-- INNER JOIN
SELECT *
FROM locations l
INNER JOIN countries c
ON l.country_id = c.country_id;

-- LEFT JOIN
SELECT *
FROM locations l
LEFT JOIN countries c
ON l.country_id = c.country_id;

-- RIGHT JOIN
SELECT *
FROM locations l
RIGHT JOIN countries c
ON l.country_id = c.country_id;

-- FULL OUTER JOIN
SELECT *
FROM locations l
FULL OUTER JOIN countries c
ON l.country_id = c.country_id;