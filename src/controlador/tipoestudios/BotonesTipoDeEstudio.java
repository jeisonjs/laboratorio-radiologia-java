/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.tipoestudios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.dao.MaterialDAO;
import modelo.dao.UtilizaDAO;
import modelo.dao.TipoEstudioDAO;
import modelo.dto.MaterialDTO;
import modelo.dto.TipoDeEstudio;
import report.TipoEstudios.reporteTipoEstudio;
import vista.MaterialesUsados;
import vista.RegistrarTipoEstudio;

/**
 *
 * @author Jafeht
 */
public class BotonesTipoDeEstudio implements ActionListener {

    private RegistrarTipoEstudio     registrarTipoEstudio;
    private MaterialesUsados         materialesUsados;
    private ValidarDatosTipoEstudios validarDatosTipoEstudios;
    private TipoEstudioDAO           tipoEstudioDAO;
    private UtilizaDAO               utilizaDAO;
    private MaterialDAO              materialDAO;
    private reporteTipoEstudio       reporteTipoEstudio;

    public BotonesTipoDeEstudio(RegistrarTipoEstudio registrarTipoEstudio) {
        this.registrarTipoEstudio       = registrarTipoEstudio;
        this.validarDatosTipoEstudios   = new ValidarDatosTipoEstudios(
                this.registrarTipoEstudio);
        this.tipoEstudioDAO             = new TipoEstudioDAO();
        this.materialDAO                = new MaterialDAO();
        this.utilizaDAO                 = new UtilizaDAO();
        this.reporteTipoEstudio         = new reporteTipoEstudio();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarTipoEstudio.getBtnGuardar()) {
            System.out.println("Boton Guardar");

            this.registrarEstudio();
            this.obtenerEstudios();
            this.registrarTipoEstudio.limpiarFormulario();
        }

        if (e.getSource() == registrarTipoEstudio.getBtnModificar()) {
            System.out.println("Boton modificar");

            this.modificarEstudio();
        }

        if (e.getSource() == registrarTipoEstudio.getBtnActualizar()) {
            System.out.println("Boton Actualizar");

            this.actualizarEstudio();
            this.obtenerEstudios();
            this.registrarTipoEstudio.limpiarFormulario();
            this.registrarTipoEstudio.getBtnGuardar().setVisible(true);
            this.registrarTipoEstudio.getBtnActualizar().setVisible(false);
            this.registrarTipoEstudio.getBtnEliminar().setVisible(true);
            this.registrarTipoEstudio.getBtnModificar().setVisible(true);
        }

        if (e.getSource() == registrarTipoEstudio.getBtnEliminar()) {
            System.out.println("Boton Eliminar");

            this.eliminarEstudio();
            this.obtenerEstudios();
        }

        if (e.getSource() == registrarTipoEstudio.getBtnCancelar()) {
            System.out.println("Boton Cancerlar");

            this.obtenerEstudios();
            this.registrarTipoEstudio.limpiarFormulario();
            this.registrarTipoEstudio.getBtnGuardar().setVisible(true);
            this.registrarTipoEstudio.getBtnActualizar().setVisible(false);
            this.registrarTipoEstudio.getBtnEliminar().setVisible(true);
            this.registrarTipoEstudio.getBtnModificar().setVisible(true);
        }

        if (e.getSource() == registrarTipoEstudio.getBtnReporte()) {
            System.out.println("Boton reporte");
            this.reporteTipoEstudio.generarReporte();
            // Llamado a la clase de reporte.
        }
        
