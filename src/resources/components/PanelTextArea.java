package resources.components;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by jeis on 21/05/17.
 */
public class PanelTextArea extends JPanel {

    private JTextArea txtContenido;
    private JLabel     labelNombre;

    public PanelTextArea(String titulo) {
        this.setOpaque(false);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(280,120));

        this.labelNombre = new JLabel();
        this.labelNombre.setText(titulo);
        this.labelNombre.setForeground(new Color(31,31,31));
        this.labelNombre.setBounds(5, 0, 212, 25);
        this.add(labelNombre);

        this.txtContenido = new JTextArea();
        this.txtContenido.setBackground(new Color(241,241,241));
        this.txtContenido.setBounds(5, 26, 260, 80);
        this.txtContenido.setBorder(new LineBorder(new Color(41,41,41),1,true));
        this.add(txtContenido);
    }

    public JTextArea getTextField() {
        return txtContenido;
    }
    
    public String getText() {
        return this.txtContenido.getText();
    }
    
    public void setText(String contenido) {
        this.txtContenido.setText(contenido);
    }

    public void setTextField(JTextArea txtContenido) {
        this.txtContenido = txtContenido;
    }
    /* public static void main(String args[]) {

        PanelFormulario PA = new PanelFormulario();

        JFrame frame = new JFrame("Probando panel individual...");
        frame.setLayout(new GridLayout());
        frame.add(PA);
        frame.pack();
        frame.setBackground(Color.darkGray);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }*/
}
