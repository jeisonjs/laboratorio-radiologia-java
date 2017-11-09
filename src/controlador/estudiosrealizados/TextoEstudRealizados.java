/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.estudiosrealizados;

import controlador.paciente.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import vista.EstudiosRealizados;
import vista.RegistrarPaciente;
import vista.SolicitarEstudio;

/**
 *
 * @author jeis
 */
public class TextoEstudRealizados implements KeyListener {
    
    private EstudiosRealizados estudiosRealizados;

    public TextoEstudRealizados(EstudiosRealizados estudiosRealizados) {
        this.estudiosRealizados = estudiosRealizados;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getSource().equals(this.estudiosRealizados.getTxtCedulaPaciente())) {

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

        }
    }

    
    @Override
    public void keyPressed(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) { }
    
}
