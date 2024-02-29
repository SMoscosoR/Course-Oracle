/* Listar todas los orders que el campo ShipRegion no sean NULL. Guardar el archivo como "ejercicio03.sql" y lo subes a tu repositorio. */

SELECT * FROM Orders
WHERE ShipRegion IS NOT NULL