/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.PacienteDAO;
import modelo.dto.Paciente;
import report.pacientesregistrados.reportePacienteregistrado;
import vista.PacientesRegistrados;
import vista.RegistrarPaciente;

/**
 *
 * @author jeis
 */
public class BotonesPacientesReg implements ActionListener {

    private PacientesRegistrados pacientesRegistrados;
    private RegistrarPaciente registrarPaciente;
    private PacienteDAO pacienteDAO;
private reportePacienteregistrado reportePacienteregistrado;
    public BotonesPacientesReg(PacientesRegistrados pacientesRegistrados) {
        this.pacientesRegistrados = pacientesRegistrados;
        this.pacienteDAO = new PacienteDAO();
        this.reportePacienteregistrado=new reportePacienteregistrado();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.pacientesRegistrados.getBtnBuscar())) {
            System.out.println("Boton buscar");

            String cedulaSTR = this.pacientesRegistrados.getTxtCedulaPaciente().getText();
            if (cedulaSTR.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR!! \n"
                        + "Por favor ingrese una cedula a consultar",
                        "Validando Datos", JOptionPane.ERROR_MESSAGE);

                this.obtenerPacientes();
            } else {
                this.consultarPaciente();
            }
        }

        if (e.getSource().equals(this.pacientesRegistrados.getBtnModificar())) {
            System.out.println("Boton modificar");

            this.modificarPaciente();
        }

        if (e.getSource().equals(this.pacientesRegistrados.getBtnEliminar())) {
            System.out.println("Boton eliminar");

            this.eliminarPaciente();
        }

        if (e.getSource().equals(this.pacientesRegistrados.getBtnReporte())) {
            System.out.println("Boton reporte");
this.reportePacienteregistrado.generarReporte();
        }
    }

    public void obtenerPacientes() {

        List<Paciente> pacientes = this.pacienteDAO.ConsultarTodos();

        this.pacientesRegistrados.vaciarTablaPacientes();
        for (int i = 0; i < pacientes.size(); i++) {

            this.pacientesRegistrados.llenarTablaPacientes(
                    new Object[]{
                        pacientes.get(i).getnHistoria(),
                        pacientes.get(i).getCedula(),
                        pacientes.get(i).getNombre(),
                        pacientes.get(i).getApellido(),
                        pacientes.get(i).getEdad(),
                        pacientes.get(i).getTelefono(),
                        pacientes.get(i).getCorreo(),
                        pacientes.get(i).getGenero(),
                        pacientes.get(i).embarazoToString(),
                        pacientes.get(i).alergiasToString()});
        }
    }

    // Desactivar paciente?
    public void eliminarPaciente() {

        int filaSeleccionada = this.pacientesRegistrados.getTablaPacientes().getSelectedRow();

        if (filaSeleccionada != -1) {

            String nombreUsuario = this.pacientesRegistrados.getTablaPacientes().getValueAt(
                    filaSeleccionada, 2).toString();
            int cedulaUsuario = Integer.parseInt(String.valueOf(
                    this.pacientesRegistrados.getTablaPacientes().getValueAt(filaSeleccionada, 1)));
            /*
             * Le preguntare al usuario si en realidad desea modificar la categoria.
             */
            int opc
                    = JOptionPane.showConfirmDialog(
                            null,
                            " Desea eliminar de forma permanente al paciente: " + nombreUsuario + "? ",
                            "Confirmar eliminacion ",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (opc == 0) {

                this.pacientesRegistrados.getModeloTabla().removeRow(filaSeleccionada);
                this.pacienteDAO.Eliminar(cedulaUsuario);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

    public void consultarPaciente() {

        if (this.pacientesRegistrados.getTxtCedulaPaciente().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ERROR!! \n"
                    + "Por favor ingrese una cedula a consultar",
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
        } else {
            int cedulaINT = Integer.parseInt(
                    this.pacientesRegistrados.getTxtCedulaPaciente().getText());
            String cedulaSTR = this.pacientesRegistrados.getTxtCedulaPaciente().getText();

            Paciente paciente = this.pacienteDAO.Consultar(cedulaINT);

            if (paciente != null) {
                /**
                 * Llena la tabla con el contenido.
                 */
                this.pacientesRegistrados.vaciarTablaPacientes();
                this.pacientesRegistrados.llenarTablaPacientes(
                        new Object[]{
                            paciente.getnHistoria(),
                            paciente.getCedula(),
                            paciente.getNombre(),
                            paciente.getApellido(),
                            paciente.getEdad(),
                            paciente.getTelefono(),
                            paciente.getCorreo(),
                            paciente.getGenero(),
                            paciente.embarazoToString(),
                            paciente.alergiasToString()});

                this.pacientesRegistrados.getTxtCedulaPaciente().setText("");
            } else {
                /**
                 * El paciente no existe, por lo tanto muestra el mensaje.
                 */
                JOptionPane.showMessageDialog(
                        null, "La cedula ingresada no esta \n"
                        + "asociada a ningun paciente.\n"
                        + "Considere verificar la cedula",
                        "Paciente no existe!", JOptionPane.INFORMATION_MESSAGE);
                this.pacientesRegistrados.getTxtCedulaPaciente().setText("");
            }

        }
    }

    public void modificarPaciente() {

        int filaSeleccionada = this.pacientesRegistrados.getTablaPacientes().getSelectedRow();

        if (filaSeleccionada != -1) {

            String nombreUsuario = this.pacientesRegistrados.getTablaPacientes().getValueAt(
                    filaSeleccionada, 2).toString();
            int cedulaINT = Integer.parseInt(String.valueOf(
                    this.pacientesRegistrados.getTablaPacientes().getValueAt(filaSeleccionada, 1)));
            String cedulaSTR = this.pacientesRegistrados.getTablaPacientes().getValueAt(
                    filaSeleccionada, 1).toString();

            Paciente resultado = this.pacienteDAO.Consultar(cedulaINT);

            /*
             * Le preguntare al paciente si en realidad desea modificar la categoria.
             */
            int opc
                    = JOptionPane.showConfirmDialog(
                            null,
                            " Desea modificar de los datos del paciente: " + nombreUsuario + "? ",
                            "Confirmar modificacion ",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (opc == 0) {

                this.pacientesRegistrados.getModeloTabla().removeRow(filaSeleccionada);

                if (this.registrarPaciente != null) {//si existe una venta, la cierra.
                    this.registrarPaciente.dispose();
                }
                this.registrarPaciente = new RegistrarPaciente();
                this.registrarPaciente.llenarFormulario(resultado);
                this.registrarPaciente.getBtnGuardar().setVisible(false);
                this.registrarPaciente.getBtnActualizar().setVisible(true);
                this.registrarPaciente.getFormCedula().getTextField().setEditable(false);
                this.registrarPaciente.setVisible(true);

            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }
}
