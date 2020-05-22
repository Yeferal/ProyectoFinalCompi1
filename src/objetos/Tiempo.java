/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

public class Tiempo {
    
    String inicio,fin,lienzo;
    ArrayList<Imagen> listaImagenes;
    
    public Tiempo() {
        listaImagenes = new ArrayList<>();
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

    public String getLienzo() {
        return lienzo;
    }

    public void setLienzo(String lienzo) {
        this.lienzo = lienzo;
    }

    public ArrayList<Imagen> getListaImagenes() {
        return listaImagenes;
    }

    public void setListaImagenes(ArrayList<Imagen> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }
    
    
    
}
