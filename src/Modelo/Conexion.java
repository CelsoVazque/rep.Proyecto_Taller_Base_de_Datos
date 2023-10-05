/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author CHRISTIAN JORDI
 */
public class Conexion {
    Connection con;
    
    public Connection getConnetion (){
        
        try {
            String myBD = "jdbc:mysql://localhost:3306/agenda?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            //JOptionPane.showMessageDialog(null, "Conexión exitosa");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    
}
