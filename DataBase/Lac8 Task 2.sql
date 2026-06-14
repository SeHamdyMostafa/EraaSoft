-- NATURAL JOIN
SELECT *
FROM jobs
NATURAL JOIN job_history;

-- JOIN USING
SELECT *
FROM jobs
JOIN job_history
USING (job_id);

-- JOIN ON
SELECT *
FROM jobs j
JOIN job_history jh
ON j.job_id = jh.job_id;

-- INNER JOIN
SELECT *
FROM jobs j
INNER JOIN job_history jh
ON j.job_id = jh.job_id;

-- LEFT JOIN
SELECT *
FROM jobs j
LEFT JOIN job_history jh
ON j.job_id = jh.job_id;

-- RIGHT JOIN
SELECT *
FROM jobs j
RIGHT JOIN job_history jh
ON j.job_id = jh.job_id;

-- FULL OUTER JOIN
SELECT *
FROM jobs j
FULL OUTER JOIN job_history jh
ON j.job_id = jh.job_id;