package vista;

import com.toedter.calendar.JDateChooser;
import controlador.estudiosrealizados.BotonesEstudiosRealizados;
import controlador.estudiosrealizados.TextoEstudRealizados;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import modelo.dto.Paciente;
import modelo.dto.TipoDeEstudio;
import resources.components.BotonPersonalizado;
import resources.components.GradientPanel;

public final class EstudiosRealizados extends JFrame {

    private DefaultTableModel modeloTablaXPaciente, modeloTablaXFecha;
    private String[][] datosXPaciente = {};
    private String[][] datosXFecha    = {};
    private String[] columnXPaciente  = {"Codigo","Fecha", "Estudio", "Costo"};
    private String[] columnXFecha     = {"Fecha", "Estudio","Cantidad","Total"};
    private JTable tablaXPaciente, tablaXFecha;
    private JScrollPane scrollPane, scrollPane2;
    private JPanel panelTitulo, panelFormularioAuxXFecha,
            panelFormularioAuxXPaciente, panelCentral, panelTituloDer,
            panelPeriodoFechas,panelPeriodoFechasNOR,
            panelPeriodoFechasSOU,panelConsultaCEN,
            panelEstudiosReg,panelEstudiosRegNOR,panelEstudiosRegSOU;
    private JLabel lCedula, lNombrePaciente, lCedulaPaciente, lEdadPaciente,
            lEstudiosReg,lEstudiosDis;
    private ButtonGroup buttonGroup;
    private JRadioButton radioButtonXPaciente, radioButtonXFecha, radioAllEstudios;

    private GradientPanel panelBotones;
    private JTextField txtCedulaPaciente;
    private JComboBox<TipoDeEstudio> comboEstudios;
    private JComboBox comboTipoConsulta;
    private BotonPersonalizado btnGuardarXFecha, btnActualizarXFecha,
            btnEliminarXFecha, btnBuscarXPaciente, btnBuscarXFecha, btnReporteXPaciente,
            btnReporteXFecha;
    private JDateChooser fechaInicio, fechaFinal;
    private GridBagConstraints gbc = new GridBagConstraints();

    private BotonesEstudiosRealizados BER = new BotonesEstudiosRealizados(this);
    private TextoEstudRealizados TER = new TextoEstudRealizados(this);

    public EstudiosRealizados() {

        //Perzonalizar ventana.
        this.setTitle("Estudios realizados");
        this.setSize(960, 550);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        this.panelCentral = new JPanel();
        this.panelCentral.setBackground(new Color(241, 241, 241));
        this.panelCentral.setLayout(new BorderLayout(0, 0));
        this.setContentPane(panelCentral);

        this.Titulo();
        this.panelCentral.add(this.panelTitulo, BorderLayout.NORTH);
        this.FormularioXPaciente();
        this.panelCentral.add(this.panelFormularioAuxXPaciente, BorderLayout.CENTER);
        this.FormularioXFecha();
        this.Botones();
        this.panelCentral.add(this.panelBotones, BorderLayout.SOUTH);

        this.llenarComboEstudios();
    }

