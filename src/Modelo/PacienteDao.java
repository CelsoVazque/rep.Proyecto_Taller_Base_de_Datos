/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CHRISTIAN JORDI
 */
public class PacienteDao {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarPaciente(Paciente pl){
        String sql ="INSERT INTO pacientes (dni, nombre, apellidoP, apellidoM, Telefono, motivo, fecha, hora) VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnetion();
            ps  = con.prepareStatement (sql);
            ps.setInt(1, pl.getDni());
            ps.setString(2, pl.getNombre());
            ps.setString(3, pl.getApelllidoP());
            ps.setString(4, pl.getApellidoM());
            ps.setLong(5, pl.getTelefono());
            ps.setString(6, pl.getMotivo());
            ps.setDate(7, new java.sql.Date(pl.getFecha().getTime()));
            
            ps.setTime(8, pl.getHora());
            ps.execute();
            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarPaciente(){
        List<Paciente> ListaPl = new ArrayList();
        String sql = "SELECT * FROM pacientes";
        try{
            con = cn.getConnetion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Paciente pl = new Paciente();
                pl.setDni(rs.getInt("dni"));
                pl.setNombre(rs.getString("nombre"));
                pl.setApelllidoP(rs.getString("apellidoP"));
                pl.setApellidoM(rs.getString("apellidoM"));
                pl.setTelefono(rs.getLong("Telefono"));
                pl.setMotivo(rs.getString("motivo"));
                pl.setFecha(rs.getDate("fecha"));
                pl.setHora(rs.getTime("hora"));
                ListaPl.add(pl);
            } 
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaPl;
    }
    
    
    public boolean EliminarPaciente (int dni){
        String sql = "DELETE FROM pacientes WHERE dni = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    
    public boolean ModificarPaciente(Paciente pl){
        String sql = "UPDATE pacientes Set nombre=?, apellidoP =?, apellidoM=?, Telefono=?, motivo=?, fecha=?, hora=? WHERE dni = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pl.getNombre());
            ps.setString(2, pl.getApelllidoP());
            ps.setString(3, pl.getApellidoM());
            ps.setLong(4, pl.getTelefono());
            ps.setString(5, pl.getMotivo());
            // Convierte el java.util.Date a java.sql.Date
            java.sql.Date fechaSql = new java.sql.Date(pl.getFecha().getTime());
            ps.setDate(6, fechaSql);
            java.sql.Date horasql = new java.sql.Date(pl.getHora().getTime());
            ps.setTime(7, pl.getHora());
            //ps.setDate(7, horasql); 
            ps.setInt(8, pl.getDni());
            ps.execute();
            return true;
                    
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
