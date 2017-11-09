package resources.components;


import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que extiende de JPanel y contiene un 
 * JDateChooser y un JLabel un JLabel que mostrara 
 * el titulo formando asi un pequeno formulario.
 * 
 * Estos dos componentes tienen sus respectivos
 * metodos de acceso al contenido del JDateChooser
 * en este caso.
 * 
 * [FORMA DE USO]
 * 
 * # Declaracion.
 *   private FormDateChooser nombreDeLavariable;
 * 
 * # Instanciacion y uso.
 *   nombreDeLavariable = new FormDateChooser();
 * 
 * Created by jeis on 21/05/17.
 */
public class FormDateChooser extends JPanel {

    private JDateChooser fecha;
    private JLabel       labelTitulo;

    public FormDateChooser(String titulo) {
        this.setOpaque(false);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(280,60));

        this.labelTitulo = new JLabel();
        this.labelTitulo.setText(titulo);
        this.labelTitulo.setForeground(new Color(31,31,31));
        this.labelTitulo.setBounds(5, 0, 212, 25);
        this.add(labelTitulo);

        this.fecha = new JDateChooser();
        this.fecha.setBounds(5, 26, 260, 28);
        this.add(fecha);
        
        /**
         * Aqui se le esta enviando la fecha actual al JDateChooser,
         * para que al iniciar alguna ventana que lo contenga este no
         * se muestre vacio.
         */
        Calendar c2 = new GregorianCalendar();
        fecha.setCalendar(c2);
    }
    
    /**
     * Metodo para obtener la fecha seleccionada en el JDateChooser
     * y convertirla a String segun el formato que acepta MySQL
     * (yy-MM-dd).
     * @return fechaSelecionada
     */
    public String getDateFormatSQL() {

        String fechaSelecionada = "";

        try {

            int year  = this.fecha.getCalendar().get(Calendar.YEAR);
            int month = this.fecha.getCalendar().get(Calendar.MONTH) + 1;
            int day   = this.fecha.getCalendar().get(Calendar.DAY_OF_MONTH);

            fechaSelecionada = year + "-" + month + "-" + day;

            return fechaSelecionada;

        } catch (Exception e) {

            return fechaSelecionada;
        }
    }
    
    
    public JDateChooser getDateChooser() {
        return fecha;
    }

    public void setCalendar(Calendar fecha) {
        this.fecha.setCalendar(fecha);
    }
    
    public void setDate(Date fecha) {
        this.fecha.setDate(fecha);
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
