/*
Ejercicios

1. Crear una nueva base de datos llamada "TallerSQL".
2. Crear una tabla llamada "Clientes", considerar los atributos Id, Nombre, Apellido, Telefono, Direccion, Email.
3. Insertar 10 registros en la tabla creada anteriormente.
4. Mostrar todos los registros insertados.
5. Actualizar 5 registros de la tabla anteriormente creada utilizando WHERE.
6. Eliminar 2 registros utilizando WHERE.
7. Guardar todo tu trabajo en tu repositorio de github.

*/

CREATE DATABASE TallerSQL
USE TallerSQL
GO

CREATE TABLE Clientes(
Id char(5) NOT NULL primary key,
Nombre varchar(30) NOT NULL,
Apellido varchar(30) NOT NULL,
Telefono varchar(9) NOT NULL,
Direccion varchar(60) NOT NULL,
Email varchar(50) NOT NULL
)

INSERT INTO Clientes values('00001', 'Pedro', 'Castillo', '987654321', 'Lima', 'pcastillo@hotmail.com'),
						   ('00002', 'Martin', 'Vizcarra', '912345678', 'Lurin', 'mvizcarra@outlook.com'),
						   ('00003', 'Alan', 'Garcia', '987651234', 'Piura', 'agarcia@gmail.com'),
						   ('00004', 'Alberto', 'Fujimori', '956781234', 'Ancash', 'afujimori@gmail.com'),
						   ('00005', 'Pepe', 'Casas', '943215678', 'San Martin de Porres', 'pcasas@hotmail.com'),
						   ('00006', 'Tito', 'Frozono', '912876543', 'Cuzco', 'tfrozono@outlook.com'),
						   ('00007', 'Juan', 'Montenegro', '912348765', 'Madre de Dios', 'jmontenegro@hotmail.com'),
						   ('00008', 'Diego', 'Teheran', '912345687', 'Loreto', 'dteheran@hotmail.com'),
						   ('00009', 'Mirko', 'Ramos', '915432678', 'San Miguel', 'mramos@gmail.com'),
						   ('00010', 'Daniel', 'Escudero', '975318642', 'Tacna', 'descudero@outlook.com');

UPDATE Clientes SET Email = 'afujimori@hotmail.com'
WHERE Nombre = 'Alberto';

UPDATE Clientes SET Direccion = 'Puente Piedra'
WHERE Nombre = 'Daniel';

UPDATE Clientes SET Nombre = 'Pepito'
WHERE Id = '00005';

UPDATE Clientes SET Apellido = 'Moreno'
WHERE Nombre = 'Juan';

UPDATE Clientes SET Telefono = '942156742'
WHERE Nombre = 'Alan';

DELETE FROM Clientes
WHERE Nombre = 'Juan';

DELETE FROM Clientes
WHERE Id = '00005';

SELECT * FROM Clientes