/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author jeis
 */
public class MaterialDTO {
    
    private int    id;
    private String nombre;
    private int    cantidad;
    private String informacion;

    public MaterialDTO() {
    }

    public MaterialDTO(String nombre) {
        this.nombre = nombre;
    }

    public MaterialDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public MaterialDTO(String nombre, int cantidad, String informacion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.informacion = informacion;
    }

    public MaterialDTO(int id, String nombre, int cantidad, String informacion) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.informacion = informacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
