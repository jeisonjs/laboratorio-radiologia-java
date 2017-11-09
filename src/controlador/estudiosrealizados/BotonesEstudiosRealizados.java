package controlador.estudiosrealizados;

import vista.EstudiosRealizados;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.dao.EstudioRealizadosDAO;
import modelo.dao.PacienteDAO;
import modelo.dao.TipoEstudioDAO;
import modelo.dto.EstudiosRealizadosDTO;
import modelo.dto.Paciente;
import modelo.dto.TipoDeEstudio;
import report.allestudiorealizados.reporteallEstudiorealizados;
import report.estudiorealizadoxpaciente.ReporteEstudiorealizadoXPaciente;

/**
 * Created by jeis on 30/05/17.
 */
public class BotonesEstudiosRealizados implements ActionListener {

    /**
     * JFrame EstudiosRealizados.
     */
    private EstudiosRealizados   estudiosRealizados;
    private PacienteDAO          pacienteDAO;
    private EstudioRealizadosDAO estudioRealizadosDAO;
    private TipoEstudioDAO       tipoEstudioDAO;
    private reporteallEstudiorealizados      reporteEstudiorealizado;
    private ReporteEstudiorealizadoXPaciente reporteXPaciente;
    private ValidarDatosEstudiosRealizados validarDatosEstudios;

