/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author Edisoncor
 *     <p>Son de tipo "Gradiente" por lo tanto se pueden combinar para obtener tal efecto.
 */
public class Button11 extends JButton {

  private Color btnNormalColor = new Color(217, 83, 79, 155);
  private Color btnNormalBorderBottom = new Color(210, 50, 45);

  private Color btnRollOverColor = new Color(210, 50, 45, 150);

  private Color btnPressedColor = new Color(217, 83, 79, 100);
  private Color btnPressedborderTop = new Color(210, 50, 45);

  private Color btnDisableBoton = new Color(209, 213, 216);

  private int outerRoundRectSize = 0;
  private int innerRoundRectSize = 0;

  private GradientPaint GP;

  public Button11(String titulo) {
    setText(titulo);
    setOpaque(false);
    setContentAreaFilled(false);
    setForeground(Color.black);
    setFocusPainted(false);
    setBorderPainted(false);
    setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
  }

  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    int h = getHeight();
    int w = getWidth();
    ButtonModel model = getModel();

    if (!model.isEnabled()) {
      setForeground(Color.GRAY);
      GP = new GradientPaint(0, 0, btnDisableBoton, 0, h, btnDisableBoton, true);
    } else {
      setForeground(Color.WHITE);
      if (model.isRollover()) {
        GP = new GradientPaint(0, 0, btnRollOverColor, 0, h, btnRollOverColor, true);
      } else {
        GP = new GradientPaint(300, 0, new Color(51, 134, 219), 0, h, new Color(4, 205, 253), true);
      }
    }

    g2d.setPaint(GP);

    GradientPaint p1;
    GradientPaint p2;
    if (model.isPressed()) {
      // Si el boton es presionado.

      /*
       * @param GP Color que tomará el boton.
       */
      GP = new GradientPaint(0, 0, btnPressedColor, 0, h, btnPressedColor, true);
      g2d.setPaint(GP);

      /*
       * @param btnPressedborderTop es el color que se dibuja
       * sobre del borde superior del boton.
       */
      p1 =
          new GradientPaint(
              0,
              0,
              btnPressedborderTop,
              0,
              h - 1,
              /*
               * @param btnPressedColor es el color que se dibuja
               * sobredel borde inferior del boton.
               */
              btnPressedColor);

      p2 = new GradientPaint(0, 1, btnPressedborderTop, 0, h - 3, btnPressedColor);
    } else {
      // Estado normal del boton.

      GP = new GradientPaint(0, 0, Color.red, 0, h, Color.blue, false);

      p1 = new GradientPaint(200, 0, Color.cyan, 0, h - 1, btnNormalBorderBottom);

      p2 = new GradientPaint(0, 1, btnNormalColor, 0, h - 1, btnNormalBorderBottom);
    }

    RoundRectangle2D.Float r2d =
        new RoundRectangle2D.Float(0, 0, w - 1, h - 1, outerRoundRectSize, outerRoundRectSize);

    Shape clip = g2d.getClip();
    g2d.clip(r2d);
    g2d.fillRect(0, 0, w, h);
    g2d.setClip(clip);

    g2d.setPaint(p1);
    g2d.drawRoundRect(0, 0, w - 1, h - 1, outerRoundRectSize, outerRoundRectSize);

    g2d.setPaint(p2);
    g2d.drawRoundRect(1, 1, w - 3, h - 3, innerRoundRectSize, innerRoundRectSize);

    g2d.dispose();

    super.paintComponent(g);
  }

  public static void main(String args[]) {
    JFrame frame = new JFrame("Custom Buttons Demo");
    frame.setLayout(new FlowLayout());
    Button11 standardButton = new Button11("Standard Button");
    frame.add(standardButton.getButtonsPanel());
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setBackground(Color.WHITE);
    //frame.setSize(900, 600);
    frame.pack();
    frame.setLocation(100, 250);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public JPanel getButtonsPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);

    Button11 standardButton = new Button11("Standard Button");
    standardButton.setPreferredSize(new Dimension(300, 60));

    Button11 rollOverButton = new Button11("RollOver Button");
    rollOverButton.setPreferredSize(new Dimension(300, 60));

    Button11 disabledButton = new Button11("Disable Button");
    disabledButton.setPreferredSize(new Dimension(300, 80));
    disabledButton.setEnabled(false);

    Button11 pressedButton = new Button11("Pressed Button");
    pressedButton.setPreferredSize(new Dimension(300, 60));

    panel.add(standardButton);
    panel.add(rollOverButton);
    //panel.add(disabledButton);
    panel.add(pressedButton);
    return panel;
  }
}
