/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.materiales;

import vista.Materiales;

/**
 *
 * @author Jafeht
 */
public class ValidarDatosMateriales {
    
    private Materiales materiales;

    public ValidarDatosMateriales(Materiales materiales) {
        this.materiales = materiales;
    }
    
     public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.
        
	String msj = "";
		
        if (this.materiales.obtenerDatos().getNombre().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Por favor ingrese el nombre del material \n";
        }
//        if (this.materiales.obtenerDatos().getCantidad() == 0) {//Si TxtNombreMat esta vacio.
//            msj += "Por favor ingrese una cantidad \n";
//        }
       
        
        
        return msj;//devuelve msj.
    }
    
}
