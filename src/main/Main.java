
package main;

import analizadores.clrs.AnalizadorLexicoClrs;
import analizadores.clrs.AnalizadorSintacticoClrs;
import analizadores.inz.AnalizadorLexicoLnz;
import analizadores.inz.AnalizadorSintacticoLnz;
import analizadores.pnt.AnalizadorLexicoPnt;
import analizadores.pnt.AnalizadorSintacticoPnt;
import analizadores.tmp.AnalizadorLexicoTmp;
import analizadores.tmp.AnalizadorSintacticoTmp;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventanas.VentanaPrincipal;

public class Main {

    
    public static void main(String[] args) {
       
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
        
        Object l = 1;
        if((l instanceof Integer)){
            System.out.println("iNT");
        }else{
            System.out.println("STRING");
        }
        
        try {
		Integer.parseInt((String) l);
		System.out.println("iNT");
	} catch (NumberFormatException nfe){
		System.out.println("STRING");
	}
        catch (ClassCastException ex){
		System.out.println("STRING");
	}
        
        
        String texto = "{\n" +
"COLORES:{\n" +
"lienzoId1:{\n" +
"MiAmarillo:{\n" +
"Red: 255,\n" +
"Blue: 12,\n" +
"Green: 75\n" +
"},\n" +
"VerdePalido:{\n" +
"HEX: #Acd125\n" +
"}\n" +
"},\n" +
"otroLienzo:{\n" +
"MiAmarillo:{\n" +
"HEX: #ADD125\n" +
"},\n" +
"otroColor:{\n" +
"Green: 14,\n" +
"Red: 28,\n" +
"Blue: 0\n" +
"}\n" +
"}\n" +
"}\n" +
"}";
        
//        AnalizadorLexicoPnt analizadorLexicoPnt = new AnalizadorLexicoPnt(new StringReader(texto));
//        AnalizadorSintacticoPnt parser = new AnalizadorSintacticoPnt(analizadorLexicoPnt);
//        AnalizadorLexicoLnz analizadorLexicoLnz = new AnalizadorLexicoLnz(new StringReader(texto));
//        AnalizadorSintacticoLnz parser = new AnalizadorSintacticoLnz(analizadorLexicoLnz);

//        AnalizadorLexicoClrs analizadorLexicoClrs = new AnalizadorLexicoClrs(new StringReader(texto));
//        AnalizadorSintacticoClrs parser = new AnalizadorSintacticoClrs(analizadorLexicoClrs);
//        
//        try {
//            parser.parse();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
    
    public boolean verificarTipoDato(Object o){
        try {
		Integer.parseInt((String) o);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
        catch (ClassCastException ex){
		return false;
	}
    }
    
}
