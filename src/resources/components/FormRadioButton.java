package resources.components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Clase que consiste en un JPanel que provee de dos JRadioButton agrupados con
 * ButtonGroup y un JLabel que mostrara el titulo formando asi un pequeno
 * formulario.
 *
 * Estos dos componentes tienen sus respectivos metodos de acceso al contenido
 * del JRadioButton en este caso.
 *
 * [FORMA DE USO]
 *
 * # Declaracion. private FormRadioButton nombreDeLavariable;
 *
 * # Instanciacion y uso. nombreDeLavariable = new FormRadioButton();
 *
 * Created by jeis on 21/05/17.
 */
public class FormRadioButton extends JPanel {

    private JLabel labelTitulo;
    private JRadioButton radioButtonYes, radioButtonNo;
    private ButtonGroup buttonGroup;

    public FormRadioButton(String titulo) {
        setPreferredSize(new Dimension(280, 60));
        this.setOpaque(false);
        setLayout(null);

        labelTitulo = new JLabel(titulo);
        labelTitulo.setForeground(new Color(31, 31, 31));
        labelTitulo.setBounds(12, 12, 70, 15);
        add(labelTitulo);

        this.buttonGroup = new ButtonGroup();
        radioButtonYes = new JRadioButton("Si");
        radioButtonYes.setOpaque(false);
        //radioButtonYes.setForeground(Color.WHITE);
        radioButtonYes.setBounds(8, 29, 97, 23);
        buttonGroup.add(radioButtonYes);
        add(radioButtonYes);

        /**
         * Por defecto estara seleccionado no.
         */
        radioButtonNo = new JRadioButton("No");
        radioButtonNo.setOpaque(false);
        radioButtonNo.setSelected(true);
        //radioButtonYes.setForeground(Color.WHITE);
        radioButtonNo.setBounds(123, 29, 117, 23);
        buttonGroup.add(radioButtonNo);
        add(radioButtonNo);

    }

    public JRadioButton getRadioButtonYes() {
        return radioButtonYes;
    }

    public JRadioButton getRadioButtonNo() {
        return radioButtonNo;
    }
    
    public boolean isSelected() {
        if (radioButtonYes.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSelectedRadioButtonYes() {
        if (radioButtonYes.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSelectedRadioButtonNo() {
        if (radioButtonNo.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @deprecated No funciona, replantear. 
     */
    public void setSelectedYes(boolean estado){
        radioButtonYes.setSelected(estado);
    }
    
    public void setSelectedNo(boolean estado){
        radioButtonYes.setSelected(estado);
    }
    /***************************************/

}