    private void Titulo() {

        this.panelTitulo = new JPanel();
        //this.panelTitulo.setOpaque(false);
        this.panelTitulo.setLayout(new GridLayout(2, 1));
        this.panelTitulo.setBackground(new Color(204, 254, 254));
        this.panelTitulo.setPreferredSize(new Dimension(0, 100));
        this.panelCentral.add(this.panelTitulo, BorderLayout.NORTH);

        JPanel auxUno = new JPanel();
        auxUno.setLayout(new BorderLayout());
        //auxUno.setBackground(Color.BLUE);
        this.panelTitulo.add(auxUno);

        JLabel top = new JLabel("Estudios realizados");
        top.setHorizontalAlignment(SwingConstants.CENTER);
        top.setVerticalAlignment(SwingConstants.BOTTOM);
        top.setFont(new Font("Helvetica", 1, 20));
        auxUno.add(top, BorderLayout.CENTER);

        JPanel auxDos = new JPanel();
        auxDos.setLayout(new BorderLayout());
        //auxDos.setBackground(Color.DARK_GRAY);
        this.panelTitulo.add(auxDos);

        JPanel panelbuttonGroup = new JPanel();
        auxDos.add(panelbuttonGroup, BorderLayout.CENTER);

        buttonGroup = new ButtonGroup();
        radioButtonXPaciente = new JRadioButton("Consultar por paciente");
        radioButtonXPaciente.setOpaque(false);
        radioButtonXPaciente.setSelected(true);
        //radioButtonXPaciente.setForeground(Color.WHITE);
        radioButtonXPaciente.setBounds(8, 29, 97, 23);
        radioButtonXPaciente.addActionListener(BER);
        buttonGroup.add(radioButtonXPaciente);
        panelbuttonGroup.add(radioButtonXPaciente);

        radioButtonXFecha = new JRadioButton("Otras consultas");
        radioButtonXFecha.setOpaque(false);
        //radioButtonYes.setForeground(Color.WHITE);
        radioButtonXFecha.setBounds(123, 29, 117, 23);
        radioButtonXFecha.addActionListener(BER);
        buttonGroup.add(radioButtonXFecha);
        panelbuttonGroup.add(radioButtonXFecha);

        this.panelTituloDer = new JPanel();
        this.panelTituloDer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.panelTituloDer.setBorder(new EmptyBorder(0, 0, 0, 15));
        //panelTituloDer.setBackground(Color.BLUE);
        auxDos.add(panelTituloDer, BorderLayout.EAST);

        this.btnReporteXPaciente = new BotonPersonalizado();
        this.btnReporteXPaciente.setText("Reporte por paciente");
        this.btnReporteXPaciente.setBackground(new Color(63, 171, 254));
        this.btnReporteXPaciente.addActionListener(BER);
        this.panelTituloDer.add(this.btnReporteXPaciente);

        this.btnReporteXFecha = new BotonPersonalizado();
        this.btnReporteXFecha.setVisible(false);
        this.btnReporteXFecha.setText("Reporte todos los estudios realizados");
        this.btnReporteXFecha.setBackground(new Color(63, 171, 254));
        this.btnReporteXFecha.addActionListener(BER);
        this.panelTituloDer.add(this.btnReporteXFecha);
    }

    private void FormularioXPaciente() {

        this.panelFormularioAuxXPaciente = new JPanel();
        //this.panelFormularioAuxXPaciente.setOpaque(false);
        this.panelFormularioAuxXPaciente.setLayout(new BorderLayout());
        this.panelFormularioAuxXPaciente.setBorder(new EmptyBorder(5, 15, 80, 15));
        this.panelFormularioAuxXPaciente.setBackground(new Color(241, 241, 241));
        this.panelCentral.add(this.panelFormularioAuxXPaciente, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        //panel_2.setBackground(Color.DARK_GRAY);
        panel_2.setLayout(null);
        panel_2.setPreferredSize(new Dimension(0, 100));
        this.panelFormularioAuxXPaciente.add(panel_2, BorderLayout.NORTH);

        lCedula = new JLabel("Cedula: ");
        lCedula.setFont(new Font("Tahoma", 1, 14));
        lCedula.setBounds(12, 15, 150, 15);
        panel_2.add(lCedula);

        txtCedulaPaciente = new JTextField();
        txtCedulaPaciente.setForeground(Color.black);
        txtCedulaPaciente.setBounds(75, 12, 150, 22);
        txtCedulaPaciente.addKeyListener(TER);
        panel_2.add(txtCedulaPaciente);

        btnBuscarXPaciente = new BotonPersonalizado();
        btnBuscarXPaciente.setText("Buscar paciente");
        btnBuscarXPaciente.setBounds(235, 10, 169, 25);
        btnBuscarXPaciente.setBackground(new Color(63, 171, 254));
        btnBuscarXPaciente.addActionListener(BER);
        panel_2.add(btnBuscarXPaciente);

        JLabel lPaciente = new JLabel("Paciente:");
        lPaciente.setBounds(12, 58, 70, 15);
        panel_2.add(lPaciente);

        lNombrePaciente = new JLabel();
        lNombrePaciente.setBounds(113, 58, 94, 15);
        panel_2.add(lNombrePaciente);

        lCedula = new JLabel("Cedula:");
        lCedula.setBounds(258, 58, 70, 15);
        panel_2.add(lCedula);

        lCedulaPaciente = new JLabel();
        lCedulaPaciente.setBounds(353, 58, 70, 15);
        panel_2.add(lCedulaPaciente);

        JLabel lEdad = new JLabel("Edad:");
        lEdad.setBounds(461, 58, 70, 15);
        panel_2.add(lEdad);

        lEdadPaciente = new JLabel();
        lEdadPaciente.setBounds(543, 58, 70, 15);
        panel_2.add(lEdadPaciente);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(30, 144, 255));
        separator.setForeground(new Color(30, 144, 255));
        separator.setBounds(12, 73, 705, 15);
        panel_2.add(separator);

        /**
         * JTable
         */
        this.panelFormularioAuxXPaciente.add(this.creandoTabla(), BorderLayout.CENTER);

    }

