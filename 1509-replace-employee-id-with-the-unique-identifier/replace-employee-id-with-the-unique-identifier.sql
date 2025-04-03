SELECT unique_id, name
FROM Employees e
LEFT JOIN EmployeeUNI em
ON e.id = em.id;