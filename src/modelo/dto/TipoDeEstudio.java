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
public class TipoDeEstudio {

    private int id;
    private String nombre;
    private int costo;

    public TipoDeEstudio() { }

    public TipoDeEstudio(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public TipoDeEstudio(int id, String nombre, int costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
