--Realizar un backup de una base de datos.

/*

01. Listar todos los customers que inicien su id con la letra "A". Guardas el archivo como "ejercicio01.sql" y lo subes a tu repositorio.
02. Listar a todos los customers que sean de los países: France, Germany, Sweden. Guardas el archivo como "ejercicio01.sql" y lo subes a tu repositorio.

*/

SELECT * FROM Customers
WHERE CustomerID LIKE 'A%'
