/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yefer
 */
public class Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorArchivos generadorArchivos = new GeneradorArchivos();
        try {
            generadorArchivos.generador();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
