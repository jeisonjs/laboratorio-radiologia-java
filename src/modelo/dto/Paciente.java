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
public class Paciente {
    
    private int    nHistoria;
    private int    cedula;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private int    edad;
    private String telefono;
    private String correo;
    private String genero;
    //private String embarazo;
    private boolean embarazo;
    //private String alergias;
    private boolean alergias;

    public Paciente() { }

    public Paciente(int nHistoria, int cedula, String nombre, String apellido, 
            String fechaNac, String telefono, String correo, String genero,
            boolean embarazo, boolean alergias) {
        
        this.nHistoria = nHistoria;
        this.cedula    = cedula;
        this.nombre    = nombre;
        this.apellido  = apellido;
        this.fechaNac  = fechaNac;
        this.telefono  = telefono;
        this.correo    = correo;
        this.genero    = genero;
        this.embarazo  = embarazo;
        this.alergias  = alergias;
    }

    public Paciente(int nHistoria, int cedula, String nombre, String apellido, 
            String fechaNac, int edad, String telefono, String correo, 
            String genero, boolean embarazo, boolean alergias) {
        
        this.nHistoria = nHistoria;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.genero = genero;
        this.embarazo = embarazo;
        this.alergias = alergias;
    }

    public int getnHistoria() {
        return nHistoria;
    }

    public void setnHistoria(int nHistoria) {
        this.nHistoria = nHistoria;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(boolean embarazo) {
        this.embarazo = embarazo;
    }

    public boolean isAlergias() {
        return alergias;
    }

    public void setAlergias(boolean alergias) {
        this.alergias = alergias;
    }

    @Override
    public String toString() {
        return "Paciente{" 
                + "nombre="   + nombre + ", "
                + "apellido=" + apellido + ", "
                + "telefono=" + telefono + ", "
                + "correo="   + correo + ", "
                + "genero="   + genero +'}';
    }
    
    public String embarazoToString() {
        if (this.embarazo == true) {
            return "Si";
        } else {
            return "No";
        }
    }
    
    public String alergiasToString() {
        if (this.alergias == true) {
            return "Si";
        } else {
            return "No";
        }
    }

}
