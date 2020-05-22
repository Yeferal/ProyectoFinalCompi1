
package tablas;

import java.util.ArrayList;
import objetos.Lienzo;

public class TablaSimbolos {
    
    ArrayList<SimboloObject> tablaSym;

    public TablaSimbolos() {
        tablaSym = new ArrayList<>();
        
        
    }

    public ArrayList<SimboloObject> getTablaSym() {
        return tablaSym;
    }

    public void setTablaSym(ArrayList<SimboloObject> tablaSym) {
        this.tablaSym = tablaSym;
    }
    
    public void agregarSimbolo(SimboloObject simbolo){
        tablaSym.add(simbolo);
    }
    
    public boolean buscarSimbolo(String nombre){
        for (int i = 0; i < tablaSym.size(); i++) {
            if(tablaSym.get(i).getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    public boolean buscarSimboloTipo(String nombre, String tipo){
        for (int i = 0; i < tablaSym.size(); i++) {
            if(tablaSym.get(i).getNombre().equals(nombre) && tablaSym.get(i).getTipo().equals(tipo)){
                return true;
            }
        }
        return false;
    }
    
    public void modificar(String nombre, String tipo, Object valor){
        for (int i = 0; i < tablaSym.size(); i++) {
            if(tablaSym.get(i).getNombre().equals(nombre)){
                if(tablaSym.get(i).getTipo().equals(tipo)){
                    tablaSym.get(i).setObjeto(valor);
                }else{
                    System.out.println("EL SIMBOLO NO ES DEL MISMO TIPO");
                }
            }
        }
    }
    
    public void pintar(){
        for (int i = 0; i < tablaSym.size(); i++) {
            System.out.println(tablaSym.get(i).toString());
        }
    }
    
    public Lienzo getLienzo(String nombre){
        Lienzo l = null;
        for (int i = 0; i < tablaSym.size(); i++) {
            if(tablaSym.get(i).getNombre().equals(nombre) && tablaSym.get(i).getTipo().equals("Lienzo")){
                l = (Lienzo) tablaSym.get(i).getObjeto();
                return l;
            }
        }
        return l;
    }
    public Object getObjeto(String nombre, String tipo){
        Object o = null;
        for (int i = 0; i < tablaSym.size(); i++) {
            if(tablaSym.get(i).getNombre().equals(nombre) && tablaSym.get(i).getTipo().equals(tipo)){
                o = tablaSym.get(i).getObjeto();
                return o;
            }
        }
        return o;
    }
    public Object getObjetoC(String nombre){
        Object o = null;
        for (int i = 0; i < tablaSym.size(); i++) {
            if(tablaSym.get(i).getNombre().equals(nombre)){
                o = tablaSym.get(i).getObjeto();
                return o;
            }
        }
//        boolean name = o instanceof Integer;
        return o;
    }
    public Object getObjetoN(String nombre, String tipo){
        String o = null;
        for (int i = 0; i < tablaSym.size(); i++) {
            if(tablaSym.get(i).getNombre().equals(nombre) && tablaSym.get(i).getTipo().equals(tipo)){
                o = tablaSym.get(i).getNombre();
                return o;
            }
        }
//        boolean name = o instanceof Integer;
        return o;
    }
    
    public SimboloObject getSimbolo(String nombre){
        SimboloObject o = null;
        for (int i = 0; i < tablaSym.size(); i++) {
            if(tablaSym.get(i).getNombre().equals(nombre)){
                o = tablaSym.get(i);
                return o;
            }
        }
        return o;
    }
}
