/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.components;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jeis
 */
public class MenuItem extends JMenuItem{
    
    public MenuItem(String titulo){
    
        setText(titulo);
        setFont(new Font(null,1,13));
        setForeground(new Color(33, 33, 33));
        setBackground(new Color(254, 254, 254));
        setPreferredSize(new Dimension(getPreferredSize().width,35));
        
    }
}
