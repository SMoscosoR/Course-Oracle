CREATE TABLE Alumno(
	Id int primary key,
	Nombre varchar(100)
)

--Agregar nuevas columnas a una tabla
ALTER TABLE Alumno ADD Apellido varchar(100);
ALTER TABLE Alumno ADD Correo_electronico varchar(200);

GO

--Store procedure del sistema para renombrar a una columna

EXEC sp_rename 'Alumno.Correo_electronico', 'Email';

--Eliminar una columna en una tabla.

ALTER TABLE Alumno DROP COLUMN Email;

SELECT * FROM Alumno

--CREAR UNA NUEVA TABLA PROFESORES Y REALIZAR LOS EJEMPLOS ANTERIORES

CREATE TABLE Profesores(
	Id int primary key,
	Nombre varchar(100)
)

ALTER TABLE Profesores ADD Apellido varchar(100);
ALTER TABLE Profesores ADD Localidad varchar(200);

EXEC sp_rename 'Profesores.Localidad', 'Direccion';

ALTER TABLE Profesores DROP COLUMN Direccion;

SELECT * FROM Profesores