CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE offset1 INT;
    SET offset1 = N-1;
  RETURN (
        SELECT DISTINCT salary
        FROM Employee
        ORDER BY salary DESC
        LIMIT 1 OFFSET offset1
  );
END

-- CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- BEGIN

-- SET N=N-1;

--   RETURN (
--       SELECT DISTINCT salary FROM Employee ORDER BY salary DESC 
--       LIMIT 1 OFFSET N      
--   );
-- END

-- CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- DETERMINISTIC
-- BEGIN
--   DECLARE result INT;
--   DECLARE offset_val INT;

--   SET offset_val = N - 1;

--   SET result = (
--       SELECT DISTINCT salary
--       FROM Employee
--       ORDER BY salary DESC
--       LIMIT 1 OFFSET offset_val
--   );

--   RETURN result;
-- END;