    private void FormularioXFecha() {

        // Por periodo de fechas
        this.panelFormularioAuxXFecha = new JPanel();
        //this.panelFormularioAuxXFecha.setOpaque(false);
        this.panelFormularioAuxXFecha.setLayout(new BorderLayout());
        this.panelFormularioAuxXFecha.setBorder(new EmptyBorder(5, 15, 0, 15));
        this.panelFormularioAuxXFecha.setBackground(new Color(241, 241, 241));
        //this.panelCentral.add(this.panelFormularioAuxXFecha, BorderLayout.CENTER);

        // Opciones para consultar.
        JPanel panel_3 = new JPanel();
        //panel_3.setBackground(Color.DARK_GRAY);
        panel_3.setLayout(new GridLayout());
        panel_3.setPreferredSize(new Dimension(0, 100));
        this.panelFormularioAuxXFecha.add(panel_3, BorderLayout.NORTH);
        JPanel panelConsultaIZQ = new JPanel();
        panelConsultaIZQ.setLayout(new GridBagLayout());
        panelConsultaIZQ.setOpaque(true);
        panel_3.add(panelConsultaIZQ);
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel consultarXEstudio = new JLabel();
        consultarXEstudio.setText("Tipos de consultas");
        consultarXEstudio.setBounds(15, 8, 115, 24);
        panelConsultaIZQ.add(consultarXEstudio, gbc);
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        /**
         * Si se le agrega o quita contenido al combobox se veran afectadas las
         * consultas a la base de datos ya que estoy trabajando con la posicion
         * de cada palabra.
         * 
         * 1 - Por estudio
         * 2 - Por periodo de feacha
         * 3 - Todos los estudios
         * 
         * Revisar igualmente el evento del combobox y btBuscar en la clase 
         * BotonesEstudiosRealizados.
         * y
         */
        comboTipoConsulta = new JComboBox();
        comboTipoConsulta.setModel(new DefaultComboBoxModel(
                new String[]{"Consultar por...", "Por estudio", "Por periodo de fecha",
                    "Todos los estudios"}));
        comboTipoConsulta.setBounds(15, 30, 160, 24);
        comboTipoConsulta.addActionListener(BER);
        panelConsultaIZQ.add(comboTipoConsulta, gbc);

        
        // Tipos de consultas disponibles.
        panelConsultaCEN = new JPanel();
        panelConsultaCEN.setLayout(new BorderLayout());
        panelConsultaCEN.setOpaque(true);
        panel_3.add(panelConsultaCEN);
        
        this.panelesConsulta();
        panelConsultaCEN.add(this.panelPeriodoFechas);


        // Boton para buscar.
        JPanel panelConsultaDER = new JPanel();
        panelConsultaDER.setLayout(new GridBagLayout());
        panelConsultaDER.setOpaque(true);
        panel_3.add(panelConsultaDER);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        btnBuscarXFecha = new BotonPersonalizado();
        btnBuscarXFecha.setText("Buscar");
        btnBuscarXFecha.setBounds(750, 30, 130, 25);
        btnBuscarXFecha.setBackground(new Color(63, 171, 254));
        btnBuscarXFecha.addActionListener(BER);
        panelConsultaDER.add(btnBuscarXFecha, gbc);

        /**
         * Separador del fondo.
         */
//        JSeparator separator2 = new JSeparator();
//        separator2.setBackground(new Color(30, 144, 255));
//        separator2.setForeground(new Color(30, 144, 255));
//        separator2.setBounds(12, 73, 895, 15);
//        panel_3.add(separator2);
        this.panelFormularioAuxXFecha.add(this.creandoTablaDos(), BorderLayout.CENTER);

        JPanel panel4 = new JPanel();
        //panel4.setBackground(Color.BLUE);
        panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel4.setPreferredSize(new Dimension(0, 50));
        this.panelFormularioAuxXFecha.add(panel4, BorderLayout.SOUTH);

        JLabel lTotal = new JLabel("Total:                                                                        ");
        panel4.add(lTotal);
    }
    
