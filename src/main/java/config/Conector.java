/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis Monterroso
 */
public class Conector {

    public static Connection CONEXION;
    private final String url = "jdbc:postgresql://localhost/electronichomes";
    private final String user = "postgres";
    private final String password = "41288320@bc";

    /**
     * Establece la conexion con la base de datos en PostgreSql.
     * 
     * @return Retorna true si se establece la conexion, de lo contrario retorna false.
     */
    public boolean conectar(){   
        try{
            CONEXION = DriverManager.getConnection(url, user, password);
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
