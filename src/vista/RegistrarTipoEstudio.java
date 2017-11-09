package vista;

import controlador.tipoestudios.BotonesTipoDeEstudio;
import controlador.tipoestudios.TextoTipoDeEstudio;
import resources.components.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import modelo.dto.MaterialDTO;
import modelo.dto.TipoDeEstudio;

public final class RegistrarTipoEstudio extends JFrame {

    private DefaultTableModel modeloTabla;
    private String[][]      datos = {};
    private String[]        column = {"Codigo", "Nombre", "Costo"};
    private JTable          tablaEstudios;
    private JList listaMateriales;
    private DefaultListModel<MaterialDTO> modelo;
    private JScrollPane     scrollPane2,scrollList;
    private JPanel          panelFormulario, panelTabla,panelTablaSur, panelCentral, panelTablaSup;
    private GradientPanel   panelBotones;
    private FormTextField   formNombre, formCosto, formCodigo;
    private BotonPersonalizado btnCancelar, btnGuardar, btnActualizar,btnModificar, 
            btnEliminar,btnReporte,btnMaterialesUsados;

    private BotonesTipoDeEstudio BM = new BotonesTipoDeEstudio(this);
    private TextoTipoDeEstudio   TM = new TextoTipoDeEstudio(this);

    public RegistrarTipoEstudio() {

        //Perzonalizar ventana.
        this.setTitle("Registrar tipo de estudio");
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
        
        this.BM.obtenerEstudios();
        this.BM.obtenerMateriales(this.modelo);
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

        this.formNombre = new FormTextField("Nombre del estudio");
        this.panelFormulario.add(formNombre);

        this.formCosto = new FormTextField("Costo");
        this.formCosto.asignarKeyListener(TM);
        this.panelFormulario.add(formCosto);
        
        JLabel lMateriales = new JLabel("Materiales disponibles");
        this.panelFormulario.add(lMateriales);
        this.scrollList = new JScrollPane();
        this.scrollList.setPreferredSize(new Dimension(260, 120));
        this.panelFormulario.add(this.scrollList);
        modelo = new DefaultListModel();
        this.listaMateriales = new JList();
        this.listaMateriales.setModel(modelo);
        this.listaMateriales.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.scrollList.setViewportView(this.listaMateriales);
        
    }

    private void Tabla() {

        this.panelTabla = new JPanel();
        this.panelTabla.setOpaque(false);
        this.panelTabla.setLayout(new BorderLayout());
        this.panelTabla.setBorder(new EmptyBorder(10, 15, 20, 15));
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
        
        this.panelTablaSur = new JPanel();
        this.panelTablaSur.setOpaque(false);
        this.panelTablaSur.setLayout(new FlowLayout());
        this.panelTablaSur.setBorder(new EmptyBorder(30, 15, 15, 15));
        //this.panelTablaSur.setBackground(new Color(21, 24, 241));
        this.panelTablaSur.setPreferredSize(new Dimension(0, 100));
        this.panelTabla.add(this.panelTablaSur, BorderLayout.SOUTH);
        
        this.btnMaterialesUsados = new BotonPersonalizado();
        this.btnMaterialesUsados.setText("Materiales usados");
        this.btnMaterialesUsados.setBounds(235, 10, 169, 25);
        this.btnMaterialesUsados.setBackground(new Color(63, 171, 254));
        this.btnMaterialesUsados.addActionListener(BM);
        this.panelTablaSur.add(btnMaterialesUsados);
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
        tablaEstudios = new JTable();
        tablaEstudios.getTableHeader()
                .setFont(new Font("Acme", 1, 16)); // Encabezado de tablaObras
        //tablaObras.getTableHeader().setBackground(Color.black);
        // tablaObras.getTableHeader().setForeground(Color.BLUE);
        //tablaObras.getTableHeader().setReorderingAllowed(false);// No permite que se muevan las columnas
        tablaEstudios.setModel(modeloTabla);
        scrollPane2.setViewportView(tablaEstudios);
        
        // Enviaando los datos requeridos por el metodo para ocultar
        // las filas.
        // Quiero ocultar las filas 0 y 3.
       // setOcultarColumnasJTable(tablaEstudios,new int[]{0});

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

    public TipoDeEstudio obtenerDatos() {
        return new TipoDeEstudio(
                this.formCodigo.getInt(),
                this.formNombre.getText(),
                this.formCosto.getInt());
    }

    public void limpiarFormulario() {
        this.formCodigo.setText("");
        this.formNombre.setText("");
        this.formCosto.setText("");
    }

    public void llenarFormulario(TipoDeEstudio estudio) {
        this.formCodigo.setText(String.valueOf(estudio.getId()));
        this.formNombre.setText(estudio.getNombre());
        this.formCosto.setText(String.valueOf(estudio.getCosto()));
    }

    public void vaciarTablaEstudios() {

        for (int i = 0; i < this.tablaEstudios.getRowCount(); i++) {

            modeloTabla.removeRow(i);
            i -= 1;
        }
    }

    public void llenarTablaEstudios(Object[] datos) {
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

    public BotonPersonalizado getBtnMaterialesUsados() {
        return btnMaterialesUsados;
    }

    public FormTextField getFormCosto() {
        return formCosto;
    }

    public JTable getTablaEstudios() {
        return tablaEstudios;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JList getListaMateriales() {
        return listaMateriales;
    }

    public DefaultListModel<MaterialDTO> getModelo() {
        return modelo;
    }
    

    public static void main(String[] args) {

        RegistrarTipoEstudio vp = new RegistrarTipoEstudio();
        vp.setVisible(true);
    }

}
