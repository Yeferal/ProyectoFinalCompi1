
package objetos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class AccionBoton implements ActionListener{
    
    JCheckBox checkBox;
    JButton boton;
    JButton botonColor;
            
    public AccionBoton(JCheckBox checkBox, JButton boton,JButton botonColor){
        this.checkBox = checkBox;
        this.boton = boton;
        this.botonColor = botonColor;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            boton.setBackground(java.awt.Color.WHITE);
        }else{
            boton.setBackground(botonColor.getBackground());
        }
        
    }
}
