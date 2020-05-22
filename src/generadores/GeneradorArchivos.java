/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadores;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author yefer
 */
public class GeneradorArchivos {
 
    public void generador() throws Exception {
        String rutaLexicoProyecto = "src/analizadores/inz/LexerInz.jflex";
        String[] rutaSintacticoProyecto = {"-parser", "SintaxInz", "src/analizadores/inz/SintaxInz.cup"};
        generar(rutaLexicoProyecto, rutaSintacticoProyecto, "src/analizadores/inz/SimbolosLnz.java", "SimbolosLnz.java", "src/analizadores/inz/SintacticoLnz.java", "SintacticoLnz.java");
//        
//        String rutaLexicoPartida = "src/konquest/backed/analizador/partida/LexerGuardarPartida.flex";
//        String[] rutaSintacticoPartida = {"-parser", "SintaxGuardarPartida", "src/konquest/backed/analizador/partida/SintaxGuardarPartida.cup"};
//        generar(rutaLexicoPartida, rutaSintacticoPartida, "src/konquest/backed/analizador/partida/sym.java", "sym.java", "src/konquest/backed/analizador/partida/SintaxGuardarPartida.java", "SintaxGuardarPartida.java");
// 
//        String rutaLexicoReplay = "src/konquest/backed/analizador/replay/LexicoReplay.flex";
//        String[] rutaSintacticoReplay = {"-parser", "SintaxReplay", "src/konquest/backed/analizador/replay/SintaxReplay.cup"};
//        generar(rutaLexicoReplay, rutaSintacticoReplay, "src/konquest/backed/analizador/replay/sym.java", "sym.java", "src/konquest/backed/analizador/replay/SintaxReplay.java", "SintaxReplay.java");
 




//java -jar java-cup-11a.jar SintaxInz.cup
//jflex er.jflex
    
    }
    
    public void generar(String rutalexicoProyecto, String[] rutaS, String rutaSymTXT, String nombreSym, String rutaSint, String nombreSin) throws IOException, Exception{
        File archivo;
        archivo = new File(rutalexicoProyecto);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        Path rutaSym = Paths.get(rutaSymTXT);
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(nombreSym), 
                Paths.get(rutaSymTXT)
        );
        Path rutaSin = Paths.get(rutaSint);
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(nombreSin), 
                Paths.get(rutaSint)
        );
    }
    
}