    public BotonesEstudiosRealizados(EstudiosRealizados estudiosRealizados) {
        this.estudiosRealizados   = estudiosRealizados;
        this.pacienteDAO          = new PacienteDAO();
        this.estudioRealizadosDAO = new EstudioRealizadosDAO();
        this.tipoEstudioDAO       = new TipoEstudioDAO();
        this.validarDatosEstudios = new ValidarDatosEstudiosRealizados(
                this.estudiosRealizados);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Eventos JRadioButtons.
        if (e.getSource().equals(estudiosRealizados.getRadioButtonXPaciente())) {
            System.out.println("Has elegido "
                    + estudiosRealizados.getRadioButtonXPaciente().getText());

            
            this.estudiosRealizados.getPanelFormularioAuxXFecha().setVisible(false);
            this.estudiosRealizados.getPanelCentral().add(
                    this.estudiosRealizados.getPanelFormularioAuxXPaciente(), BorderLayout.CENTER);
            this.estudiosRealizados.getPanelFormularioAuxXPaciente().setVisible(true);

            /**
             * Desabilitando botones.
             */
//            this.estudiosRealizados.getBtnGuardarXFecha().setVisible(false);
//            this.estudiosRealizados.getBtnEliminarXFecha().setVisible(false);
//            this.estudiosRealizados.getBtnActualizarXFecha().setVisible(false);
//            
            this.estudiosRealizados.getBtnReporteXPaciente().setVisible(true);
            this.estudiosRealizados.getBtnReporteXFecha().setVisible(false);
        }

        if (e.getSource().equals(estudiosRealizados.getRadioButtonXFecha())) {
            System.out.println("Has elegido "
                    + estudiosRealizados.getRadioButtonXFecha().getText());
            
            this.estudiosRealizados.getPanelFormularioAuxXPaciente().setVisible(false);
            this.estudiosRealizados.getPanelCentral().add(
                    this.estudiosRealizados.getPanelFormularioAuxXFecha(), BorderLayout.CENTER);
            this.estudiosRealizados.getPanelFormularioAuxXFecha().setVisible(true);

            /**
             * Habilitando botones.
             */
//            this.estudiosRealizados.getBtnGuardarXFecha().setVisible(true);
//            this.estudiosRealizados.getBtnEliminarXFecha().setVisible(true);
//            this.estudiosRealizados.getBtnActualizarXFecha().setVisible(true);
//            
            this.estudiosRealizados.getBtnReporteXPaciente().setVisible(false);
            this.estudiosRealizados.getBtnReporteXFecha().setVisible(true);
        }

        
        // Buscar por paciente.
        if (e.getSource().equals(this.estudiosRealizados.getBtnBuscarXPaciente())) {
            System.out.println("Boton buscar por paciente");
            
            this.obtenerEstudiosRealizadosXPaciente();
        }
        
        
        // Buscar por fechas.
        if (e.getSource().equals(this.estudiosRealizados.getBtnBuscarXFecha())) {
            System.out.println("Boton buscar fecha");
            if (this.validarDatosEstudios.ValidarDatos().equals("")) {
            
                int seleccion = this.estudiosRealizados.getComboTipoConsulta().
                        getSelectedIndex();

                // Consultar por...
                if (seleccion == 0) {
                    JOptionPane.showMessageDialog(null, 
                            "Seleccione una opcion a consultar");
                }

                // Por estudio.
                if (seleccion == 1) {
                    this.consultarXEstudio();
                }

                 // Por periodo de fecha.
                if (seleccion == 2) {
                    this.consultarXPeriodoFechas(
                            this.estudiosRealizados.obtenerFechaINI(),
                                this.estudiosRealizados.obtenerFechaFIN());
                }

                 // Todos los estudios.
                if (seleccion == 3) {
                    this.obtenerTodosEstudiosRealizados();
                }
                
            } else {
                JOptionPane.showMessageDialog(
                        null, "ERROR!! \n" + this.validarDatosEstudios.ValidarDatos(),
                        "Validando Datos", JOptionPane.ERROR_MESSAGE);
            }
            
            this.estudiosRealizados.getFechaInicio().setCalendar(new GregorianCalendar());
            this.estudiosRealizados.getFechaFinal().setCalendar(new GregorianCalendar());
        }
        
        if (e.getSource().equals(this.estudiosRealizados.getComboTipoConsulta())) {
            System.out.println("Combo tipo consulta");
        
            int seleccion = this.estudiosRealizados.getComboTipoConsulta().
                    getSelectedIndex();
            
            // Consultar por...
            if (seleccion == 0) {
                this.estudiosRealizados.getPanelEstudiosReg().setVisible(false);
                this.estudiosRealizados.getPanelPeriodoFechas().setVisible(false);
            }
            
            // Por estudio.
            if (seleccion == 1) {
                    this.estudiosRealizados.getPanelPeriodoFechas().setVisible(false);
            this.estudiosRealizados.getPanelConsultaCEN().add(
                    this.estudiosRealizados.getPanelEstudiosReg());
            this.estudiosRealizados.getPanelEstudiosReg().setVisible(true);
            }
            
             // Por periodo de fecha.
            if (seleccion == 2) {
                this.estudiosRealizados.getPanelEstudiosReg().setVisible(false);
                this.estudiosRealizados.getPanelPeriodoFechas().setVisible(true);
                this.estudiosRealizados.getFechaInicio().setEnabled(true);
                this.estudiosRealizados.getFechaFinal().setEnabled(true);
            }
            
             // Todos los estudios.
            if (seleccion == 3) {
                this.estudiosRealizados.getPanelEstudiosReg().setVisible(false);
                this.estudiosRealizados.getPanelPeriodoFechas().setVisible(false);
            }
            
        }
              
        if (e.getSource().equals(this.estudiosRealizados.getBtnReporteXPaciente())) {
            System.out.println("Reporte de todos los estudios realizados");
        
            this.generarReporteFactura();
        }
             
        if (e.getSource().equals(this.estudiosRealizados.getBtnReporteXFecha())) {
            System.out.println("Reporte estudios por paciente");
        
            reporteEstudiorealizado = new reporteallEstudiorealizados();
            reporteEstudiorealizado.generarReporte();
        }
        
    }

    public void obtenerEstudiosRealizadosXPaciente() {

        if (this.estudiosRealizados.getTxtCedulaPaciente().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ERROR!! \n"
                    + "Por favor ingrese una cedula a consultar",
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
            this.estudiosRealizados.vaciarTablaXPacientes();
            this.estudiosRealizados.limpiarDatosPaciente();
            
        } else {
            int cedulaINT = Integer.parseInt(
                    this.estudiosRealizados.getTxtCedulaPaciente().getText());
            String cedulaSTR = this.estudiosRealizados.getTxtCedulaPaciente().getText();

            java.util.List<EstudiosRealizadosDTO> estudios = 
                    this.estudioRealizadosDAO.ConsultarTodosXPaciente(cedulaINT);
            Paciente datosPaciente = this.pacienteDAO.Consultar(cedulaINT);

            if (estudios != null && datosPaciente != null) {
                /**
                 * Llena la tabla con el contenido.
                 */
                this.estudiosRealizados.llenarDatosPaciente(datosPaciente);
                this.estudiosRealizados.vaciarTablaXPacientes();
                for (int i = 0; i < estudios.size(); i++) {

                    this.estudiosRealizados.llenarTablaXPaciente(
                            new Object[]{
                                estudios.get(i).getCodigoRealiza(),
                                estudios.get(i).getFechaRealizacion(),
                                estudios.get(i).getEstudio(),
                                estudios.get(i).getCosto()});
                }
            } else {
                /**
                 * El paciente no existe, por lo tanto muestra el mensaje.
                 */
                JOptionPane.showMessageDialog(
                        null, "La cedula ingresada no esta \n"
                        + "asociada a ningun paciente.\n"
                        + "Considere verificar la cedula",
                        "Paciente no existe!", JOptionPane.INFORMATION_MESSAGE);
                this.estudiosRealizados.limpiarFormulario();
                this.estudiosRealizados.vaciarTablaXPacientes();
            }

        }
    }
    
