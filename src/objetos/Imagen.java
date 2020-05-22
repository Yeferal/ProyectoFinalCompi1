
package objetos;

import javax.swing.JButton;

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
    
    
}
