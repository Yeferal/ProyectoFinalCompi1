/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import archivos.GeneradorTextoArchivo;
import java.util.ArrayList;
import tablas.TablaSimbolos;

public class GenradorLienzos {
    
    int tamanio = 0;
    TablaSimbolos tablaLienzos;
    TablaSimbolos tablaColores;
    TablaSimbolos tablaImagenes;
    public ArrayList<LienzoEditor> listaLienzoEditors = new ArrayList<>();
    
    public void setTablas(TablaSimbolos tablaLienzos, TablaSimbolos tablaColores, TablaSimbolos tablaImagenes){
        this.tablaLienzos = tablaLienzos;
        this.tablaColores = tablaColores;
        this.tablaImagenes = tablaImagenes;
        
        buscarDatos();
        
    }
    
    public void buscarDatos(){
        
        for (int i = 0; i < tablaLienzos.getTablaSym().size(); i++) {
            Lienzo l = (Lienzo) tablaLienzos.getTablaSym().get(i).getObjeto();
            l.pintar();
            LienzoEditor lienzoEditor = new LienzoEditor(l,tablaLienzos.getTablaSym().get(i).getNombre());
            listaLienzoEditors.add(lienzoEditor);
            agregarColores(tablaLienzos.getTablaSym().get(i).getNombre());
            agregarImagenes(tablaLienzos.getTablaSym().get(i).getNombre());
            tamanio++;
        }
    }
    
    public void agregarColores(String nombre){
        for (int i = 0; i < tablaColores.getTablaSym().size(); i++) {
            Color c = (Color) tablaColores.getTablaSym().get(i).getObjeto();
            if(tablaColores.getTablaSym().get(i).getTipo().equals(nombre)){
                listaLienzoEditors.get(tamanio).agregarColor(c);
            }
        }
    }
    
    public void agregarImagenes(String nombre){
        for (int i = 0; i < tablaImagenes.getTablaSym().size(); i++) {
            Imagen im = (Imagen) tablaImagenes.getTablaSym().get(i).getObjeto();
            if(tablaImagenes.getTablaSym().get(i).getTipo().equals(nombre)){
                listaLienzoEditors.get(tamanio).agregarImagens(im);
            }
        }
    }
    
    
    
    
}
