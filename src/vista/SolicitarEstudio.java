/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.solicitudestudio.BotonesSolicitarEstudio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import controlador.solicitudestudio.TextoSolicEstudio;
import modelo.dto.Paciente;
import modelo.dto.SolicitudEstudio;
import modelo.dto.TipoDeEstudio;
import resources.components.BotonPersonalizado;
import resources.components.FormDateChooser;
import resources.components.FormTextField;
import resources.components.GradientPanel;

/**
 *
 * @author jeis
 */
public class SolicitarEstudio extends JFrame {
  private JPanel panelFormulario,panelFormularioAuxIzq,panelFormularioAuxDer,
          panelCentral, panelInformacion,formEstudio,formPago;
  private JLabel lTituloEstudio,lTituloPago;
  private JComboBox comboPago;
  private JComboBox<TipoDeEstudio> comboEstudio;
  private GradientPanel panelBotones;
  private JTextArea informacion;
  private FormTextField formCedula, formNombre, formApellido,formCosto,formCodigo;
//  private FormComboBox  formEstudio,formPago;
  private FormDateChooser formFecha;
  private BotonPersonalizado btnCancelar, btnGuardar,btnBuscar;
  private Color foreground = new Color(31,31,31);
  
  /**
   * Controlador de esta clase.
   */
  private BotonesSolicitarEstudio BSE = new BotonesSolicitarEstudio(this);
  private TextoSolicEstudio       TSE = new TextoSolicEstudio(this);

    public SolicitarEstudio() {
        
        //Perzonalizar ventana.
        this.setTitle("Solicitud de estudio");
        this.setSize(570, 564);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        this.panelCentral = new JPanel();
        this.panelCentral.setLayout(new BorderLayout());
        this.panelCentral.setBackground(new Color(254,254,254));
        this.setContentPane(this.panelCentral);
        
        this.Formulario();
        this.panelCentral.add(this.panelFormulario,BorderLayout.NORTH);
        this.Informacion();
        this.panelCentral.add(this.panelInformacion,BorderLayout.CENTER);
        this.Botones();
        this.panelCentral.add(this.panelBotones,BorderLayout.SOUTH);
        
        this.llenarComboEstudios();
    }
    
    /**
     * Metodo que genera el panel que contendra el formulario.
     */
    public void Formulario() {
    
        this.panelFormulario = new JPanel();
        this.panelFormulario.setOpaque(false);
        this.panelFormulario.setLayout(new GridLayout());
        this.panelFormulario.setBorder(new EmptyBorder(0, 5, 0, 5));
        this.panelFormulario.setPreferredSize(new Dimension(0, 390));
        
        /**
         * Panel Formulario Izquierdo.
         */
        this.panelFormularioAuxIzq = new JPanel();
        this.panelFormularioAuxIzq.setOpaque(false);
        this.panelFormulario.add(this.panelFormularioAuxIzq);
        
        this.formCodigo = new FormTextField("Codigo");
        this.formCodigo.setVisible(false);
        this.formCodigo.getTextField().setEditable(false);
        this.panelFormularioAuxIzq.add(this.formCodigo);
        
        this.formCedula = new FormTextField("Cedula");
        this.formCedula.asignarKeyListener(TSE);
        this.panelFormularioAuxIzq.add(this.formCedula);
        
        this.btnBuscar = new BotonPersonalizado();
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.setBackground(new Color(63, 171, 254));
        this.btnBuscar.setPreferredSize(new Dimension(105, 25));
        this.btnBuscar.addActionListener(BSE);
        this.panelFormularioAuxIzq.add(this.btnBuscar);
        
        this.formNombre = new FormTextField("Nombre");
        this.formNombre.getTextField().setEditable(false);
        this.formNombre.asignarKeyListener(TSE);
        this.panelFormularioAuxIzq.add(this.formNombre);
        
        this.formApellido = new FormTextField("Apellido");
        this.formApellido.getTextField().setEditable(false);
        this.formApellido.asignarKeyListener(TSE);
        this.panelFormularioAuxIzq.add(this.formApellido);
        
//        this.formEstudio = new FormComboBox("Tipo de estudio");
//        this.panelFormularioAuxIzq.add(formEstudio);

        this.formEstudio = new JPanel();
        this.formEstudio.setOpaque(false);
        this.formEstudio.setLayout(null);
        this.formEstudio.setPreferredSize(new Dimension(280,60));
        this.panelFormularioAuxIzq.add(this.formEstudio);

        this.lTituloEstudio = new JLabel("Tipo de estudio");
        this.lTituloEstudio.setForeground(new Color(31,31,31));
        this.lTituloEstudio.setBounds(5, 0, 212, 25);
        this.formEstudio.add(lTituloEstudio);

        this.comboEstudio = new JComboBox();
        this.comboEstudio.setBounds(5, 26, 260, 28);
        this.comboEstudio.setEnabled(false);
//        this.comboEstudio.setModel(new DefaultComboBoxModel(
//                new String[] {"Seleccione una opcion...","Densimetria osea",
//                    "Mamografia","Ecografia abdominal","Ecografia mamaria",
//                    "Ecografia pelvica","RX de torax"}));
        this.comboEstudio.addActionListener(BSE);
        this.formEstudio.add(comboEstudio);
   
        
        /**
         * Panel Formulario derecho.
         */
        this.panelFormularioAuxDer = new JPanel();
        this.panelFormularioAuxDer.setOpaque(false);
        this.panelFormulario.setBorder(new EmptyBorder(0, 15, 0, 5));
        this.panelFormulario.add(this.panelFormularioAuxDer);
        
        this.formCosto = new FormTextField("Costo");
        this.formCosto.getTextField().setEditable(false);
        this.panelFormularioAuxDer.add(formCosto);

//        this.formPago = new FormComboBox("Tipo de pago");
//        this.panelFormularioAuxDer.add(formPago);

        this.formPago = new JPanel();
        this.formPago.setOpaque(false);
        this.formPago.setLayout(null);
        this.formPago.setPreferredSize(new Dimension(280,60));
        this.panelFormularioAuxDer.add(this.formPago);

        this.lTituloPago = new JLabel("Tipo de pago");
        this.lTituloPago.setForeground(new Color(31,31,31));
        this.lTituloPago.setBounds(5, 0, 212, 25);
        this.formPago.add(lTituloPago);

        this.comboPago = new JComboBox();
        this.comboPago.setBounds(5, 26, 260, 28);
        this.comboPago.setEnabled(false);
        this.comboPago.setModel(new DefaultComboBoxModel(
                new String[] {"Seleccione una opcion...","Efectivo",
                    "Tarjeta de credito","Tarjeta de debito","Cheque"}));
        this.formPago.add(comboPago);

        this.formFecha = new FormDateChooser("Fecha");
        this.formFecha.getDateChooser().setEnabled(false);
        this.panelFormularioAuxDer.add(formFecha);
    }
    