    public void obtenerTodosEstudiosRealizados() {

        java.util.List<EstudiosRealizadosDTO> estudios = this.estudioRealizadosDAO.ConsultarTodos();
        /**
         * Llena la tabla con el contenido.
         */
        this.estudiosRealizados.vaciarTablaXFecha();
        for (int i = 0; i < estudios.size(); i++) {

            this.estudiosRealizados.llenarTablaXFecha(
                    new Object[]{
                        estudios.get(i).getFechaRealizacion(),
                        estudios.get(i).getEstudio(),
                        "N/A",
                        estudios.get(i).getCosto()});
        }
    }

    private void consultarXEstudio() {
        if (this.estudiosRealizados.getComboEstudios().getSelectedIndex()!= 0) {
            java.util.List<EstudiosRealizadosDTO> estudios = 
                    this.estudioRealizadosDAO.ConsultarTodosXEstudio(
                            this.estudiosRealizados.obtenerIdComboEstudios());
            /**
             * Llena la tabla con el contenido.
             */
            this.estudiosRealizados.vaciarTablaXFecha();
            for (int i = 0; i < estudios.size(); i++) {

                this.estudiosRealizados.llenarTablaXFecha(
                        new Object[]{
                            estudios.get(i).getFechaRealizacion(),
                            estudios.get(i).getEstudio(),
                            estudios.get(i).getSumatoriaEstudios(),
                            estudios.get(i).getSumatoriaCosto()});
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                            "Seleccione una opcion a consultar");
        }
    }

    private void consultarXPeriodoFechas(String fechaINI, String fechaFIN) {
        
        java.util.List<EstudiosRealizadosDTO> estudios = 
                this.estudioRealizadosDAO.ConsultarTodosXFechas(fechaINI, fechaFIN);
        /**
         * Llena la tabla con el contenido.
         */
        this.estudiosRealizados.vaciarTablaXFecha();
        for (int i = 0; i < estudios.size(); i++) {

            this.estudiosRealizados.llenarTablaXFecha(
                    new Object[]{
                        estudios.get(i).getFechaRealizacion(),
                        estudios.get(i).getEstudio(),
                        "N/A",
                        estudios.get(i).getCosto()});
        }
    }
    
    public void obtenerEstudios(JComboBox<TipoDeEstudio> comboEstudio) {
        
        java.util.List<TipoDeEstudio> estudios = this.tipoEstudioDAO.ConsultarTodos();
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
    
    public void generarReporteFactura() {

        int filaSeleccionada = this.estudiosRealizados.getTablaXPaciente().getSelectedRow();

        if (filaSeleccionada != -1) {

            String codigo  = this.estudiosRealizados.getTablaXPaciente().getValueAt(
                    filaSeleccionada, 0).toString();
            String fecha   = this.estudiosRealizados.getTablaXPaciente().getValueAt(
                    filaSeleccionada, 1).toString();
            String estudio = this.estudiosRealizados.getTablaXPaciente().getValueAt(
                    filaSeleccionada, 2).toString();
            String costo   = this.estudiosRealizados.getTablaXPaciente().getValueAt(
                    filaSeleccionada, 3).toString();
            
            String nombre  = this.estudiosRealizados.getlNombrePaciente().getText();
            String cedula  = this.estudiosRealizados.getlCedulaPaciente().getText();
            String edad    = this.estudiosRealizados.getlEdadPaciente().getText();
           
            
            this.reporteXPaciente = new ReporteEstudiorealizadoXPaciente();
            this.reporteXPaciente.generarReporte(codigo,fecha,estudio,costo,
                    nombre,cedula,edad);
            
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

}
