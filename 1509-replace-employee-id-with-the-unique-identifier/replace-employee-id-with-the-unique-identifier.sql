SELECT unique_id , name
FROM Employees AS e 
LEFT JOIN EmployeeUNI AS em
ON e.id = em.id