/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.solicitudestudio;

import controlador.paciente.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import vista.RegistrarPaciente;
import vista.SolicitarEstudio;

/**
 *
 * @author jeis
 */
public class TextoSolicEstudio implements KeyListener {
    
    private SolicitarEstudio solicitarEstudio;

    public TextoSolicEstudio(SolicitarEstudio solicitarEstudio) {
        this.solicitarEstudio = solicitarEstudio;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getSource().equals(this.solicitarEstudio.getFormCedula().
                getTextField())) {

            int k = (int) e.getKeyChar();//k = al valor de la tecla presionada

            if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {//Si el caracter ingresado es una letra
                e.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
                JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
            }

            if (k == 241 || k == 209) {//Si el caracter ingresado es una letra
                e.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
                JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
            }
            
            //Limitar el numero de caracteres. Solo se pueden ingresar 10 caracteres
            if (this.solicitarEstudio.getFormCedula().getText().length() >= 15) {
                e.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
                JOptionPane.showMessageDialog(null, "Ha excedido el numero maximo de caracteres!!! (15)", "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        
        if (e.getSource().equals(this.solicitarEstudio.getFormNombre().
                getTextField())) {

            int k = (int) e.getKeyChar();//k = al valor de la tecla presionada

            if (k > 47 && k < 58) {//Si el caracter ingresado es una letra
                e.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
                JOptionPane.showMessageDialog(null, "No puede ingresar numeros!!!", "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource().equals(this.solicitarEstudio.getFormApellido().
                getTextField())) {

            int k = (int) e.getKeyChar();//k = al valor de la tecla presionada

            if (k > 47 && k < 58) {//Si el caracter ingresado es una letra
                e.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
                JOptionPane.showMessageDialog(null, "No puede ingresar numeros!!!", "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
    @Override
    public void keyPressed(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) { }
    
}
