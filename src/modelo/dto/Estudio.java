/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.util.Date;

/**
 *
 * @author jeis
 */
public class Estudio {
    
    private int    cedula;
    private String nombre;
    private String apellido;
    private String estudio;
    private int    costo;
    private String pago;
    private Date   fecha;

    public Estudio() {
    }

    public Estudio(int cedula, String nombre, String apellido, String estudio, 
            int costo, String pago, Date fecha) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estudio = estudio;
        this.costo = costo;
        this.pago = pago;
        this.fecha = fecha;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Estudio{" + "nombre="   + nombre   + ", "
                          + "apellido=" + apellido + ", "
                          + "estudio="  + estudio  + ", "
                          + "pago="     + pago     + '}';
    }
    
    
}
