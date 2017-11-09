package vista;

import controlador.materiales.BotonesMateriales;
import controlador.materiales.TextoMateriales;
import resources.components.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import modelo.dto.MaterialDTO;

public final class Materiales extends JFrame {

    private DefaultTableModel modeloTabla;
    private String[][] datos = {};
    private String[] column = {"Codigo", "Nombre"};
    private JTable TablaMaterialesReg;
    private JScrollPane scrollPane2;
    private JPanel panelFormulario, panelTabla, panelCentral, panelTablaSup;
    private GradientPanel panelBotones;
    private FormTextField formNombre, formCantidad, formCodigo;
    private PanelTextArea informacionPeligro;
    private BotonPersonalizado btnCancelar, btnGuardar, btnActualizar,btnModificar, 
            btnEliminar,btnReporte;

    private BotonesMateriales BM = new BotonesMateriales(this);
    private TextoMateriales TM = new TextoMateriales(this);

    public Materiales() {

        //Perzonalizar ventana.
        this.setTitle("Registrar materiales");
        this.setSize(960, 550);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        this.panelCentral = new JPanel();
        this.panelCentral.setBackground(new Color(241, 241, 241));
        this.panelCentral.setLayout(new BorderLayout(0, 0));
        this.setContentPane(panelCentral);

        this.Formulario();
        this.panelCentral.add(this.panelFormulario, BorderLayout.WEST);
        this.Tabla();
        this.panelCentral.add(this.panelTabla, BorderLayout.CENTER);
        this.Botones();
        this.panelCentral.add(this.panelBotones, BorderLayout.SOUTH);
        
        this.BM.obtenerMateriales();
    }

    private void Formulario() {

        this.panelFormulario = new JPanel();
        //this.panelFormulario.setOpaque(false);
        this.panelFormulario.setBackground(new Color(254, 254, 254));
        this.panelFormulario.setPreferredSize(new Dimension(300, 0));
        this.panelCentral.add(this.panelFormulario, BorderLayout.WEST);

        this.formCodigo = new FormTextField("Codigo");
        this.formCodigo.setVisible(false);
        this.formCodigo.getTextField().setEditable(false);
        this.panelFormulario.add(this.formCodigo);

        this.formNombre = new FormTextField("Nombre del material");
        this.panelFormulario.add(formNombre);

        this.formCantidad = new FormTextField("Cantidad");
        this.formCantidad.setVisible(false);
        this.formCantidad.asignarKeyListener(TM);
        this.panelFormulario.add(formCantidad);

        this.informacionPeligro = new PanelTextArea("Informacion de peligrosidad");
        this.informacionPeligro.setVisible(false);
        this.panelFormulario.add(informacionPeligro);
    }

    private void Tabla() {

        this.panelTabla = new JPanel();
        this.panelTabla.setOpaque(false);
        this.panelTabla.setLayout(new BorderLayout());
        this.panelTabla.setBorder(new EmptyBorder(10, 15, 80, 15));
        this.panelTabla.setBackground(new Color(241, 241, 241));

        this.panelTablaSup = new JPanel();
        this.panelTablaSup.setOpaque(false);
        this.panelTablaSup.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.panelTablaSup.setPreferredSize(new Dimension(0, 100));
        this.panelTablaSup.setBorder(new EmptyBorder(15, 0, 0, 0));
        this.panelTabla.add(this.panelTablaSup, BorderLayout.NORTH);

        this.btnReporte = new BotonPersonalizado();
        this.btnReporte.setText("Reporte");
        this.btnReporte.setBackground(new Color(63, 171, 254));
        this.btnReporte.addActionListener(BM);
        this.panelTablaSup.add(this.btnReporte);

        this.panelTabla.add(this.creandoTabla(), BorderLayout.CENTER);

    }