    /**
     * Metodo que genera el panel que contendra el JTextArea
     * con informacion de ayuda.
     */
    public void Informacion() {
    
        this.panelInformacion = new JPanel();
        this.panelInformacion.setOpaque(false);
        this.panelInformacion.setLayout(new FlowLayout(0));
        this.panelInformacion.setBorder(new EmptyBorder(0, 15, 0, 5));
        
        this.informacion = new JTextArea();
        this.informacion.setOpaque(false);
        this.informacion.setEditable(false);
        this.informacion.setForeground(foreground);
        this.informacion.setText(
        "\n\n  Aqui podra registrar el estudio que desea realizarase un paciente.\n \n ");
        this.panelInformacion.add(informacion);
    }
    
    /**
     * Metodo que genera el panel que contendra los botones
     * de la ventana.
     */
    public void Botones() {
    
        this.panelBotones = new GradientPanel();
        this.panelBotones.setBackground(Color.CYAN);
        this.panelBotones.setLayout(new FlowLayout(2));
        this.panelBotones.setBorder(new EmptyBorder(15, 15, 15, 15));
                
        this.btnCancelar = new BotonPersonalizado();
        this.btnCancelar.setText("Cancelar");
        this.btnCancelar.setBackground(new Color(63, 171, 254));
        this.btnCancelar.addActionListener(BSE);
        this.panelBotones.add(this.btnCancelar);

        this.btnGuardar = new BotonPersonalizado();
        this.btnGuardar.setText("Guardar");
        this.btnGuardar.setBackground(new Color(63, 171, 254));
        this.btnGuardar.addActionListener(BSE);
        this.panelBotones.add(this.btnGuardar);
    }

    public void obtenerCostoEstudio() {
        this.formCosto.setText(String.valueOf(
            this.comboEstudio.getItemAt(
              comboEstudio.getSelectedIndex()).getCosto()));
    }
    
    public SolicitudEstudio obtenerDatos() {
        return new SolicitudEstudio(
                this.formCodigo.getInt(),
                this.formCedula.getInt(),
                this.formNombre.getText(),
                this.formApellido.getText(),
                this.comboEstudio.getItemAt(
                        comboEstudio.getSelectedIndex()).getId(),
                this.formCosto.getInt(),
                this.comboPago.getSelectedItem().toString(),
                this.formFecha.getDateFormatSQL());
    }
    
    public void limpiarFormulario() {
        this.formCodigo.setText("");
        this.formCedula.setText("");
        this.formNombre.setText("");
        this.formApellido.setText("");
        this.comboEstudio.setSelectedIndex(0);
        this.formCosto.setText("");
        this.comboPago.setSelectedIndex(0);
        //this.formFecha.getDateFormatSQL());
    }
    
    public void llenarFormulario(SolicitudEstudio datos) {
        this.formCodigo.setText(String.valueOf(datos.getCodigo()));
        this.formCedula.setText(String.valueOf(datos.getCedula()));
        this.formNombre.setText(datos.getNombre());
        this.formApellido.setText(datos.getApellido());
        this.comboEstudio.setSelectedIndex(0);
        this.formCosto.setText(String.valueOf(datos.getCosto()));
        this.comboPago.setSelectedIndex(0);
        //this.formFecha.getDateFormatSQL());
    }
    
    public void llenarFormulario(Paciente datos) {
        this.formCedula.setText(String.valueOf(datos.getCedula()));
        this.formNombre.setText(datos.getNombre());
        this.formApellido.setText(datos.getApellido());
    }
    
    public void llenarComboEstudios() {

        this.BSE.obtenerEstudios(this.comboEstudio);
    }
    
    public JComboBox getComboEstudio() {
        return comboEstudio;
    }

    public JComboBox getComboPago() {
        return comboPago;
    }

    public BotonPersonalizado getBtnCancelar() {
        return btnCancelar;
    }

    public BotonPersonalizado getBtnGuardar() {
        return btnGuardar;
    }

    public BotonPersonalizado getBtnBuscar() {
        return btnBuscar;
    }

    public FormTextField getFormCedula() {
        return formCedula;
    }

    public FormTextField getFormNombre() {
        return formNombre;
    }

    public FormTextField getFormApellido() {
        return formApellido;
    }

    public FormTextField getFormCosto() {
        return formCosto;
    }

    public FormDateChooser getFormFecha() {
        return formFecha;
    }
    
    
    public static void main(String[] args) {

    SolicitarEstudio vp = new SolicitarEstudio();
    vp.setVisible(true);
  }
}
