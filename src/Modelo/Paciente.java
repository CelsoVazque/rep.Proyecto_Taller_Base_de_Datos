/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
//import java.sql.Date;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

/**
 *
 * @author CHRISTIAN JORDI
 */
public class Paciente {
    private int id;
    private int dni; 
    private String nombre;
    private String ApelllidoP;
    private String ApellidoM;
    private long telefono; 
    private String motivo;
    private Date fecha;
    private Time hora;

    public Paciente() {
    }

    public Paciente(int id, int dni, String nombre, String ApelllidoP, String ApellidoM, long telefono, String motivo, Date fecha, Time hora) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.ApelllidoP = ApelllidoP;
        this.ApellidoM = ApellidoM;
        this.telefono = telefono;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelllidoP() {
        return ApelllidoP;
    }

    public void setApelllidoP(String ApelllidoP) {
        this.ApelllidoP = ApelllidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    
    
    
}
