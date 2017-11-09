/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.paciente;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import resources.components.Utilidades;
import vista.RegistrarPaciente;

/**
 *
 * @author jeis
 */
public class ValidarDatosPaciente {
    
    private RegistrarPaciente registrarPaciente;

    public ValidarDatosPaciente(RegistrarPaciente registrarPaciente) {
        this.registrarPaciente = registrarPaciente;
    }
    
    public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.
        
	String msj = "";
		
        if (String.valueOf(this.registrarPaciente.obtenerDatos().getCedula()).length() < 7) {//Si TxtNombreMat esta vacio.
            msj += "Cedula no puede estar vacia o contener menos de 7 caracteres   \n";
        }
        if (this.registrarPaciente.obtenerDatos().getNombre().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Nombre del paciente \n";
        }
        if (this.registrarPaciente.obtenerDatos().getApellido().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Apellido   \n";
        }
        if (this.registrarPaciente.obtenerDatos().getFechaNac().equals("")) {
            msj += "La fecha seleccionada no es valida\n";
        }
        if (this.registrarPaciente.obtenerDatos().getFechaNac() != "") {
            if (Utilidades.verificarFecha(this.registrarPaciente.getFormFechaNac().getDateChooser()) == false) {//Si TxtNombreMat esta vacio.
                msj += "La fecha seleccionada es mayor a la actual\n";
            }
        }
        if (this.registrarPaciente.obtenerDatos().getTelefono().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Telefono\n";
        }
        if (Utilidades.validateEmail(this.registrarPaciente.obtenerDatos().getCorreo()) == false) {//Si TxtNombreMat esta vacio.
            msj += "Correo\n";
        }
        if (this.registrarPaciente.obtenerDatos().getGenero().equals("Seleccione una opcion...")) {//Si TxtNombreMat esta vacio.
            msj += "Genero";
        }
        
        
        return msj;//devuelve msj.
    }
    
//    public boolean validarFecha() {
//    
//        /**
//         * Obtenemos la fecha del sistema y la convertimos a String con el formato
//         * que se va a trabajar.
//         */
//        Date fechaActual = new Date();
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
//        String fechaSistema = formatoFecha.format(fechaActual);
//        
//        this.registrarPaciente.obtenerDatos().getFechaNac().
//    }
    
//    public static boolean validarEmail(String email) {
//    
//        String PATTER_EMAIL = "";
//        
//        Pattern patronEmail = Pattern.compile(email);
//    }
}
