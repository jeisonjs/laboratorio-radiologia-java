package resources.components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Clase que extiende de JPanel y contiene un 
 * JComboBox y un JLabel un JLabel que mostrara
 * el titulo formando asi un pequeno formulario.
 * 
 * Estos dos componentes tienen sus respectivos
 * metodos de acceso al contenido del JComboBox
 * en este caso.
 * 
 * [FORMA DE USO]
 * 
 * # Declaracion.
 *   private FormComboBox nombreDeLavariable;
 * 
 * # Instanciacion y uso.
 *   nombreDeLavariable = new FormComboBox();
 * 
 * Created by jeis on 21/05/17.
 */
public class FormComboBox extends JPanel {

    private JComboBox comboBox;
    private JLabel    labelTitulo;

    public FormComboBox() {

        this.setOpaque(false);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(280,60));

        this.labelTitulo = new JLabel();
        this.labelTitulo.setForeground(new Color(31,31,31));
        this.labelTitulo.setBounds(5, 0, 212, 25);
        this.add(labelTitulo);

        this.comboBox = new JComboBox();
        this.comboBox.setBounds(5, 26, 260, 28);
        this.add(comboBox);
    }

    /**
     * Metodo de acceso para el JComboBox de esta clase
     * pudiendo obtener el contenido de getSelectedItem
     * este como un String.
     * @return textoDelCombo - Almacena el contenido del 
     * JComBox aplicando comboBox.getSelectedItem().toString();
     */
    public String getText() {
        return this.comboBox.getSelectedItem().toString();
    }
    
     /**
     * Metodo de acceso para el JComboBox de esta clase
     * pudiendo obtener la posicion seleccionada de este 
     * como un int.
     * @return itemSeleccionado - Almacena la posicion seleccionada
     * del JComBox aplicando comboBox.getSelectedIndex();
     */
    public int getIndexFromCombo() {
        return this.comboBox.getSelectedIndex();
    }
    
    public void setSelectedIndex(int posicion) {
        this.comboBox.setSelectedIndex(posicion);
    }

    public JLabel getLabelTitulo() {
        return this.labelTitulo;
    }

    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    public JComboBox getComboBox() {
        return this.comboBox;
    }

}
