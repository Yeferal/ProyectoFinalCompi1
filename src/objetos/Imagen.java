
package objetos;

import javax.swing.JButton;
import tablas.Rango;

public class Imagen {
    
    String id;
    int duracion;
    JButton [][] tablero;

    public Imagen(String id, int duracion) {
        this.id = id;
        this.duracion = duracion;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public void pintar(java.awt.Color c,Rango rX, Rango rY){
        System.out.println("X: "+rX.getInicio()+",  "+rX.getFin());
        System.out.println("Y: "+rY.getInicio()+",  "+rY.getFin());
        for (int i = rX.getInicio(); i <= rX.getFin(); i++) {
            for (int j = rY.getInicio(); j <= rY.getFin(); j++) {
                try {
                    tablero[i][j].setBackground(c);
                } catch (NullPointerException e) {
                }
            }
        }
        
        
    }
    
    
}
