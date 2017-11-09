/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.materiales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.MaterialDAO;
import modelo.dto.MaterialDTO;
import report.material.reporteMaterial;
import vista.Materiales;

/**
 *
 * @author Jafeht
 */
public class BotonesMateriales implements ActionListener {

    private Materiales ventanaMateriales;
    private ValidarDatosMateriales validarDatosMateriales;
    private MaterialDAO     materialDAO;
    private reporteMaterial reporteMaterial;

    public BotonesMateriales(Materiales ventanaMateriales) {
        this.ventanaMateriales = ventanaMateriales;
        this.validarDatosMateriales = new ValidarDatosMateriales(this.ventanaMateriales);
        this.materialDAO = new MaterialDAO();
        this.reporteMaterial = new reporteMaterial();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaMateriales.getBtnGuardar()) {
            System.out.println("Boton Guardar");

            this.registrarMaterial();
            this.obtenerMateriales();
            this.ventanaMateriales.limpiarFormulario();
        }

        if (e.getSource() == ventanaMateriales.getBtnModificar()) {
            System.out.println("Boton modificar");

            this.modificarPaciente();
        }

        if (e.getSource() == ventanaMateriales.getBtnActualizar()) {
            System.out.println("Boton Actualizar");

            this.actualizarUsuario();
            this.obtenerMateriales();
            this.ventanaMateriales.limpiarFormulario();
            this.ventanaMateriales.getBtnGuardar().setVisible(true);
            this.ventanaMateriales.getBtnActualizar().setVisible(false);
            this.ventanaMateriales.getBtnEliminar().setVisible(true);
            this.ventanaMateriales.getBtnModificar().setVisible(true);
        }

        if (e.getSource() == ventanaMateriales.getBtnEliminar()) {
            System.out.println("Boton Eliminar");

            this.eliminarMaterial();
            this.obtenerMateriales();
        }

        if (e.getSource() == ventanaMateriales.getBtnCancelar()) {
            System.out.println("Boton Cancerlar");

            this.obtenerMateriales();
            this.ventanaMateriales.limpiarFormulario();
            this.ventanaMateriales.getBtnGuardar().setVisible(true);
            this.ventanaMateriales.getBtnActualizar().setVisible(false);
            this.ventanaMateriales.getBtnEliminar().setVisible(true);
            this.ventanaMateriales.getBtnModificar().setVisible(true);
        }

        if (e.getSource() == ventanaMateriales.getBtnReporte()) {
            System.out.println("Boton reporte");
            this.reporteMaterial.generarReporte();
            // Llamado a la clase de reporte.
        }

    }

    public void registrarMaterial() {

        if (this.validarDatosMateriales.ValidarDatos().equals("")) {

            String nombreMaterial = this.ventanaMateriales.obtenerDatos().getNombre();
            MaterialDTO resultado = this.materialDAO.Consultar(nombreMaterial);

            if (resultado == null) {
                /**
                 * Realiza el registro del nuevo usuario si este no existe.
                 */
                this.materialDAO.Ingresar(this.ventanaMateriales.obtenerDatos());

            } else {
                /**
                 * El nombre de usuario existe, por lo tanto pregunta si desea
                 * modificarlo.
                 */
                JOptionPane.showMessageDialog(
                        null, "      El nombre del material ya existe! \n"
                        + "Considere usar otro nombre o modificar el \n"
                        + "Material ya existente.",
                        "Alerta!", JOptionPane.INFORMATION_MESSAGE);
                //this.registrarPaciente.vaciarFormulario();
            }
        } else {

            JOptionPane.showMessageDialog(
                    null, "ERROR!! \n" + this.validarDatosMateriales.ValidarDatos(),
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificarPaciente() {

        int filaSeleccionada = this.ventanaMateriales.getTablaMaterialesReg().getSelectedRow();

        if (filaSeleccionada != -1) {

            String nombreMaterial = this.ventanaMateriales.getTablaMaterialesReg().getValueAt(
                    filaSeleccionada, 1).toString();
            int codigoINT = Integer.parseInt(String.valueOf(
                    this.ventanaMateriales.getTablaMaterialesReg().getValueAt(filaSeleccionada, 0)));
            String codigoSTR = this.ventanaMateriales.getTablaMaterialesReg().getValueAt(
                    filaSeleccionada, 0).toString();

            MaterialDTO resultado = this.materialDAO.Consultar(nombreMaterial);

            /*
             * Le preguntare al paciente si en realidad desea modificar el material.
             */
            int opc
                    = JOptionPane.showConfirmDialog(
                            null,
                            " Desea modificar de los datos del material: " + nombreMaterial + "? ",
                            "Confirmar modificacion ",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (opc == 0) {

                this.ventanaMateriales.getModeloTabla().removeRow(filaSeleccionada);

                this.ventanaMateriales.getBtnGuardar().setVisible(false);
                this.ventanaMateriales.getBtnActualizar().setVisible(true);
                this.ventanaMateriales.getBtnEliminar().setVisible(false);
                this.ventanaMateriales.getBtnModificar().setVisible(false);

                this.ventanaMateriales.llenarFormulario(resultado);

            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

    public void actualizarUsuario() {

        if (this.validarDatosMateriales.ValidarDatos().equals("")) {

            materialDAO.Actualizar(this.ventanaMateriales.obtenerDatos());

        } else {
            JOptionPane.showMessageDialog(
                    null, "ERROR!! \n" + this.validarDatosMateriales.ValidarDatos(),
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Desactivar paciente?
    public void eliminarMaterial() {

        int filaSeleccionada = this.ventanaMateriales.getTablaMaterialesReg().getSelectedRow();

        if (filaSeleccionada != -1) {

            String nombreMaterial = this.ventanaMateriales.getTablaMaterialesReg().getValueAt(
                    filaSeleccionada, 1).toString();
            int codigoMaterial = Integer.parseInt(String.valueOf(
                    this.ventanaMateriales.getTablaMaterialesReg().getValueAt(filaSeleccionada, 0)));
            /*
             * Le preguntare al usuario si en realidad desea modificar la categoria.
             */
            int opc
                    = JOptionPane.showConfirmDialog(
                            null,
                            " Desea eliminar de forma permanente el material: " + nombreMaterial + "? ",
                            "Confirmar eliminacion ",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (opc == 0) {

                this.ventanaMateriales.getModeloTabla().removeRow(filaSeleccionada);
                this.materialDAO.Eliminar(codigoMaterial);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

    public void obtenerMateriales() {

        List<MaterialDTO> materiales = this.materialDAO.ConsultarTodos();

        this.ventanaMateriales.vaciarTablaMateriales();
        for (int i = 0; i < materiales.size(); i++) {

            this.ventanaMateriales.llenarTablaMateriales(
                    new Object[]{
                        materiales.get(i).getId(),
                        materiales.get(i).getNombre(),
                        materiales.get(i).getCantidad(),
                        materiales.get(i).getInformacion()});
        }
    }

}
