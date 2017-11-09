package resources.components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jeis on 22/05/17.
 */
public class JMenuBarPersonalizado extends JMenuBar {

    public void paintComponent(Graphics g) {

        super.paintComponents(g);

        int h = getHeight();
        int w = getWidth();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new GradientPaint(w, 0, new Color(51, 134, 219), 0, h, new Color(4, 205, 253),true));
        g2d.fillRect(0, 0, w, h);

        repaint();
    }
}
