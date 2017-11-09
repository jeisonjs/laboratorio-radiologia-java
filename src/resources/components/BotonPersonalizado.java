/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Jeis
 */
public class BotonPersonalizado extends JButton{

    public BotonPersonalizado() {

        setBackground(new Color(108, 122, 137));
        setFont(new Font("Tahoma", 1, 15));
        setForeground(new Color(255, 255, 255));
        //setBorder(new javax.swing.border.LineBorder(new Color(51, 51, 51), 2, true));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFocusPainted(false);
        //setMargin(new java.awt.Insets(6, 14, 6, 14));
        //setPreferredSize(new java.awt.Dimension(85, 45));
    }
}
