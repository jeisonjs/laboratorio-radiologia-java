
package vista;

import controlador.Controlador;
import resources.components.BotonPersonalizado;
import resources.components.MenuItem;
import resources.components.PanelImage;

import javax.swing.*;
import java.awt.*;

public final class VistaPrincipal extends JFrame {
    
  private JPanel     panelBotones, panelEditor;
  private PanelImage panelCentral;
  private JMenuBar   barraMenu;
  private JMenu      logoEmpresa, menuInicio, menuRegistros, menuConsultas;
  private MenuItem   itemRegPaciente,itemSolEstudio,itemRegTipoEstudio,
      itemMateriales,itemHisClientes,itemEstRealizados;
  private BotonPersonalizado btnRegistrar, btnSolicitar, btnEstudiosRealizados;
  private ImageIcon imagen =
      new ImageIcon(new ImageIcon(getClass().getResource("/resources/img/b3.jpg")).getImage());
  private ImageIcon logo =
      new ImageIcon(new ImageIcon(getClass().getResource("/resources/img/logosmall7.png")).getImage());
  private ImageIcon btnReg =
      new ImageIcon(new ImageIcon(getClass().getResource("/resources/icons/curriculum.png")).getImage());
  private ImageIcon btnFol =
      new ImageIcon(new ImageIcon(getClass().getResource("/resources/icons/folder.png")).getImage());
  private ImageIcon btnRay =
     new ImageIcon(new ImageIcon(getClass().getResource("/resources/icons/xray.png")).getImage());
  private Controlador CO = new Controlador(this);

