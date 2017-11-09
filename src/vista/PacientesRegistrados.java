package vista;

import controlador.paciente.BotonesPacientesReg;
import controlador.paciente.TextoPacientesRegis;
import resources.components.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public final class PacientesRegistrados extends JFrame {

    private DefaultTableModel modeloTabla;
    private String[][] datosUno = {};
    private String[] columnUno = {"N. Historia","Cedula", "Nombre", "Apellido", 
        "Edad","Telefono", "Correo", "Genero", "Embarazo", "Alergias"};
    private JTable tablaPacientes;
    private JScrollPane scrollPane;
    private JPanel panelTitulo,panelTituloIzq,panelTituloDer, panelTabla, 
            panelCentral;
    private GradientPanel panelBotones;
    private JTextField txtCedulaPaciente;
    private BotonPersonalizado btnModificar, btnEliminar,
            btnBuscar,btnReporte;

    private BotonesPacientesReg BPR = new BotonesPacientesReg(this);
    private TextoPacientesRegis TPR = new TextoPacientesRegis(this);

    public PacientesRegistrados() {

        //Perzonalizar ventana.
        this.setTitle("Pacientes registrados");
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
        this.Tabla();
        this.panelCentral.add(this.panelTabla, BorderLayout.CENTER);
        this.Botones();
        this.panelCentral.add(this.panelBotones,BorderLayout.SOUTH);
        
        this.BPR.obtenerPacientes();

    }
    
    public void Titulo() {
    
        this.panelTitulo = new JPanel();
        //this.panelTitulo.setOpaque(false);
        this.panelTitulo.setLayout(new GridLayout());
        //this.panelTitulo.setBackground(new Color(204,254,254));
        this.panelTitulo.setBorder(new EmptyBorder(25, 0, 0, 0));
        this.panelTitulo.setPreferredSize(new Dimension(0, 80));

        this.panelTituloIzq = new JPanel();
        this.panelTituloIzq.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.panelTituloIzq.setBorder(new EmptyBorder(0, 15, 0, 0));
        //panelTituloIzq.setBackground(Color.BLUE);
        this.panelTitulo.add(panelTituloIzq);

        JLabel top = new JLabel("Pacientes registrados");
        top.setHorizontalAlignment(SwingConstants.CENTER);
        top.setVerticalAlignment(SwingConstants.BOTTOM);
        top.setFont(new Font("Helvetica", 1, 20));
        panelTituloIzq.add(top);
        
        this.panelTituloDer = new JPanel();
        this.panelTituloDer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.panelTituloDer.setBorder(new EmptyBorder(0, 0, 0, 15));
        //panelTituloDer.setBackground(Color.BLUE);
        this.panelTitulo.add(panelTituloDer);
        
        this.btnReporte = new BotonPersonalizado();
        this.btnReporte.setText("Reporte");
        this.btnReporte.setBackground(new Color(63, 171, 254));
        this.btnReporte.addActionListener(BPR);
        this.panelTituloDer.add(this.btnReporte);
    }
    
    public void Tabla() {
    
        this.panelTabla = new JPanel();
        //this.panelTabla.setOpaque(false);
        this.panelTabla.setVisible(true);
        this.panelTabla.setLayout(new BorderLayout());
        this.panelTabla.setBorder(new EmptyBorder(5, 15, 80, 15));
        this.panelTabla.setBackground(new Color(241, 241, 241));

        JPanel panel_2 = new JPanel();
        //panel_2.setBackground(Color.DARK_GRAY);
        panel_2.setLayout(null);
        panel_2.setPreferredSize(new Dimension(0, 100));
        this.panelTabla.add(panel_2, BorderLayout.NORTH);

        JLabel lPaciente = new JLabel("Cedula: ");
        lPaciente.setFont(new Font("Tahoma", 1, 14));
        lPaciente.setBounds(12, 15, 150, 15);
        panel_2.add(lPaciente);

        this.txtCedulaPaciente = new JTextField();
        this.txtCedulaPaciente.setForeground(Color.black);
        this.txtCedulaPaciente.setBounds(75, 12, 150, 22);
        this.txtCedulaPaciente.addKeyListener(TPR);
        panel_2.add(txtCedulaPaciente);

        this.btnBuscar = new BotonPersonalizado();
        this.btnBuscar.setText("Buscar paciente");
        this.btnBuscar.setBounds(235, 10, 169, 25);
        this.btnBuscar.setBackground(new Color(63, 171, 254));
        this.btnBuscar.addActionListener(BPR);
        panel_2.add(btnBuscar);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(30, 144, 255));
        separator.setForeground(new Color(30, 144, 255));
        separator.setBounds(12, 73, 705, 15);
        panel_2.add(separator);
        
        this.panelTabla.add(this.creandoTabla(), BorderLayout.CENTER);
    }

    public void Botones() {

        this.panelBotones = new GradientPanel();
        //this.panelBotones.setImg(fondoGradiente);
        this.panelBotones.setBackground(new Color(66, 135, 203));
        this.panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));
        //this.panelBotones.setPreferredSize(new Dimension(0,100));
        this.panelBotones.setBorder(new EmptyBorder(15, 15, 15, 15));

        this.btnModificar = new BotonPersonalizado();
        this.btnModificar.setText("Actualizar");
        this.btnModificar.setBackground(new Color(63, 171, 254));
        this.btnModificar.addActionListener(BPR);
        this.panelBotones.add(this.btnModificar);

        this.btnEliminar = new BotonPersonalizado();
        this.btnEliminar.setText("Eliminar");
        this.btnEliminar.setBackground(new Color(63, 171, 254));
        this.btnEliminar.addActionListener(BPR);
        this.panelBotones.add(this.btnEliminar);
    }

    public JScrollPane creandoTabla() {

        modeloTabla = new DefaultTableModel(datosUno, columnUno);

        scrollPane = new JScrollPane();
        tablaPacientes = new JTable();
        tablaPacientes.getTableHeader()
                .setFont(new Font("Acme", 1, 16)); // Encabezado de tablaObras
        //tablaObras.getTableHeader().setBackground(Color.black);
        // tablaObras.getTableHeader().setForeground(Color.BLUE);
        //tablaObras.getTableHeader().setReorderingAllowed(false);// No permite que se muevan las columnas
        tablaPacientes.setModel(modeloTabla);
        scrollPane.setViewportView(tablaPacientes);

        return scrollPane;
    }

    public void vaciarTablaPacientes() {

        for (int i = 0; i < this.tablaPacientes.getRowCount(); i++) {

            modeloTabla.removeRow(i);
            i -= 1;
        }
    }

    public void llenarTablaPacientes(Object[] datos) {
        this.modeloTabla.addRow(datos);
    }
     
    public BotonPersonalizado getBtnModificar() {
        return btnModificar;
    }

    public BotonPersonalizado getBtnEliminar() {
        return btnEliminar;
    }

    public BotonPersonalizado getBtnBuscar() {
        return btnBuscar;
    }

    public BotonPersonalizado getBtnReporte() {
        return btnReporte;
    }

    public JTextField getTxtCedulaPaciente() {
        return txtCedulaPaciente;
    }

    public void setTxtCedulaPaciente(JTextField txtCedulaPaciente) {
        this.txtCedulaPaciente = txtCedulaPaciente;
    }

    public JTable getTablaPacientes() {
        return tablaPacientes;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
    

    public static void main(String[] args) {

        PacientesRegistrados vp = new PacientesRegistrados();
        vp.setVisible(true);
    }
}
