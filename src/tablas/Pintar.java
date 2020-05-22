/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

/**
 *
 * @author LENOVO-PC
 */
public class Pintar {
    
    String nombreLienzo, idColor,idImagen;
    Rango posX,posY;

    public Pintar(String nombreLienzo, String idColor, String idImagen, Rango posX, Rango posY) {
        this.nombreLienzo = nombreLienzo;
        this.idColor = idColor;
        this.idImagen = idImagen;
        this.posX = posX;
        this.posY = posY;
    }

    public String getNombreLienzo() {
        return nombreLienzo;
    }

    public void setNombreLienzo(String nombreLienzo) {
        this.nombreLienzo = nombreLienzo;
    }

    public String getIdColor() {
        return idColor;
    }

    public void setIdColor(String idColor) {
        this.idColor = idColor;
    }

    public String getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(String idImagen) {
        this.idImagen = idImagen;
    }

    public Rango getPosX() {
        return posX;
    }

    public void setPosX(Rango posX) {
        this.posX = posX;
    }

    public Rango getPosY() {
        return posY;
    }

    public void setPosY(Rango posY) {
        this.posY = posY;
    }
    
    
    
    
}
