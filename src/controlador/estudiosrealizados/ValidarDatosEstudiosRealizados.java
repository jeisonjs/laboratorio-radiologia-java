/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.estudiosrealizados;

import controlador.paciente.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import resources.components.Utilidades;
import vista.EstudiosRealizados;
import vista.RegistrarPaciente;

/**
 *
 * @author jeis
 */
public class ValidarDatosEstudiosRealizados {
    
    private EstudiosRealizados estudiosRealizados;

    public ValidarDatosEstudiosRealizados(EstudiosRealizados estudiosRealizados) {
        this.estudiosRealizados = estudiosRealizados;
    }
    
    public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.
        
	String msj = "";
	
        if (this.estudiosRealizados.obtenerFechaINI().equals("")) {
            msj += "La fecha seleccionada no es valida\n";
        }
        if (this.estudiosRealizados.obtenerFechaINI() != "") {
            if (Utilidades.verificarFecha(this.estudiosRealizados.getFechaInicio()) == false) {//Si TxtNombreMat esta vacio.
                msj += "La fecha seleccionada es mayor a la actual\n";
            }
        }
        if (this.estudiosRealizados.obtenerFechaFIN().equals("")) {
            msj += "La fecha seleccionada no es valida\n";
        }
        if (this.estudiosRealizados.obtenerFechaFIN() != "") {
            if (Utilidades.verificarFecha(this.estudiosRealizados.getFechaFinal()) == false) {//Si TxtNombreMat esta vacio.
                msj += "La fecha seleccionada es mayor a la actual\n";
            }
        }
        
        
        return msj;//devuelve msj.
    }
}