    public void panelesConsulta() {
    
        panelEstudiosReg = new JPanel();
        panelEstudiosReg.setEnabled(false);
  	panelEstudiosReg.setBackground(Color.GRAY);
  	panelEstudiosReg.setLayout(new GridLayout(2, 1));
  	//add(panelEstudiosReg);
  	panelEstudiosRegNOR = new JPanel();
  	panelEstudiosReg.add(panelEstudiosRegNOR);
  	panelEstudiosRegNOR.setLayout(new BorderLayout(0, 0));
  	lEstudiosReg = new JLabel("Estudios registrados");
  	lEstudiosReg.setVerticalAlignment(SwingConstants.BOTTOM);
  	lEstudiosReg.setHorizontalAlignment(SwingConstants.CENTER);
  	panelEstudiosRegNOR.add(lEstudiosReg, BorderLayout.CENTER);
  	panelEstudiosRegSOU = new JPanel();
  	panelEstudiosReg.add(panelEstudiosRegSOU);
  	comboEstudios = new JComboBox();
  	comboEstudios.setPreferredSize(new Dimension(getPreferredSize().width/2, 24));
  	panelEstudiosRegSOU.add(comboEstudios);
  	
        
  	panelPeriodoFechas = new JPanel();
        panelPeriodoFechas.setEnabled(false);
        panelPeriodoFechas.setBackground(Color.ORANGE);
  	panelPeriodoFechas.setLayout(new GridLayout(2, 1));
  	//add(panelPeriodoFechas);
  	panelPeriodoFechasNOR = new JPanel();
  	panelPeriodoFechas.add(panelPeriodoFechasNOR);
  	panelPeriodoFechasNOR.setLayout(new BorderLayout(0, 0));
  	lEstudiosDis = new JLabel("Periodos de fecha");
  	lEstudiosDis.setHorizontalAlignment(SwingConstants.CENTER);
  	lEstudiosDis.setVerticalAlignment(SwingConstants.BOTTOM);
  	panelPeriodoFechasNOR.add(lEstudiosDis, BorderLayout.CENTER);
  	panelPeriodoFechasSOU = new JPanel();
  	panelPeriodoFechas.add(panelPeriodoFechasSOU);
  	fechaInicio = new JDateChooser();
        fechaInicio.setCalendar(new GregorianCalendar());
        fechaInicio.setEnabled(false);
        fechaInicio.setPreferredSize(new Dimension(120, 24));
  	panelPeriodoFechasSOU.add(fechaInicio);
  	fechaFinal = new JDateChooser();
        fechaFinal.setCalendar(new GregorianCalendar());
        fechaFinal.setEnabled(false);
        fechaFinal.setPreferredSize(new Dimension(120, 24));
  	panelPeriodoFechasSOU.add(fechaFinal);
    }

    public void Botones() {

        this.panelBotones = new GradientPanel();
        //this.panelBotones.setImg(fondoGradiente);
        this.panelBotones.setBackground(new Color(66, 135, 203));
        this.panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));
        //this.panelBotones.setPreferredSize(new Dimension(0,100));
        this.panelBotones.setBorder(new EmptyBorder(15, 15, 15, 15));
