/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author ldbl
 */
public class setColorSystem {

    public void setBorder(JLabel l) {
//        l.setBackground(new Color(255,0,51));
        l.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, new java.awt.Color(228, 233, 120), new java.awt.Color(228, 233, 120)));

    }
    
    public void setBorder(JLabel l,int Red,int Blue,int Green){
          l.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, new java.awt.Color(Red, Blue, Green), new java.awt.Color(Red, Blue, Green)));

    }
    public void setColor(JLabel l){
        l.setForeground(new java.awt.Color(255,0,0));
    }
    
    public void resetColor(JLabel l){
        l.setForeground(new Color(0,102,255));
    }

    public void reSetBorder(JLabel l) {
//        l.setBackground(new Color(141, 181, 150));
        l.setBorder(BorderFactory.createEmptyBorder());

    }
    
    public void setColor(JPanel p){
         p.setBackground(new Color(128,180,159));
    }
    
    public void resetColor(JPanel p){
        p.setBackground(new Color(154,211,188));
    }
}
