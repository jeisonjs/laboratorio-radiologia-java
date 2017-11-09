/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.paciente.BotonesRegistrarPaciente;
import controlador.paciente.TextoRegistrarPaciente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import modelo.dto.Paciente;
import resources.components.BotonPersonalizado;
import resources.components.FormComboBox;
import resources.components.FormDateChooser;
import resources.components.FormRadioButton;
import resources.components.GradientPanel;
import resources.components.FormTextField;
import resources.components.Utilidades;

/**
 *
 * @author jeis
 */
public class RegistrarPaciente extends JFrame {
  private JPanel panelFormulario,panelFormularioAuxIzq,panelFormularioAuxDer,
          panelCentral, panelInformacion;
  private JLabel lTituloGenero;
  //private JComboBox comboGenero;
  private GradientPanel panelBotones;
  private JTextArea     informacion;
  private FormTextField      formCedula, formNombre, formApellido, formTelefono, 
          formCorreo,formNHistoria;
  private FormRadioButton    formAlergias, formEmbarazo;
  private FormComboBox       formGenero;
  private FormDateChooser    formFechaNac;
  private BotonPersonalizado btnCancelar, btnGuardar,btnActualizar;
  private Color foreground   = new Color(31,31,31);
  private String [] genero = {"Seleccione una opcion...", 
        "Masculino","Femenino"}; 
  private static final int CERO =0; 
  /**
   * Controlador de esta clase.
   */
  private BotonesRegistrarPaciente BRP = new BotonesRegistrarPaciente(this);
  private TextoRegistrarPaciente   TRP = new TextoRegistrarPaciente(this);

    public RegistrarPaciente() {
        
        //Perzonalizar ventana.
        this.setTitle("Registrar paciente");
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
        
        this.formNHistoria = new FormTextField("N. de Historia");
        this.formNHistoria.setVisible(false);
        this.formNHistoria.getTextField().setEditable(false);
        this.panelFormularioAuxIzq.add(this.formNHistoria);
        
        this.formCedula = new FormTextField("Cedula");
        this.formCedula.asignarKeyListener(TRP);
        this.panelFormularioAuxIzq.add(this.formCedula);
        
        this.formNombre = new FormTextField("Nombre");
        this.formNombre.asignarKeyListener(TRP);
        this.panelFormularioAuxIzq.add(this.formNombre);
        
        this.formApellido = new FormTextField("Apellido");
        this.formApellido.asignarKeyListener(TRP);
        this.panelFormularioAuxIzq.add(this.formApellido);
        
        this.formFechaNac = new FormDateChooser("Fecha de nacimiento");
        this.panelFormularioAuxIzq.add(this.formFechaNac);
        
        this.formTelefono = new FormTextField("Telefono");
        this.formTelefono.asignarKeyListener(TRP);
        this.panelFormularioAuxIzq.add(this.formTelefono);
        
        
        /**
         * Panel Formulario derecho.
         */
        this.panelFormularioAuxDer = new JPanel();
        this.panelFormularioAuxDer.setOpaque(false);
        this.panelFormulario.add(this.panelFormularioAuxDer);
        

        this.formCorreo = new FormTextField("Correo");
        this.panelFormularioAuxDer.add(this.formCorreo);

        this.formGenero = new FormComboBox();
        this.formGenero.getLabelTitulo().setText("Genero");
        this.formGenero.getComboBox().setModel(new DefaultComboBoxModel(
             new String[] {"Seleccione una opcion...","Masculino","Femenino"}));
        this.panelFormularioAuxDer.add(this.formGenero);
        
        this.formEmbarazo = new FormRadioButton("Embarazo");
        this.panelFormularioAuxDer.add(this.formEmbarazo);
        
        this.formAlergias = new FormRadioButton("Alergias");
        this.panelFormularioAuxDer.add(this.formAlergias);
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
              "\nPara registrar sus pacientes necesita un mínimo de datos obligatorios,\n"
            + "una vez obtenidos debe pulsar en la opción de, “Guardar” que figura\n"
            + "en la barra inferior. \n \n ");
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
        this.btnCancelar.addActionListener(BRP);
        this.panelBotones.add(this.btnCancelar);

        this.btnGuardar = new BotonPersonalizado();
        this.btnGuardar.setText("Guardar");
        this.btnGuardar.setBackground(new Color(63, 171, 254));
        this.btnGuardar.addActionListener(BRP);
        this.panelBotones.add(this.btnGuardar);
        
        this.btnActualizar = new BotonPersonalizado();
        this.btnActualizar.setVisible(false);
        this.btnActualizar.setText("Actualizar");
        this.btnActualizar.setBackground(new Color(63, 171, 254));
        this.btnActualizar.addActionListener(BRP);
        this.panelBotones.add(this.btnActualizar);
    }

    public Paciente obtenerDatos() {
        return new Paciente(
                this.formNHistoria.getInt(),
                this.formCedula.getInt(), 
                this.formNombre.getText(), 
                this.formApellido.getText(),
                this.formFechaNac.getDateFormatSQL(),
                this.formTelefono.getText(),
                this.formCorreo.getText(),
                this.formGenero.getText(),
                this.formEmbarazo.isSelected(),
                this.formAlergias.isSelected());
    }
    
    public void limpiarFormulario() {
        this.formNHistoria.setText("");
        this.formCedula.setText(""); 
        this.formNombre.setText(""); 
        this.formApellido.setText("");
        this.formFechaNac.setCalendar(new GregorianCalendar());
        this.formTelefono.setText("");
        this.formCorreo.setText("");
        this.formGenero.setSelectedIndex(0);
        this.formEmbarazo.setSelectedYes(true);
        this.formAlergias.setSelectedYes(true);
    }
    
    public void llenarFormulario(Paciente datosPaciente) {
        
        this.formNHistoria.setInt(  datosPaciente.getnHistoria());
        this.formCedula.setInt(     datosPaciente.getCedula()); 
        this.formNombre.setText(    datosPaciente.getNombre()); 
        this.formApellido.setText(  datosPaciente.getApellido());
      try {
          this.formFechaNac.setDate(Utilidades.enviarFecha(datosPaciente.getFechaNac()));
      } catch (ParseException ex) {
          Logger.getLogger(RegistrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
      }
        this.formTelefono.setText(  datosPaciente.getTelefono());
        this.formCorreo.setText(    datosPaciente.getCorreo());
        this.formGenero.setSelectedIndex(0);
        this.formEmbarazo.setSelectedNo(true);
        this.formAlergias.setSelectedNo(true);
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

    public FormTextField getFormCedula() {
        return formCedula;
    }

    public FormTextField getFormNombre() {
        return formNombre;
    }

    public FormTextField getFormApellido() {
        return formApellido;
    }

    public FormTextField getFormTelefono() {
        return formTelefono;
    }

    public FormDateChooser getFormFechaNac() {
        return formFechaNac;
    }
    
    public static void main(String[] args) {

    RegistrarPaciente vp = new RegistrarPaciente();
    vp.setVisible(true);
  }
}