//
//        this.btnGuardarXFecha = new BotonPersonalizado();
//        this.btnGuardarXFecha.setText("Guardar");
//        this.btnGuardarXFecha.setVisible(false);
//        this.btnGuardarXFecha.setBackground(new Color(63, 171, 254));
//        this.panelBotones.add(this.btnGuardarXFecha);
//
//        this.btnActualizarXFecha = new BotonPersonalizado();
//        this.btnActualizarXFecha.setText("Actualizar");
//        this.btnActualizarXFecha.setVisible(false);
//        this.btnActualizarXFecha.setBackground(new Color(63, 171, 254));
//        this.panelBotones.add(this.btnActualizarXFecha);
//
//        this.btnEliminarXFecha = new BotonPersonalizado();
//        this.btnEliminarXFecha.setText("Eliminar");
//        this.btnEliminarXFecha.setVisible(false);
//        this.btnEliminarXFecha.setBackground(new Color(63, 171, 254));
//        this.panelBotones.add(this.btnEliminarXFecha);
    }

    public JScrollPane creandoTabla() {

        modeloTablaXPaciente = new DefaultTableModel(datosXPaciente, columnXPaciente);

        scrollPane = new JScrollPane();
        tablaXPaciente = new JTable();
        tablaXPaciente.getTableHeader()
                .setFont(new Font("Acme", 1, 16)); // Encabezado de tablaObras
        //tablaObras.getTableHeader().setBackground(Color.black);
        // tablaObras.getTableHeader().setForeground(Color.BLUE);
        //tablaObras.getTableHeader().setReorderingAllowed(false);// No permite que se muevan las columnas
        tablaXPaciente.setModel(modeloTablaXPaciente);
        scrollPane.setViewportView(tablaXPaciente);

        return scrollPane;
    }

    public JScrollPane creandoTablaDos() {

        modeloTablaXFecha = new DefaultTableModel(datosXFecha, columnXFecha);

        scrollPane2 = new JScrollPane();
        tablaXFecha = new JTable();
        tablaXFecha.getTableHeader()
                .setFont(new Font("Acme", 1, 16)); // Encabezado de tablaObras
        //tablaObras.getTableHeader().setBackground(Color.black);
        // tablaObras.getTableHeader().setForeground(Color.BLUE);
        //tablaObras.getTableHeader().setReorderingAllowed(false);// No permite que se muevan las columnas
        tablaXFecha.setModel(modeloTablaXFecha);
        scrollPane2.setViewportView(tablaXFecha);

        return scrollPane2;
    }

    public void limpiarFormulario() {
        this.txtCedulaPaciente.setText("");
    }

    public void vaciarTablaXPacientes() {

        for (int i = 0; i < this.tablaXPaciente.getRowCount(); i++) {

            modeloTablaXPaciente.removeRow(i);
            i -= 1;
        }
    }

    public void llenarTablaXPaciente(Object[] datos) {
        this.modeloTablaXPaciente.addRow(datos);
    }

    public void vaciarTablaXFecha() {

        for (int i = 0; i < this.tablaXFecha.getRowCount(); i++) {

            modeloTablaXFecha.removeRow(i);
            i -= 1;
        }
    }

    public void llenarTablaXFecha(Object[] datos) {
        this.modeloTablaXFecha.addRow(datos);
    }

    public void llenarDatosPaciente(Paciente datos) {

        this.lCedulaPaciente.setText(String.valueOf(datos.getCedula()));
        this.lNombrePaciente.setText(datos.getNombre()+" "+datos.getApellido());
        this.lEdadPaciente.setText(String.valueOf(datos.getEdad()));
    }
    
    public void limpiarDatosPaciente() {

        this.txtCedulaPaciente.setText("");
        this.lCedulaPaciente.setText("");
        this.lNombrePaciente.setText("");
        this.lEdadPaciente.setText("");
    }
    
    public String obtenerFechaINI() {

        String fechaINI = "";

        try {

            int year  = this.fechaInicio.getCalendar().get(Calendar.YEAR);
            int month = this.fechaInicio.getCalendar().get(Calendar.MONTH) + 1;
            int day   = this.fechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);

            fechaINI = year + "-" + month + "-" + day;

            return fechaINI;

        } catch (Exception e) {

            return fechaINI;
        }
    }
     
    public String obtenerFechaFIN() {

        String fechaINI = "";

        try {

            int year  = this.fechaFinal.getCalendar().get(Calendar.YEAR);
            int month = this.fechaFinal.getCalendar().get(Calendar.MONTH) + 1;
            int day   = this.fechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH);

            fechaINI = year + "-" + month + "-" + day;

            return fechaINI;

        } catch (Exception e) {

            return fechaINI;
        }
    }
    
    public int obtenerIdComboEstudios() {
        return this.comboEstudios.getItemAt(this.comboEstudios.getSelectedIndex()).getId();
    }

    public void llenarComboEstudios() {

        this.BER.obtenerEstudios(this.comboEstudios);
    }

    public JRadioButton getRadioButtonXPaciente() {
        return radioButtonXPaciente;
    }

    public JRadioButton getRadioButtonXFecha() {
        return radioButtonXFecha;
    }

    public JRadioButton getRadioAllEstudios() {
        return radioAllEstudios;
    }

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public JPanel getPanelFormularioAuxXFecha() {
        return panelFormularioAuxXFecha;
    }

    public JPanel getPanelFormularioAuxXPaciente() {
        return panelFormularioAuxXPaciente;
    }

    public JTextField getTxtCedulaPaciente() {
        return txtCedulaPaciente;
    }

    public void setTxtCedulaPaciente(JTextField txtCedulaPaciente) {
        this.txtCedulaPaciente = txtCedulaPaciente;
    }

    public BotonPersonalizado getBtnGuardarXFecha() {
        return btnGuardarXFecha;
    }

    public void setBtnGuardarXFecha(BotonPersonalizado btnGuardarXFecha) {
        this.btnGuardarXFecha = btnGuardarXFecha;
    }

    public BotonPersonalizado getBtnActualizarXFecha() {
        return btnActualizarXFecha;
    }

    public void setBtnActualizarXFecha(BotonPersonalizado btnActualizarXFecha) {
        this.btnActualizarXFecha = btnActualizarXFecha;
    }

    public BotonPersonalizado getBtnEliminarXFecha() {
        return btnEliminarXFecha;
    }

    public void setBtnEliminarXFecha(BotonPersonalizado btnEliminarXFecha) {
        this.btnEliminarXFecha = btnEliminarXFecha;
    }

    public BotonPersonalizado getBtnBuscarXPaciente() {
        return btnBuscarXPaciente;
    }

    public BotonPersonalizado getBtnBuscarXFecha() {
        return btnBuscarXFecha;
    }

    public BotonPersonalizado getBtnReporteXPaciente() {
        return btnReporteXPaciente;
    }

    public BotonPersonalizado getBtnReporteXFecha() {
        return btnReporteXFecha;
    }

    public JPanel getPanelPeriodoFechas() {
        return panelPeriodoFechas;
    }

    public JPanel getPanelEstudiosReg() {
        return panelEstudiosReg;
    }
    
    public JComboBox getComboTipoConsulta() {
        return comboTipoConsulta;
    }

    public JPanel getPanelConsultaCEN() {
        return panelConsultaCEN;
    }

    public JDateChooser getFechaInicio() {
        return fechaInicio;
    }

    public JDateChooser getFechaFinal() {
        return fechaFinal;
    }

    public DefaultTableModel getModeloTablaXPaciente() {
        return modeloTablaXPaciente;
    }

    public JTable getTablaXPaciente() {
        return tablaXPaciente;
    }

    public JLabel getlNombrePaciente() {
        return lNombrePaciente;
    }

    public JLabel getlCedulaPaciente() {
        return lCedulaPaciente;
    }

    public JLabel getlEdadPaciente() {
        return lEdadPaciente;
    }

    public JComboBox<TipoDeEstudio> getComboEstudios() {
        return comboEstudios;
    }

    public static void main(String[] args) {

        EstudiosRealizados vp = new EstudiosRealizados();
        vp.setVisible(true);
    }
}
