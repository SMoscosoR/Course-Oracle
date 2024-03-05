-- Product y Suppliers

SELECT * FROM Products

SELECT * FROM Products p
LEFT JOIN Suppliers s
ON p.SupplierID = s.SupplierID

SELECT * FROM Products p
RIGHT JOIN Suppliers s
ON p.SupplierID = s.SupplierID

SELECT p.ProductName, s.CompanyName FROM Products p
INNER JOIN Suppliers s
ON p.SupplierID = s.SupplierID

-- Hacer una consulta usando INNER JOIN para las tablas Region y Territories

SELECT * FROM Territories t
INNER JOIN Region r
ON t.RegionID = r.RegionID

-- VIEWS
-- CREAR UNA VISTA EN SQL
CREATE VIEW View_Customers
AS
SELECT * FROM Customers
WHERE CustomerID LIKE 'A%'

CREATE VIEW View_Products
AS
SELECT * FROM Products
WHERE CategoryID = '3'

CREATE VIEW View_Territories
AS
SELECT * FROM Territories
WHERE TerritoryDescription LIKE 'N%'

CREATE VIEW View_Orders
AS
SELECT * FROM Orders
WHERE ShipRegion IS NOT NULL

CREATE VIEW View_Suppliers
AS
SELECT * FROM Suppliers
WHERE Country = 'France'

CREATE VIEW View_Employees
AS
SELECT * FROM Employees
WHERE FirstName LIKE 'M%'

-- Crear 05 vistas adicionales, son consultas libres

SELECT * FROM View_Customers

SELECT * FROM View_Products

SELECT * FROM View_Territories

SELECT * FROM View_Orders

SELECT * FROM View_Suppliers

SELECT * FROM View_Employees

-- Trigger cuando se inserta registros

CREATE TABLE Region_Logs(
	Id int primary key identity(1, 1),
	Usuario varchar(100),
	Accion varchar(30),
	Fecha datetime
)

SELECT * FROM Region_Logs
GO

CREATE TRIGGER tgr_insert_region
ON Region
FOR INSERT
AS
	INSERT INTO Region_Logs 
		VALUES(SUSER_NAME(), 'INSERT', CURRENT_TIMESTAMP)

	SELECT SUSER_NAME()

	SELECT CURRENT_TIMESTAMP

SELECT * FROM Region
SELECT * FROM Region_Logs

INSERT INTO REGION VALUES(5, 'Este')
INSERT INTO REGION VALUES(6, 'Oeste')
INSERT INTO REGION VALUES(7, 'Norte')

CREATE TRIGGER tgr_update_region
ON Region
FOR UPDATE
AS
	UPDATE Region_Logs SET 

UPDATE REGION Set RegionDescription = 'Este'
WHERE RegionID = 5