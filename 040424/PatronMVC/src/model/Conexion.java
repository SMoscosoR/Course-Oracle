package model;

import java.sql.*;

public class Conexion {
    Connection cn = null;
    
    public Connection conectar(){
        try{
            String url = "jdbc:mysql://localhost:3306/northwind?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String passwd = "";
            this.cn = DriverManager.getConnection(url, user, passwd);
            if (cn!= null){
                System.out.println("Conectado a BD | OK");
            }
        } catch(SQLException e){
            e.printStackTrace();
        } 
        return this.cn;
    }
}