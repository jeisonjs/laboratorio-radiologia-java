package controlador.paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.PacienteDAO;
import modelo.dto.Paciente;
import vista.RegistrarPaciente;

/**
 * Created by jeis on 30/05/17.
 */
public class BotonesRegistrarPaciente implements ActionListener {

    //private RegistrarPacienteOrig registrarPaciente;
    private RegistrarPaciente registrarPaciente;
    private ValidarDatosPaciente validarDatosPaciente;
    private int cedulaPaciente;
    private PacienteDAO pacienteDAO;

    public BotonesRegistrarPaciente(RegistrarPaciente registrarPaciente) {
        this.registrarPaciente = registrarPaciente;
        this.validarDatosPaciente = new ValidarDatosPaciente(this.registrarPaciente);
        this.pacienteDAO = new PacienteDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(this.registrarPaciente.getBtnGuardar())) {
            System.out.println("Boton Guardar");
            
            if (this.validarDatosPaciente.ValidarDatos().equals("")) {
            
                    this.registrarUsuario();
                    this.registrarPaciente.limpiarFormulario();
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR!! \n" + 
                        "Por favor ingrese \n" + this.validarDatosPaciente.ValidarDatos(), 
                        "Validando Datos", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource().equals(this.registrarPaciente.getBtnActualizar())) {
            System.out.println("Boton actualizar");
            
            this.actualizarUsuario();
            this.registrarPaciente.dispose();
        }
        
        if(e.getSource().equals(this.registrarPaciente.getBtnCancelar())) {
            System.out.println("Boton Cancelar");
            
            this.registrarPaciente.limpiarFormulario();
        }
    }
  
    public void registrarUsuario() {

        if (this.validarDatosPaciente.ValidarDatos().equals("")) {

            this.cedulaPaciente = this.registrarPaciente.obtenerDatos().getCedula();
            Paciente resultado = this.pacienteDAO.Consultar(this.cedulaPaciente);

            if (resultado == null) {
                /**
                 * Realiza el registro del nuevo usuario si este no existe.
                 */
                this.pacienteDAO.Ingresar(this.registrarPaciente.obtenerDatos());

            } else {
                /**
                 * El nombre de usuario existe, por lo tanto pregunta si desea
                 * modificarlo.
                 */
                JOptionPane.showMessageDialog(
                        null, "      Esta cedula se encuentra asociada a un paciente! \n"
                        + "Considere usar otro nombre o modificar el \n"
                        + "Pacientes ya existente.",
                        "Alerta!", JOptionPane.INFORMATION_MESSAGE);
                //this.registrarPaciente.vaciarFormulario();
            }
        } else {

            JOptionPane.showMessageDialog(
                    null, "ERROR!! \n" + this.validarDatosPaciente.ValidarDatos(),
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarUsuario() {

        if (this.validarDatosPaciente.ValidarDatos().equals("")) {
            try {
                
                pacienteDAO.Actualizar(this.registrarPaciente.obtenerDatos());
                
            } catch (Exception e2) {

                System.out.println("Error al insertar " + e2);
            }
        } else {
            JOptionPane.showMessageDialog(
                    null, "ERROR!! \n" + this.validarDatosPaciente.ValidarDatos(),
                        "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
}
