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
public class RealizaDTO {

    private int codigoMaterial;
    private int codigoEstudio;

    public RealizaDTO() {
    }

    public RealizaDTO(int codigoMaterial, int codigoEstudio) {
        this.codigoMaterial = codigoMaterial;
        this.codigoEstudio = codigoEstudio;
    }

    public int getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(int codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public int getCodigoEstudio() {
        return codigoEstudio;
    }

    public void setCodigoEstudio(int codigoEstudio) {
        this.codigoEstudio = codigoEstudio;
    }
    
}
