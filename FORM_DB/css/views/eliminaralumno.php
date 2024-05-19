<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>.: Editar :.</title>
    <link rel="stylesheet" href="../css/estilos.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../funciones.js"></script>
</head>
<body>


<a href="../alumno.php" class = "regresar"><img class = "volver" src="../icons/flecha-hacia-atras.png" ></a>
    <form action="" method="post">

        <h1 class="editar">Eliminar</h1>
        <fieldset class _= "marco">
            <label for="id">ID</label>
            <input type="text" name="id" id="id" class="form-control" value="<?php echo $_GET['Id']?>" required>

            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" id="nombre" class="form-control" required>

            <label for="apellido">Apellido</label>
            <input type="text" name="apellido" id="apellido" class="form-control" required>

            <label for="career">Career</label>
            <input type="text" name="career" id="career" class="form-control" required>

            <label for="habilitado">¿Está habilitado?</label>
            <input type="checkbox" name="habilitado" id="habilitado">

            <div class="btn-container">
            <button type="submit" class="btn btn-primary">Actualizar</button>
            <a href="../alumno.php" class="btn btn-danger">Cancelar</a>
        </div>
        </fieldset>
        
    </form>

    <?php
        include 'db/db.php';

        // Verificar si se está enviando una solicitud POST para eliminar
        if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['delete_id'])) {
            $id = $_POST['delete_id'];
            $sql = "DELETE FROM Alumno WHERE id = $id";
            if (mysqli_query($db, $sql)) {
                echo "<script>alert('Alumno eliminado exitosamente.'); window.location.href='';</script>";
            } else {
                $error = mysqli_error($db);
                echo "<script>alert('Error al eliminar el Alumno: $error');</script>";
            }
        }

        // Obtener todos los profesores
        $sql = "SELECT * FROM Alumno";
        $result = mysqli_query($db, $sql);
    ?>


<style>
img {
    width: 50px;
    height: auto;
}

img.volver {
    position: absolute;
    top: 10px; /* Distancia desde la parte superior */
    left: 10px; /* Distancia desde la izquierda */
}


body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Altura del viewport */
    margin: 0;
    background-image: url('https://img.freepik.com/vector-gratis/fondo-monocromatico-blanco-degradado_23-2149009161.jpg?t=st=1715918286~exp=1715921886~hmac=7a8e62b5a2763661bbeb40a302db6a948a9405b45701a51d6fcd404fb6b32fb0&w=900');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
    
}

.marco {
    border: 2px solid black; /* Borde del marco */
    padding: 20px;
    box-sizing: border-box;
    max-width: 1000px; /* Ancho máximo del marco */
    margin: auto; /* Centra horizontalmente */
}

fieldset {
    border: 1px solid black; /* Borde del fieldset */
    padding: 15px;
    box-sizing: border-box;
    width: 700px; /* Ancho del fieldset */
    max-width: 600px; /* Ancho máximo del fieldset */
    margin: 0 auto; /* Centra horizontalmente */
    border-radius: 10px; /* Radio de borde */
    background-color: #f0f0f0; /* Color de fondo para mejor visualización */
    
}

.form-control {
    width: 100%; /* Ajusta el ancho de los inputs al 100% del fieldset */
    margin-bottom: 20px; /* Espacio entre inputs */
}

.editar {
    text-align: center;
}

.btn-container {
    text-align: center;
    margin-top: 20px; /* Espacio superior para los botones */
}


</style> 
</body>
</html>



