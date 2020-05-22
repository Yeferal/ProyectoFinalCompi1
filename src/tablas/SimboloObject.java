
package tablas;

public class SimboloObject {
    
    String nombre, tipo;
    Object objeto;

    public SimboloObject(String nombre, String tipo, Object objeto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.objeto = objeto;
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

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    
    public String toString(){
        return "Nombre: "+nombre+"\tTipo: "+tipo+"\tObjeto: "+objeto.toString();
    }
    
}
