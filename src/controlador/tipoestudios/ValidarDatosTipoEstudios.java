/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.tipoestudios;

import controlador.materiales.*;
import vista.Materiales;
import vista.RegistrarTipoEstudio;

/**
 *
 * @author Jafeht
 */
public class ValidarDatosTipoEstudios {
    
    private RegistrarTipoEstudio registrarTipoEstudio;

    public ValidarDatosTipoEstudios(RegistrarTipoEstudio registrarTipoEstudio) {
        this.registrarTipoEstudio = registrarTipoEstudio;
    }
    
     public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.
        
	String msj = "";
		
        if (this.registrarTipoEstudio.obtenerDatos().getNombre().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Por favor ingrese el nombre del estudio \n";
        }
        if (this.registrarTipoEstudio.obtenerDatos().getCosto() == 0) {//Si TxtNombreMat esta vacio.
            msj += "Por favor ingrese el costo \n";
        }
       
        
        
        return msj;//devuelve msj.
    }
    
}
