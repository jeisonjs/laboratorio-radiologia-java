package resources.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * Clase que consiste en un JPanel que provee de un
 * JTextField y un JLabel formando asi un pequeno 
 * formulario.
 * 
 * Estos dos componentes tienen sus respectivos
 * metodos de acceso al contenido del FormTextField
 * en este caso.
 * 
 * [FORMA DE USO]
 * 
 * # Declaracion.
 *   private FormTextField nombreDeLavariable;
 * 
 * # Instanciacion y uso.
 *   nombreDeLavariable = new FormTextField();
 * 
 * Created by jeis on 21/05/17.
 */
public class FormTextField extends JPanel {

    private JTextField cajaDeTexto;
    private JLabel     labelTitulo;

    public FormTextField(String titulo) {
        this.setOpaque(false);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(280,60));

        this.labelTitulo = new JLabel();
        this.labelTitulo.setText(titulo);
        this.labelTitulo.setForeground(new Color(31,31,31));
        this.labelTitulo.setBounds(5, 0, 212, 25);
        this.add(labelTitulo);

        this.cajaDeTexto = new JTextField();
        this.cajaDeTexto.setBounds(5, 26, 260, 28);
        this.add(cajaDeTexto);
    }
    
    public void asignarKeyListener(KeyListener listener) {
        this.cajaDeTexto.addKeyListener(listener);
    }
    
    /**
     * Metodo que provee acceso al contenido del JTextField
     * retornando como String su contenido.
     * @return contenido 
     */
    public String getText() {
        return this.cajaDeTexto.getText();
    }
    
    public void setText(String texto) {
        this.cajaDeTexto.setText(texto);
    }
    
    public void setInt(int entero) {
        this.cajaDeTexto.setText(String.valueOf(entero));
    }
    
    public int getInt() {
        
        try {
            return Integer.parseInt(this.cajaDeTexto.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public JTextField getTextField() {
        return this.cajaDeTexto;
    }

    public void setTextField(JTextField cajaDeTexto) {
        this.cajaDeTexto = cajaDeTexto;
    }
    /* public static void main(String args[]) {

        FormTextField PA = new FormTextField();

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
