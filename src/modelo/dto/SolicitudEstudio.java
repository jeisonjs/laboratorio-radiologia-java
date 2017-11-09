/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dto;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SolicitudEstudio {

    private int     codigo;
    private int     cedula;
    private String  nombre;
    private String  apellido;
    private int     codigoEstudio;
    private int     costo;
    private String  tipoPago;
    private String  fecha;

    public SolicitudEstudio() {
    }

    public SolicitudEstudio(int codigo, int cedula, String nombre, String apellido, 
            int codigoEstudio, int costo, String tipoPago, String fecha) {
        
        this.codigo     = codigo;
        this.cedula     = cedula;
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.codigoEstudio = codigoEstudio;
        this.costo      = costo;
        this.tipoPago   = tipoPago;
        this.fecha      = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getCodigoEstudio() {
        return codigoEstudio;
    }

    public void setCodigoEstudio(int codigoEstudio) {
        this.codigoEstudio = codigoEstudio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