    private void Botones() {

        this.panelBotones = new GradientPanel();
        //this.panelBotones.setImg(fondoGradiente);
        this.panelBotones.setBackground(new Color(66, 135, 203));
        this.panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));
        //this.panelBotones.setPreferredSize(new Dimension(0,100));
        this.panelBotones.setBorder(new EmptyBorder(15, 15, 15, 15));

        this.btnGuardar = new BotonPersonalizado();
        this.btnGuardar.setText("Guardar");
        this.btnGuardar.setBackground(new Color(63, 171, 254));
        this.btnGuardar.addActionListener(BM);
        this.panelBotones.add(this.btnGuardar);

        this.btnActualizar = new BotonPersonalizado();
        this.btnActualizar.setVisible(false);
        this.btnActualizar.setText("Actualizar");
        this.btnActualizar.setBackground(new Color(63, 171, 254));
        this.btnActualizar.addActionListener(BM);
        this.panelBotones.add(this.btnActualizar);

        this.btnModificar = new BotonPersonalizado();
        this.btnModificar.setText("Modificar");
        this.btnModificar.setBackground(new Color(63, 171, 254));
        this.btnModificar.addActionListener(BM);
        this.panelBotones.add(this.btnModificar);
        
        this.btnEliminar = new BotonPersonalizado();
        this.btnEliminar.setText("Eliminar");
        this.btnEliminar.setBackground(new Color(63, 171, 254));
        this.btnEliminar.addActionListener(BM);
        this.panelBotones.add(this.btnEliminar);
        
        this.btnCancelar = new BotonPersonalizado();
        this.btnCancelar.setText("Cancelar");
        this.btnCancelar.setBackground(new Color(63, 171, 254));
        this.btnCancelar.addActionListener(BM);
        this.panelBotones.add(this.btnCancelar);
    }

    public JScrollPane creandoTabla() {

        modeloTabla = new DefaultTableModel(datos, column);

        scrollPane2 = new JScrollPane();
        TablaMaterialesReg = new JTable();
        TablaMaterialesReg.getTableHeader()
                .setFont(new Font("Acme", 1, 16)); // Encabezado de tablaObras
        //tablaObras.getTableHeader().setBackground(Color.black);
        // tablaObras.getTableHeader().setForeground(Color.BLUE);
        //tablaObras.getTableHeader().setReorderingAllowed(false);// No permite que se muevan las columnas
        TablaMaterialesReg.setModel(modeloTabla);
        scrollPane2.setViewportView(TablaMaterialesReg);
        
        // Enviaando los datos requeridos por el metodo para ocultar
        // las filas.
        // Quiero ocultar las filas 0 y 3.
        //setOcultarColumnasJTable(TablaMaterialesReg,new int[]{0});

        return scrollPane2;
    }
  
    private void setOcultarColumnasJTable(JTable tbl, int columna[]) {

        // Recibe como parametro la Tabla y las filas a ocultar.
        for (int i = 0; i < columna.length; i++) {

            tbl.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
            tbl.getColumnModel().getColumn(columna[i]).setMinWidth(0);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);
        }
    }

    public MaterialDTO obtenerDatos() {
        return new MaterialDTO(
                this.formCodigo.getInt(),
                this.formNombre.getText());
    }

    public void limpiarFormulario() {
        this.formCodigo.setText("");
        this.formNombre.setText("");
    }

    public void llenarFormulario(MaterialDTO material) {
        this.formCodigo.setText(String.valueOf(material.getId()));
        this.formNombre.setText(material.getNombre());
    }

    public void vaciarTablaMateriales() {

        for (int i = 0; i < this.TablaMaterialesReg.getRowCount(); i++) {

            modeloTabla.removeRow(i);
            i -= 1;
        }
    }

    public void llenarTablaMateriales(Object[] datos) {
        this.modeloTabla.addRow(datos);
    }
    
    public BotonPersonalizado getBtnCancelar() {
        return btnCancelar;
    }

    public BotonPersonalizado getBtnGuardar() {
        return btnGuardar;
    }

    public BotonPersonalizado getBtnActualizar() {
        return btnActualizar;
    }

    public BotonPersonalizado getBtnModificar() {
        return btnModificar;
    }

    public BotonPersonalizado getBtnEliminar() {
        return btnEliminar;
    }

    public BotonPersonalizado getBtnReporte() {
        return btnReporte;
    }

    public FormTextField getFormCantidad() {
        return formCantidad;
    }

    public JTable getTablaMaterialesReg() {
        return TablaMaterialesReg;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
    

    public static void main(String[] args) {

        Materiales vp = new Materiales();
        vp.setVisible(true);
    }

}
