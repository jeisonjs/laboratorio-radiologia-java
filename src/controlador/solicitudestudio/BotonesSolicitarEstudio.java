/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.solicitudestudio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.dao.PacienteDAO;
import modelo.dao.SolicitudEstudioDAO;
import modelo.dao.TipoEstudioDAO;
import modelo.dto.Paciente;
import modelo.dto.TipoDeEstudio;
import vista.SolicitarEstudio;

/**
 *
 * @author jeis
 */
public class BotonesSolicitarEstudio implements ActionListener {

    private SolicitarEstudio            solicitarEstudio;
    private ValidarDatosSolicEstudio    validarDatosSolicEstudio;
    private TipoEstudioDAO              tipoEstudioDAO;
    private SolicitudEstudioDAO         solicitarEstudio1dDAO;
    private PacienteDAO                 pacienteDAO;

    public BotonesSolicitarEstudio(SolicitarEstudio solicitarEstudio) {
        this.solicitarEstudio           = solicitarEstudio;
        this.validarDatosSolicEstudio   = new ValidarDatosSolicEstudio(
                this.solicitarEstudio);
        this.tipoEstudioDAO             = new TipoEstudioDAO();
        this.solicitarEstudio1dDAO      = new SolicitudEstudioDAO();
        this.pacienteDAO                = new PacienteDAO();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.solicitarEstudio.getBtnBuscar())) {
            System.out.println("Boton buscar");
            
            this.consultarPaciente();
        }
        
        if (e.getSource().equals(this.solicitarEstudio.getBtnGuardar())) {
            System.out.println("Boton guardar");
            
            this.registrarSolicitud();
            this.solicitarEstudio.limpiarFormulario();
            this.solicitarEstudio.getComboEstudio().setEnabled(false);
            this.solicitarEstudio.getComboPago().setEnabled(false);
            this.solicitarEstudio.getFormFecha().getDateChooser().setEnabled(false);
        }
        
        if(e.getSource().equals(this.solicitarEstudio.getBtnCancelar())) {
            System.out.println("Boton Cancelar");
            
            this.solicitarEstudio.limpiarFormulario();
            this.solicitarEstudio.getComboEstudio().setEnabled(false);
            this.solicitarEstudio.getComboPago().setEnabled(false);
            this.solicitarEstudio.getFormFecha().getDateChooser().setEnabled(false);
        }
        
        if (e.getSource().equals(this.solicitarEstudio.getComboEstudio())) {
            
            //System.out.println(this.solicitarEstudio.getComboEstudio().getItemAt(solicitarEstudio.getComboEstudio().getSelectedIndex()));
            this.solicitarEstudio.obtenerCostoEstudio();
        }
    }

    public void registrarSolicitud() {

        if (this.validarDatosSolicEstudio.ValidarDatos().equals("")) {

            this.solicitarEstudio1dDAO.Ingresar(this.solicitarEstudio.obtenerDatos());

        } else {

            JOptionPane.showMessageDialog(
                    null, "ERROR!! \n" + this.validarDatosSolicEstudio.ValidarDatos(),
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void consultarPaciente() {

        if (this.solicitarEstudio.getFormCedula().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ERROR!! \n"
                    + "Por favor ingrese una cedula a consultar",
                        "Validando Datos", JOptionPane.ERROR_MESSAGE);
        } else {
            int cedulaINT = Integer.parseInt(
                    this.solicitarEstudio.getFormCedula().getText());
            String cedulaSTR = this.solicitarEstudio.getFormCedula().getText();

            Paciente paciente = this.pacienteDAO.Consultar(cedulaINT);

            if (paciente != null) {
                /**
                 * Llena la tabla con el contenido.
                 */
                this.solicitarEstudio.llenarFormulario(paciente);
                this.solicitarEstudio.getComboEstudio().setEnabled(true);
                this.solicitarEstudio.getComboPago().setEnabled(true);
                this.solicitarEstudio.getFormFecha().getDateChooser().setEnabled(true);
            } else {
                /**
                 * El paciente no existe, por lo tanto muestra el mensaje.
                 */
                JOptionPane.showMessageDialog(
                        null, "La cedula ingresada no esta \n"
                        + "asociada a ningun paciente.\n"
                        + "Considere verificar la cedula",
                        "Paciente no existe!", JOptionPane.INFORMATION_MESSAGE);
                this.solicitarEstudio.limpiarFormulario();
            }

        }
    }
    
    public void obtenerEstudios(JComboBox<TipoDeEstudio> comboEstudio) {
        
        List<TipoDeEstudio> estudios = this.tipoEstudioDAO.ConsultarTodos();
        comboEstudio.removeAllItems();

        for (int i = 0; i < estudios.size(); i++) {
            System.out.println(estudios.get(i).getNombre());
            comboEstudio.addItem(
                    new TipoDeEstudio(
                            estudios.get(i).getId(), 
                            estudios.get(i).getNombre(),
                            estudios.get(i).getCosto()));
        }
    }
}
