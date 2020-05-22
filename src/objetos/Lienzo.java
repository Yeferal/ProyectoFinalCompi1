
package objetos;

public class Lienzo {
    
    String nombre, tipo, fondoHEX,inicio,fin;
    int tipoFondo, red,blue,green, cuadro, dimensionX, dimensionY;

    public Lienzo() {
    }

    public Lienzo(String nombre, String tipo, String fondoHEX, int tipoFondo, int red, int blue, int green, int cuadro, int dimensionX, int dimensionY) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fondoHEX = fondoHEX;
        this.tipoFondo = tipoFondo;
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.cuadro = cuadro;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFondoHEX() {
        return fondoHEX;
    }

    public void setFondoHEX(String fondoHEX) {
        this.fondoHEX = fondoHEX;
    }

    public int getTipoFondo() {
        return tipoFondo;
    }

    public void setTipoFondo(int tipoFondo) {
        this.tipoFondo = tipoFondo;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getCuadro() {
        return cuadro;
    }

    public void setCuadro(int cuadro) {
        this.cuadro = cuadro;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }
    
    public void pintar(){
        String texto = "Inicio: "+inicio+" fin: "+fin;
        System.out.println(texto);
    }
    
    
}
