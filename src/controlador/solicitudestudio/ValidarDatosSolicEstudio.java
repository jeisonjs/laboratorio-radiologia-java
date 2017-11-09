/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.solicitudestudio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.SolicitarEstudio;

/**
 *
 * @author jeis
 */
public class ValidarDatosSolicEstudio {

    private SolicitarEstudio solicitarEstudio;

    public ValidarDatosSolicEstudio(SolicitarEstudio solicitarEstudio) {
        this.solicitarEstudio = solicitarEstudio;
    }
    
    public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.
        
	String msj = "";
		
        if (this.solicitarEstudio.getFormCedula().getText().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Cedula del paciente   \n";
        }
        if (this.solicitarEstudio.getFormNombre().getText().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Nombre del paciente   \n";
        }
        if (this.solicitarEstudio.getFormApellido().getText().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Apellido del paciente \n";
        }
        if (this.solicitarEstudio.getComboEstudio().getSelectedIndex() == 0) {//Si TxtNombreMat esta vacio.
            msj += "Tipo de estudio   \n";
        }
        if (this.solicitarEstudio.getComboPago().getSelectedIndex() == 0) {//Si TxtNombreMat esta vacio.
            msj += "Tipo de pago";
        }
        if (this.solicitarEstudio.getFormFecha().getDateFormatSQL().equals("")) {//Si TxtNombreMat esta vacio.
            msj += "Seleccione una fecha";
        }
        
        
        return msj;//devuelve msj.
    }
}