  public VistaPrincipal() {

    //Perzonalizar ventana.
    this.setSize(1200, 700);
    this.setTitle("Instituto Universitario de Tecnología de Valencia - FamiSalud ®");
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Barra de menus.
    this.barraMenu = new JMenuBar();
    this.barraMenu.setPreferredSize(new Dimension(0, 52));
    this.barraMenu.setBackground(new Color(244, 244, 244,100)); //Salmon
    this.setJMenuBar(barraMenu);

    this.logoEmpresa = new JMenu("   ");
    this.logoEmpresa.setIcon(logo);
    //this.logoEmpresa.setEnabled(false);
    this.barraMenu.add(logoEmpresa);

    this.menuInicio = new JMenu(" Inicio ");
    //this.menuInicio.setFont(fontBarraM);
    //this.menuInicio.setForeground(fColor);
    this.barraMenu.add(this.menuInicio);

    this.menuRegistros = new JMenu(" Registros ");
    //        this.menuSocio.setFont(fontBarraM);
    //        this.menuSocio.setForeground(fColor);
    this.barraMenu.add(menuRegistros);

    this.itemRegPaciente = new MenuItem("Nuevo paciente");
    this.itemRegPaciente.addActionListener(this.CO);
    this.menuRegistros.add(itemRegPaciente);

    this.itemSolEstudio = new MenuItem("Solicitud de estudio");
    this.itemSolEstudio.addActionListener(this.CO);
    this.menuRegistros.add(itemSolEstudio);

    this.itemRegTipoEstudio = new MenuItem("Tipos de estudios");
    this.itemRegTipoEstudio.addActionListener(this.CO);
    this.menuRegistros.add(itemRegTipoEstudio);

    this.itemMateriales = new MenuItem("Materiales");
    this.itemMateriales.addActionListener(this.CO);
    this.menuRegistros.add(itemMateriales);

    this.menuConsultas = new JMenu(" Consultas ");
    //        this.menuMembresia.setFont(fontBarraM);
    //        this.menuMembresia.setForeground(fColor);
    this.barraMenu.add(menuConsultas);

    this.itemHisClientes = new MenuItem("Historial de pacientes");
    this.itemHisClientes .addActionListener(this.CO);
    this.menuConsultas.add(itemHisClientes);

    this.itemEstRealizados = new MenuItem("Estudios realizados");
    this.itemEstRealizados.addActionListener(this.CO);
    this.menuConsultas.add(itemEstRealizados);

    // Contenedor Principal
    this.panelCentral = new PanelImage();
    this.panelCentral.setImg(this.imagen);
    this.panelCentral.setLayout(new BorderLayout(0, 0));
    //this.panelCentral.setBorder(new EmptyBorder(0, 5, 5, 5));
    this.add(panelCentral, BorderLayout.CENTER);

    this.panelEditor = new JPanel();
    this.panelEditor.setOpaque(false);
    this.panelEditor.setLayout(new BorderLayout());
    this.panelCentral.add(this.panelEditor,BorderLayout.CENTER);

    JPanel P1 = new JPanel();
    P1.setOpaque(false);
    P1.setLayout(new BorderLayout());
    P1.setBackground(new Color(64, 191, 254,200));
    P1.setPreferredSize(new Dimension(0,150));
    JLabel top = new JLabel("IMAGEN");
    top.setHorizontalAlignment(SwingConstants.CENTER);
    top.setVerticalAlignment(SwingConstants.BOTTOM);
    top.setFont(new Font("Helvetica",1,27));
    top.setForeground(Color.white);
    P1.add(top);
    this.panelEditor.add(P1,BorderLayout.NORTH);

    JPanel P2 = new JPanel();
    P2.setOpaque(false);
    P2.setLayout(new BorderLayout());
    P2.setBackground(new Color(4, 205, 253,200));
    JLabel title = new JLabel("RADIOLÓGICA");
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setFont(new Font("Helvetica",1,123));
    title.setForeground(Color.white);
    P2.add(title);
    this.panelEditor.add(P2,BorderLayout.CENTER);

    JPanel P3 = new JPanel();
    P3.setOpaque(false);
    P3.setLayout(new BorderLayout());
    P3.setBackground(new Color(38, 50, 56,150));
    P3.setPreferredSize(new Dimension(0,150));
    JLabel sub = new JLabel("INTEGRAL");
    sub.setHorizontalAlignment(SwingConstants.CENTER);
    sub.setVerticalAlignment(SwingConstants.TOP);
    sub.setFont(new Font("Helvetica",1,50));
    sub.setForeground(Color.white);
    P3.add(sub);
    this.panelEditor.add(P3,BorderLayout.SOUTH);

    this.panelBotones = new JPanel();
    this.panelBotones.setOpaque(false);
    //this.panelBotones.setBackground(Color.BLUE);
    this.panelBotones.setLayout(new GridLayout());
    this.panelBotones.setPreferredSize(new Dimension(0, 100));
    this.panelCentral.add(this.panelBotones, BorderLayout.SOUTH);

    this.btnRegistrar = new BotonPersonalizado();
    this.btnRegistrar.setText("Registrar paciente");
    this.btnRegistrar.setBackground(new Color(38, 50, 56,200));
    this.btnRegistrar.setFont(new Font("Helvetica",0,17));
    this.btnRegistrar.setIcon(this.btnReg);
    this.btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    this.btnRegistrar.setIconTextGap(15);
    this.btnRegistrar.addActionListener(this.CO);
    this.panelBotones.add(this.btnRegistrar);

    this.btnSolicitar = new BotonPersonalizado();
    this.btnSolicitar.setText("Solicitar estudio");
    this.btnSolicitar.setBackground(new Color(38, 50, 56,200));
    this.btnSolicitar.setFont(new Font("Helvetica",0,17));
    this.btnSolicitar.setIcon(this.btnRay);
    this.btnSolicitar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    this.btnSolicitar.setIconTextGap(15);
    this.btnSolicitar.addActionListener(this.CO);
    this.panelBotones.add(this.btnSolicitar);

    this.btnEstudiosRealizados = new BotonPersonalizado();
    this.btnEstudiosRealizados.setText("Estudios realizados");
    this.btnEstudiosRealizados.setBackground(new Color(38, 50, 56,200));
    this.btnEstudiosRealizados.setFont(new Font("Helvetica",0,17));
    this.btnEstudiosRealizados.setIcon(this.btnFol);
    this.btnEstudiosRealizados.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    this.btnEstudiosRealizados.setIconTextGap(15);
    this.btnEstudiosRealizados.addActionListener(this.CO);
    this.panelBotones.add(this.btnEstudiosRealizados);
  }

  public MenuItem getItemRegPaciente() {
    return itemRegPaciente;
  }

  public MenuItem getItemSolEstudio() {
    return itemSolEstudio;
  }

  public MenuItem getItemRegTipoEstudio() {
    return itemRegTipoEstudio;
  }

  public MenuItem getItemMateriales() {
    return itemMateriales;
  }

  public MenuItem getItemHisClientes() {
    return itemHisClientes;
  }

  public MenuItem getItemEstRealizados() {
    return itemEstRealizados;
  }

  public BotonPersonalizado getBtnRegistrar() {
    return btnRegistrar;
  }

  public BotonPersonalizado getBtnSolicitar() {
    return btnSolicitar;
  }

  public BotonPersonalizado getBtnEstudiosRealizados() {
    return btnEstudiosRealizados;
  }

    public static void main(String[] args) {

    VistaPrincipal vp = new VistaPrincipal();
    vp.setVisible(true);
  }
}
