/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/** @author Jeis */
public class txt extends JTextField {

  public txt() {

    setFont(new Font("Tahoma", Font.PLAIN, 17));
    setForeground(Color.white);
    setColumns(10);
    setOpaque(false);
    setBorder(new LineBorder(new Color(0, 0, 0)));
  }
}