        if (e.getSource() == registrarTipoEstudio.getBtnMaterialesUsados()) {
            System.out.println("Boton MaterialesUsados");
            this.consultarMaterialesUsados();
        }

    }

    public void registrarEstudio() {

        if (this.validarDatosTipoEstudios.ValidarDatos().equals("")) {

            String nombreEstudio = this.registrarTipoEstudio.obtenerDatos().getNombre();
            TipoDeEstudio resultado = this.tipoEstudioDAO.Consultar(nombreEstudio);

            if (resultado == null) {
                /**
                 * Realiza el registro del nuevo usuario si este no existe.
                 */
                this.tipoEstudioDAO.Ingresar(this.registrarTipoEstudio.obtenerDatos());
                
                int codigoEstudioREG = this.tipoEstudioDAO.obtenerUltimaAsig();
                
                int[] itemsSeleccionados = 
                    this.registrarTipoEstudio.getListaMateriales().getSelectedIndices();
                for (int i = 0; i < itemsSeleccionados.length; i++) {
                    
                    int codigoMaterial = this.registrarTipoEstudio.getModelo().getElementAt(
                                itemsSeleccionados[i]).getId();
                    
                    this.utilizaDAO.IngresarTablarealiza(codigoMaterial, codigoEstudioREG);
                }
                
                this.obtenerMateriales(this.registrarTipoEstudio.getModelo());

            } else {
                /**
                 * El nombre de usuario existe, por lo tanto pregunta si desea
                 * modificarlo.
                 */
                JOptionPane.showMessageDialog(
                        null, "      El nombre del estudio ya existe! \n"
                        + "Considere usar otro nombre o modificar el \n"
                        + "estudio ya existente.",
                        "Alerta!", JOptionPane.INFORMATION_MESSAGE);
                //this.registrarPaciente.vaciarFormulario();
            }
        } else {

            JOptionPane.showMessageDialog(
                    null, "ERROR!! \n" + this.validarDatosTipoEstudios.ValidarDatos(),
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificarEstudio() {

        int filaSeleccionada = this.registrarTipoEstudio.getTablaEstudios().getSelectedRow();

        if (filaSeleccionada != -1) {

            String nombreEstudio = this.registrarTipoEstudio.getTablaEstudios().getValueAt(
                    filaSeleccionada, 1).toString();
            int codigoINT = Integer.parseInt(String.valueOf(
                    this.registrarTipoEstudio.getTablaEstudios().getValueAt(filaSeleccionada, 0)));
            String codigoSTR = this.registrarTipoEstudio.getTablaEstudios().getValueAt(
                    filaSeleccionada, 0).toString();

            TipoDeEstudio resultado = this.tipoEstudioDAO.Consultar(nombreEstudio);

            /*
             * Le preguntare al paciente si en realidad desea modificar la categoria.
             */
            int opc
                    = JOptionPane.showConfirmDialog(
                            null,
                            "Disculpe! Solo podra modificar el nombre y costo "
                                + "del estudio. \n" 
                                + "Desea continuar modificando: "+ nombreEstudio + "? ",
                            "Confirmar modificacion ",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (opc == 0) {

                this.registrarTipoEstudio.getModeloTabla().removeRow(filaSeleccionada);

                this.registrarTipoEstudio.getBtnGuardar().setVisible(false);
                this.registrarTipoEstudio.getBtnActualizar().setVisible(true);
                this.registrarTipoEstudio.getBtnEliminar().setVisible(false);
                this.registrarTipoEstudio.getBtnModificar().setVisible(false);

                this.registrarTipoEstudio.llenarFormulario(resultado);

            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

    public void actualizarEstudio() {

        if (this.validarDatosTipoEstudios.ValidarDatos().equals("")) {

            tipoEstudioDAO.Actualizar(this.registrarTipoEstudio.obtenerDatos());

        } else {
            JOptionPane.showMessageDialog(
                    null, "ERROR!! \n" + this.validarDatosTipoEstudios.ValidarDatos(),
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Desactivar paciente?
    public void eliminarEstudio() {

        int filaSeleccionada = this.registrarTipoEstudio.getTablaEstudios().getSelectedRow();

        if (filaSeleccionada != -1) {

            String nombreEstudio = this.registrarTipoEstudio.getTablaEstudios().getValueAt(
                    filaSeleccionada, 1).toString();
            int codigoEstudio = Integer.parseInt(String.valueOf(
                    this.registrarTipoEstudio.getTablaEstudios().getValueAt(filaSeleccionada, 0)));
            /*
             * Le preguntare al usuario si en realidad desea modificar la categoria.
             */
            int opc
                    = JOptionPane.showConfirmDialog(
                            null,
                            " Desea eliminar de forma permanente el estudio: " + nombreEstudio + "? ",
                            "Confirmar eliminacion ",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (opc == 0) {

                this.registrarTipoEstudio.getModeloTabla().removeRow(filaSeleccionada);
                this.tipoEstudioDAO.Eliminar(codigoEstudio);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

    public void consultarMaterialesUsados() {
    
        int filaSeleccionada = this.registrarTipoEstudio.getTablaEstudios().getSelectedRow();

        if (filaSeleccionada != -1) {
            
            String codigoSTR = this.registrarTipoEstudio.getTablaEstudios().getValueAt(
                    filaSeleccionada, 0).toString();
            String nombreEstudio = this.registrarTipoEstudio.getTablaEstudios().getValueAt(
                    filaSeleccionada, 1).toString();
            System.out.println(codigoSTR);

            if (this.materialesUsados != null) {//si existe una venta, la cierra.
                this.materialesUsados.dispose();
            }
            
            
            this.materialesUsados = new MaterialesUsados();
            
            List<MaterialDTO> materiales = utilizaDAO.ConsultarTablaRealiza(codigoSTR);
            
            this.materialesUsados.getLabelNombreEstudio().setText(nombreEstudio);
            this.materialesUsados.getLabelCodigoEstudio().setText(codigoSTR);
            
            for (int i = 0; i < materiales.size(); i++) {
                
                System.out.println(materiales.get(i).getNombre());
                
            this.materialesUsados.llenarTablaMateriales(
                    new Object[]{
                        materiales.get(i).getNombre()});
            }
            
            this.materialesUsados.setVisible(true);
            
       
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }
    
    public void obtenerEstudios() {

        List<TipoDeEstudio> estudios = this.tipoEstudioDAO.ConsultarTodos();

        this.registrarTipoEstudio.vaciarTablaEstudios();
        for (int i = 0; i < estudios.size(); i++) {

            this.registrarTipoEstudio.llenarTablaEstudios(
                    new Object[]{
                        estudios.get(i).getId(),
                        estudios.get(i).getNombre(),
                        estudios.get(i).getCosto()});
        }
    }
    
    public void obtenerMateriales(DefaultListModel<MaterialDTO> listaMateriales) {
        
        List<MaterialDTO> materiales = this.materialDAO.ConsultarTodos();
        
        //DefaultListModel modelo = new DefaultListModel();
        listaMateriales.clear();

        for (int i = 0; i < materiales.size(); i++) {
            System.out.println(materiales.get(i).getNombre());
            listaMateriales.addElement(
                    new MaterialDTO(
                            materiales.get(i).getId(), 
                            materiales.get(i).getNombre()));
        }
        //listaMateriales.setModel(modelo);
    }
 
}

