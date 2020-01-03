CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set n=n-1;
  RETURN (
      # Write your MySQL query statement below.
      select(
        select distinct Salary
        from Employee
        order by Salary DESC
        limit 1 offset N
      )
  );
END
