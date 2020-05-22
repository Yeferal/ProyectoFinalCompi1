/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 *
 * @author LENOVO-PC
 */
public class AccionColorBoton implements ActionListener{

    JButton boton;
    JButton botonColor;
            
    public AccionColorBoton( JButton boton,JButton botonColor){
        this.boton = boton;
        this.botonColor = botonColor;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        botonColor.setBackground(boton.getBackground());
        
    }
}
