/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class conexion {
    public static Connection conectar(){
        String baseDeDatos = "controler";
        String usuario = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";
        
        Connection con = null;
        
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(conexionUrl, usuario, password);
        }
        catch(Exception e){
            Logger.getLogger(conexionUrl);
        }
        return con;
    }
}
