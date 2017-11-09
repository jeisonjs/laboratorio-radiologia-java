
package resources.components;

import java.awt.*;
import javax.swing.*;
/**
 *
 * Clase que extiende de JPanel y permite poner una imagen como fondo.
 * 
 * @author Original - elaprendiz - asumaretv http://www.youtube.com/user/JleoD7
 * @author Guille Rodriguez Gonzalez ( http://www.driverlandia.com )
 * @author Jeison Perez
 *         jeisonj_2008@hotmail.com
 * @version 1.0 | 19-02-2017
 */
public class PanelImage extends JPanel{

    // Atributo que guardara la imagen de Background que le pasemos.
    private ImageIcon img;
    

    /*public PanelImage(ImageIcon img) {
        this.img = img;
    }*/

    /**
     * 
     * Se sobreesbe el metodo paintComponent() de JPanel y se encargará de 
     * dibujar la imagen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        
        // Se obtiene la dimensión del panel y se almacena a la variable "tam". 
        Dimension tam = getSize();
        
        // Obtener y dibujar la imagen | Ubicación | Asignar el tamano del JPanel. 
        if (this.img != null) {
            g.drawImage(this.img.getImage(), 0, 0,tam.width,tam.height,null);
        }
        // Metodo encargado de actualizar el dibujado de la imagen.
        repaint();
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
}
