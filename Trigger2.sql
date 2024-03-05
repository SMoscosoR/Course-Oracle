SELECT * FROM Region
SELECT * FROM Region_Logs

INSERT INTO REGION VALUES(5, 'Este')
INSERT INTO REGION VALUES(6, 'Oeste')
INSERT INTO REGION VALUES(8, 'Sur')

CREATE TRIGGER tgr_update_region
ON Region
FOR UPDATE
AS
	INSERT INTO Region_Logs 
		VALUES(SUSER_NAME(), 'UPDATE', CURRENT_TIMESTAMP)

UPDATE REGION Set RegionDescription = 'NorOeste'
WHERE RegionID = 5

-- Realizar un trigger para DELETE


CREATE TRIGGER tgr_delete_region
ON Region
FOR DELETE
AS
	INSERT INTO Region_Logs 
		VALUES(SUSER_NAME(), 'DELETE', CURRENT_TIMESTAMP)

DELETE FROM Region WHERE RegionID = 5

GO

DECLARE @Nombre VARCHAR(100)

SET @Nombre = 'Juan' + ' Solorzano'

PRINT @Nombre

DECLARE @edad int

SET @edad = 50

IF @edad > 18
	PRINT 'Eres mayor de edad'
ELSE
	PRINT 'Eres todavía un PULPIN'

-- Mostrar el promedio de 3 números

DECLARE @n1 float
DECLARE @n2 float
DECLARE @n3 float

SET @n1 = 10
SET @n2 = 20
SET @n3 = 30

PRINT (@n1+@n2+@n3)/3

CREATE PROCEDURE sp_sumar(
	@numero1 float,
	@numero2 float
)
AS
	DECLARE @resultado float

	SET @resultado = @numero1 + @numero2

	PRINT 'El resultado de la suma es: ' + @resultado

EXECUTE sp_sumar (12.5, 18.4);