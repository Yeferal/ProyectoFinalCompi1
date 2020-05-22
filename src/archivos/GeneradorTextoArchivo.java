
package archivos;

import java.util.ArrayList;
import objetos.Color;
import objetos.Imagen;
import objetos.Lienzo;
import objetos.LienzoEditor;

public class GeneradorTextoArchivo {
    
    public String textoLnz;
    public String textoClrs;
    public String textoTmp;
    public String textoPnt;
    
    public void generar( ArrayList<LienzoEditor> listaLienzoEditors){
        textoLnz = "{\n";
        textoLnz += "\tLIENZOS:{\n";
        
        textoClrs = "{\n";
        textoClrs += "\tCOLORES:{\n";
        
        textoTmp = "{\n";
        textoTmp += "\tTIEMPOS:{\n";
        
        textoPnt = "{\n";
        textoPnt += "\t:{\n";
        for (int i = 0; i < listaLienzoEditors.size(); i++) {
            escribirLnz(listaLienzoEditors.get(i).lienzo,listaLienzoEditors.get(i).nombreL);
            escribirClrs(listaLienzoEditors.get(i).lienzo,listaLienzoEditors.get(i).nombreL, listaLienzoEditors.get(i).listaColores);
            escribirTmp(listaLienzoEditors.get(i).lienzo,listaLienzoEditors.get(i).nombreL, listaLienzoEditors.get(i).listaImagenes);
            if((listaLienzoEditors.size()-1)==i){
                textoLnz += "\t\t}\n";
                textoClrs += "\t\t}\n";
                textoTmp += "\t\t}\n";
            }else{
                textoLnz += "\t\t},\n";
                textoClrs += "\t\t},\n";
                textoTmp += "\t\t},\n";
            }
        }
        textoLnz += "\t}\n";
        textoLnz += "}\n";
        textoClrs += "\t}\n";
        textoClrs += "}\n";
        textoTmp += "\t}\n";
        textoTmp += "}\n";
    }
    
    public void escribirLnz(Lienzo lienzo, String nombreL){
        textoLnz += "\t\t"+nombreL+":{\n";
        textoLnz += "\t\t\tnombre:\""+lienzo.getNombre()+"\",\n";
        textoLnz += "\t\t\ttipo:\""+lienzo.getTipo()+"\",\n";
        textoLnz += "\t\t\tFondo:{\n";
        if(lienzo.getTipoFondo()==1){
            textoLnz += "\t\t\t\tRed:"+lienzo.getRed()+",\n";
            textoLnz += "\t\t\t\tGreen:"+lienzo.getGreen()+",\n";
            textoLnz += "\t\t\t\tBlue:"+lienzo.getBlue()+"\n";
            textoLnz += "\t\t\t},\n";
        }else{
            textoLnz += "\t\t\t\tHEX:"+lienzo.getFondoHEX()+"\n";
            textoLnz += "\t\t\t},\n";
        }
        textoLnz += "\t\t\ttamaño:{\n";
        textoLnz += "\t\t\t\tcuadro:"+lienzo.getCuadro()+",\n";
        textoLnz += "\t\t\t\tdimension_x:"+lienzo.getDimensionX()+",\n";
        textoLnz += "\t\t\t\tdimension_y:"+lienzo.getDimensionY()+"\n";
        textoLnz += "\t\t\t}\n";
    }
    
    public void escribirClrs(Lienzo lienzo, String nombreL, ArrayList<Color> listaColores){
        textoClrs += "\t\t"+nombreL+":{\n";
        for (int i = 0; i < listaColores.size(); i++) {
            textoClrs += "\t\t\t"+listaColores.get(i).getNombre()+":{\n";
            if(listaColores.get(i).getTipoFondo()==1){
                textoClrs += "\t\t\t\tRed:"+listaColores.get(i).getRed()+",\n";
                textoClrs += "\t\t\t\tGreen:"+listaColores.get(i).getGreen()+",\n";
                textoClrs += "\t\t\t\tBlue:"+listaColores.get(i).getBlue()+"\n";
            }else{
                textoClrs += "\t\t\t\tHEX:"+listaColores.get(i).getFondoHEX()+"\n";
                
            }
            if((listaColores.size()-1)==i){
                textoClrs += "\t\t\t}\n";
            }else{
                textoClrs += "\t\t\t},\n";
            }
        }

    }
    
    public void escribirTmp(Lienzo lienzo, String nombreL, ArrayList<Imagen> listaImagenes){
        textoTmp += "\t\t"+nombreL+":{\n";
        textoTmp += "\t\t\tinicio:\""+lienzo.getInicio()+"\",\n";
        textoTmp += "\t\t\tfin:\""+lienzo.getFin()+"\",\n";
        textoTmp += "\t\t\timagenes:[\n";
        for (int i = 0; i < listaImagenes.size(); i++) {
            textoTmp += "\t\t\t{\n";
            textoTmp += "\t\t\t\tid:\""+listaImagenes.get(i).getId()+"\",\n";
            textoTmp += "\t\t\t\tduracion:"+listaImagenes.get(i).getDuracion()+"\n";
            
            if((listaImagenes.size()-1)==i){
                textoTmp += "\t\t\t}\n";
            }else{
                textoTmp += "\t\t\t},\n";
            }
        }
        textoTmp += "\t\t\t]\n";
    }
}
