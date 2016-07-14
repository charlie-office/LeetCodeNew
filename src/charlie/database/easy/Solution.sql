/**
 * [181. Employees Earning More Than Their Managers]
 */
SELECT A.Name Employee FROM Employee A, Employee B WHERE A.ManagerId = B.Id AND A.Salary > B.Salary;

/**
 * [182. Duplicate Emails]
 */
SELECT T.Email FROM (SELECT Email, COUNT(Email) nums From Person GROUP BY Email)  T WHERE T.nums > 1;

SELECT Email FROM Person GROUP BY Email HAVING count(Email) > 1;

SELECT Email FROM Person GROUP BY Email HAVING count(*) > 1;

/**
 * [175. Combine Two Tables]
 */
SELECT FirstName, LastName, City, State FROM Person LEFT JOIN Address ON Person.PersonId = Address.PersonId;

/**
 * [183. Customers Who Never Order]
 */
SELECT Name as Customers from Customers WHERE NOT EXISTS (SELECT * FROM Orders WHERE Orders.CustomerId = Customers.Id)

SELECT A.Name from Customers A
LEFT JOIN Orders B on  a.Id = B.CustomerId
WHERE b.CustomerId is NULL

SELECT A.Name from Customers A
WHERE A.Id NOT IN (SELECT B.CustomerId from Orders B)