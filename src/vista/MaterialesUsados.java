package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import resources.components.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import report.materialesusados.reporteMaterialUsado;

public final class MaterialesUsados extends JFrame {

    private DefaultTableModel   modeloTabla;
    private String[][]          datosUno = {};
    private String[]            columnUno = {"Materiales"};
    private JTable              tablaMateriales;
    private JScrollPane         scrollPane;
    private JPanel              panelTitulo,panelTituloIzq, panelTabla, 
            panelCentral;
    private JLabel              labelNombreEstudio,labelCodigoEstudio;
    private GradientPanel       panelBotones;
    private BotonPersonalizado  btnBuscar,btnReporte;
    private reporteMaterialUsado reporMaterial;

    
    public MaterialesUsados() {

        //Perzonalizar ventana.
        this.setTitle("Materiales usados");
        this.setSize(520, 400);
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
        
        this.obtenerMateriales();

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

        JLabel top = new JLabel("Materiales usados por: ");
        top.setHorizontalAlignment(SwingConstants.CENTER);
        top.setVerticalAlignment(SwingConstants.BOTTOM);
        top.setFont(new Font("Helvetica", 1, 17));
        panelTituloIzq.add(top);
        
        labelNombreEstudio = new JLabel("");
        labelNombreEstudio.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombreEstudio.setVerticalAlignment(SwingConstants.BOTTOM);
        labelNombreEstudio.setFont(new Font("Helvetica", 1, 17));
        panelTituloIzq.add(labelNombreEstudio);
        
        labelCodigoEstudio = new JLabel("");
        labelCodigoEstudio.setVisible(false);
        labelCodigoEstudio.setHorizontalAlignment(SwingConstants.CENTER);
        labelCodigoEstudio.setVerticalAlignment(SwingConstants.BOTTOM);
        labelCodigoEstudio.setFont(new Font("Helvetica", 1, 17));
        panelTituloIzq.add(labelCodigoEstudio);
    }
    
    public void Tabla() {
    
        this.panelTabla = new JPanel();
        //this.panelTabla.setOpaque(false);
        //this.panelTabla.setVisible(true);
        this.panelTabla.setLayout(new BorderLayout());
        this.panelTabla.setBorder(new EmptyBorder(5, 15, 20, 15));
        this.panelTabla.setBackground(new Color(241, 241, 241));
        
        this.panelTabla.add(this.creandoTabla(), BorderLayout.CENTER);
    }

    public void Botones() {

        this.panelBotones = new GradientPanel();
        //this.panelBotones.setImg(fondoGradiente);
        this.panelBotones.setBackground(new Color(66, 135, 203));
        this.panelBotones.setLayout(new FlowLayout());
        //this.panelBotones.setPreferredSize(new Dimension(0,100));
        this.panelBotones.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        this.btnReporte = new BotonPersonalizado();
        this.btnReporte.setText("Reporte");
        this.btnReporte.setBackground(new Color(63, 171, 254));
        this.btnReporte.addActionListener((e) -> {
            this.reporMaterial = new reporteMaterialUsado();
            this.reporMaterial.generarReporte(labelCodigoEstudio.getText());
        });
        this.panelBotones.add(this.btnReporte);

    }

    public JScrollPane creandoTabla() {

        modeloTabla = new DefaultTableModel(datosUno, columnUno);

        scrollPane = new JScrollPane();
        tablaMateriales = new JTable();
        tablaMateriales.getTableHeader()
                .setFont(new Font("Acme", 1, 16)); // Encabezado de tablaObras
        //tablaObras.getTableHeader().setBackground(Color.black);
        // tablaObras.getTableHeader().setForeground(Color.BLUE);
        //tablaObras.getTableHeader().setReorderingAllowed(false);// No permite que se muevan las columnas
//        tablaMateriales.getColumnModel().getColumn(0).setCellEditor(new JListEditor());
        tablaMateriales.setRowHeight(20);
        tablaMateriales.setModel(modeloTabla);
        scrollPane.setViewportView(tablaMateriales);

        return scrollPane;
    }

    public void vaciarTablaMateriales() {

        for (int i = 0; i < this.tablaMateriales.getRowCount(); i++) {

            modeloTabla.removeRow(i);
            i -= 1;
        }
    }

    
    private void obtenerMateriales() {
        
    }
    
    public void llenarTablaMateriales(Object[] datos) {
        this.modeloTabla.addRow(datos);
    }
    
    public BotonPersonalizado getBtnBuscar() {
        return btnBuscar;
    }
    
    public JTable getTablaMateriales() {
        return tablaMateriales;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JLabel getLabelNombreEstudio() {
        return labelNombreEstudio;
    }

    public JLabel getLabelCodigoEstudio() {
        return labelCodigoEstudio;
    }
    
    public static void main(String[] args) {

        MaterialesUsados vp = new MaterialesUsados();
        vp.setVisible(true);
    }

}
