package entregable2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection cn = null;
    public Connection conectar(){
        try{
            String url = "jdbc:mysql://localhost:3306/ROBOCOP?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "";
            this.cn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection succesfull!!");

        } catch(SQLException e){
            e.printStackTrace();   
        }
        return cn;
    }   
}