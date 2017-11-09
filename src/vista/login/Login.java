package vista.login;

import controlador.login.ControladorLogin;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import modelo.dto.Usuario;

public class Login extends JFrame {

    private JPanel PanelLoggin, PWest, PEast, Pcontenedor;
    private JPanel Pserador1, Pserador2, Pserador3, Pserador4;
    private Container c;
    private JLabel JLTitulo, JLUsuario, JLContracena;
    private JTextField JTxtUsuario;
    private JPasswordField JTxtContracena;
    private JButton BTNAseptar, BtnSalir;

    public GridBagConstraints GridCons;
    public int AlturaPantalla, AnchoPantalla, a, b;
    public Toolkit Pantalla;
    public Dimension TamanoPantalla;

    private Image img, logo;
    private URL ImgUrl, logoUrl;

    private ControladorLogin CL = new ControladorLogin(this);

    public Login() {

        tamano();
        control();
        vista();

        AlturaPantalla = TamanoPantalla.height;
        AnchoPantalla = TamanoPantalla.width;
        this.setUndecorated(true);
        this.setSize(AnchoPantalla / 2, AlturaPantalla / 2);
        this.setLocation(AnchoPantalla / 4, AlturaPantalla / 4);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Login");
        this.setResizable(false);

        ImgUrl = this.getClass().getResource("/resources/img/INI5.png");
        img = new ImageIcon(ImgUrl).getImage();

        logoUrl = this.getClass().getResource("/resources/img/logo.png");
        logo = new ImageIcon(logoUrl).getImage();
    }

    public void tamano() {
        Pantalla = Toolkit.getDefaultToolkit();
        TamanoPantalla = Pantalla.getScreenSize();
    }

    public void vista() {
        fondo();
        c = getContentPane();
        c.add(fondo);
    }

    public void control() {
    }

    public JPanel fondo
            = new JPanel() {
        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            fondo.updateUI();
        }
    };

    public void fondo() {
        panelLoggin();
        separdores();

        fondo.setLayout(new FlowLayout());
        fondo.setPreferredSize(new Dimension(TamanoPantalla.width, TamanoPantalla.height));
        fondo.setLayout(new BoxLayout(fondo, BoxLayout.X_AXIS));

        PWest = new JPanel();
        PWest.setOpaque(false);
        PWest.setLayout(new BorderLayout());
        PWest.setPreferredSize(new Dimension(TamanoPantalla.width / 3, TamanoPantalla.height / 5));
        PWest.add(PanelLoggin, BorderLayout.CENTER);
        PWest.add(Pserador1, BorderLayout.NORTH);
        PWest.add(Pserador2, BorderLayout.WEST);
        PWest.add(Pserador3, BorderLayout.EAST);
        PWest.add(Pserador4, BorderLayout.SOUTH);
        fondo.add(PWest);

        PEast = new JPanel();
        PEast.setOpaque(false);
        PEast.setPreferredSize(new Dimension(TamanoPantalla.width / 2, TamanoPantalla.height / 4));
        fondo.add(PEast);
    }

    public void panelLoggin() {
        GridCons = new GridBagConstraints();
        GridCons.insets = new Insets(8, 8, 8, 8);

        PanelLoggin = new JPanel();
        PanelLoggin.setLayout(new GridBagLayout());
        PanelLoggin.setBackground(new Color(20, 80, 250, 150));

        JLTitulo = new JLabel();
        JLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitulo.setIcon(new ImageIcon(getClass().getResource("/resources/img/logo2.png")));
        JLTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JLTitulo.setIconTextGap(15);

        GridCons.gridx = 1;
        GridCons.gridy = 0;
        GridCons.gridwidth = 5;

        PanelLoggin.add(JLTitulo, GridCons);

        JLUsuario = new JLabel("Usuario");
        GridCons.gridx = 0;
        GridCons.gridy = 1;

        PanelLoggin.add(JLUsuario, GridCons);

        JLContracena = new JLabel("contracena");
        GridCons.gridx = 2;
        GridCons.gridy = 2;

        GridCons.gridwidth = 1;
        GridCons.gridheight = 1;
        PanelLoggin.add(JLContracena, GridCons);

        JTxtUsuario = new JTextField();
        GridCons.gridx = 4;
        GridCons.gridy = 1;

        GridCons.gridheight = 1;
        GridCons.gridwidth = 5;

        GridCons.weightx = 1;
        GridCons.fill = GridBagConstraints.HORIZONTAL;
        PanelLoggin.add(JTxtUsuario, GridCons);

        JTxtContracena = new JPasswordField();
        GridCons.gridx = 4;
        GridCons.gridy = 2;

        GridCons.gridheight = 1;
        GridCons.gridwidth = 2;
        PanelLoggin.add(JTxtContracena, GridCons);

        BTNAseptar = new JButton("Ingresar");
        BTNAseptar.addActionListener(CL);
        GridCons.gridx = 1;
        GridCons.gridy = 3;

        GridCons.fill = GridBagConstraints.NONE;
        PanelLoggin.add(BTNAseptar, GridCons);

        BtnSalir = new JButton("Salir");
        BtnSalir.addActionListener(CL);
        GridCons.gridx = 4;
        GridCons.gridy = 3;

        PanelLoggin.add(BtnSalir, GridCons);
    }

    public void separdores() {
        Pserador1 = new JPanel();
        Pserador1.setOpaque(false);
        Pserador1.setPreferredSize(
                new Dimension(TamanoPantalla.height / 20, TamanoPantalla.width / 25));
        Pserador2 = new JPanel();
        Pserador2.setOpaque(false);
        Pserador2.setPreferredSize(
                new Dimension(TamanoPantalla.height / 20, TamanoPantalla.width / 25));
        Pserador3 = new JPanel();
        Pserador3.setOpaque(false);
        Pserador3.setPreferredSize(
                new Dimension(TamanoPantalla.height / 20, TamanoPantalla.width / 25));
        Pserador4 = new JPanel();
        Pserador4.setOpaque(false);
        Pserador4.setPreferredSize(
                new Dimension(TamanoPantalla.height / 20, TamanoPantalla.width / 25));
    }
    
    public String obtenerPassword(){
    char[] arrayC = this.JTxtContracena.getPassword();
    String pass = new  String(arrayC);  
    return pass;
    
    }

    public Usuario obtenerDatos() {
        return new Usuario(this.JTxtUsuario.getText(), this.obtenerPassword());
    }

    public JButton getBTNAseptar() {
        return BTNAseptar;
    }

    public JButton getBtnSalir() {
        return BtnSalir;
    }

    public static void main(String[] args) {
        Login l = new Login();
    }

}
