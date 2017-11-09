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
public class EstudiosRealizadosDTO {

    private int    codigoRealiza;
    private int    codigoEstudio;
    private String nombrePaciente;
    private String fechaRealizacion;
    private String estudio;
    private int    costo;
    
    private int    sumatoriaEstudios;
    private int    sumatoriaCosto;
    
    private String materiales;
    private int cantidad;

    public EstudiosRealizadosDTO() {
    }

    public EstudiosRealizadosDTO(String fechaRealizacion, 
            String estudio, int costo) {
        
        this.fechaRealizacion = fechaRealizacion;
        this.estudio          = estudio;
        this.costo            = costo;
    }

    public EstudiosRealizadosDTO(String fechaRealizacion, String nombrePaciente, 
            String estudio, int costo) {
        
        this.fechaRealizacion = fechaRealizacion;
        this.nombrePaciente   = nombrePaciente;
        this.estudio          = estudio;
        this.costo            = costo;
    }
    
    public EstudiosRealizadosDTO(int codigoRealiza, String fechaRealizacion, String nombrePaciente, 
            String estudio, int costo) {
        
        this.codigoRealiza    = codigoRealiza;
        this.fechaRealizacion = fechaRealizacion;
        this.nombrePaciente   = nombrePaciente;
        this.estudio          = estudio;
        this.costo            = costo;
    }
    
    /**
     * Constructor mal hecho a las 12:14am para las clases que llena la tabla
     * de todos los estudios realizados.
     * @param fechaRealizacion
     * @param nombrePaciente
     * @param estudio
     * @param costo 
     */
    public EstudiosRealizadosDTO(String fechaRealizacion, 
            String estudio, int sumatoriaEstudios, int sumatoriaCosto) {
        
        this.codigoEstudio    = codigoEstudio;
        this.fechaRealizacion = fechaRealizacion;
        this.estudio          = estudio;
        this.sumatoriaEstudios= sumatoriaEstudios;
        this.sumatoriaCosto   = sumatoriaCosto;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
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

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoRealiza() {
        return codigoRealiza;
    }

    public void setCodigoRealiza(int codigoRealiza) {
        this.codigoRealiza = codigoRealiza;
    }

    public int getSumatoriaEstudios() {
        return sumatoriaEstudios;
    }

    public void setSumatoriaEstudios(int sumatoriaEstudios) {
        this.sumatoriaEstudios = sumatoriaEstudios;
    }

    public int getSumatoriaCosto() {
        return sumatoriaCosto;
    }

    public void setSumatoriaCosto(int sumatoriaCosto) {
        this.sumatoriaCosto = sumatoriaCosto;
    }

    public int getCodigoEstudio() {
        return codigoEstudio;
    }

    public void setCodigoEstudio(int codigoEstudio) {
        this.codigoEstudio = codigoEstudio;
    }

}
