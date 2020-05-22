package analizadores.inz;
import java_cup.runtime.*;
import objetos.ErrorG;
import java.util.ArrayList;

%%
%{
    //coidgo de usuario en sintaxis java
    public ArrayList<ErrorG> listaErrores = new  ArrayList<>();

%}

    //directivas
%public 
%class AnalizadorLexicoLnz
%cupsym SimbolosLnz
%cup
%char
%line
%column
%full
//%ignorecase

//%unicode

    //expreciones regulares

Caracter      = [_]
Letra           = ([a-zA-Z] | ñ | Ñ)
LetraHEX        = ([a-fA-F]|[0-9]) ([a-fA-F]|[0-9]) ([a-fA-F]|[0-9]) ([a-fA-F]|[0-9]) ([a-fA-F]|[0-9]) ([a-fA-F]|[0-9])
Texto           = ({Letra}|{Numero}|{Caracter})*
Digito          = [0-9]
Numero          = {Digito} {Digito}*
Espacio         = [ " "\t\r\n]+
%%


LIENZOS                 {System.out.println("LIENZOS"); return new Symbol(SimbolosLnz.LIENZOS , yycolumn, yyline, yytext());}
nombre                  {System.out.println("NOMBRE"); return new Symbol(SimbolosLnz.NOMBRE , yycolumn, yyline, yytext());}
tipo                    {System.out.println("TIPO"); return new Symbol(SimbolosLnz.TIPO , yycolumn, yyline, yytext());}
Fondo                   {System.out.println("FONDO"); return new Symbol(SimbolosLnz.FONDO , yycolumn, yyline, yytext());}
Red                     {System.out.println("Red"); return new Symbol(SimbolosLnz.RED , yycolumn, yyline, yytext());}
Blue                    {System.out.println("Blue"); return new Symbol(SimbolosLnz.BLUE , yycolumn, yyline, yytext());}
Green                   {System.out.println("Green"); return new Symbol(SimbolosLnz.GREEN , yycolumn, yyline, yytext());}
HEX                     {System.out.println("HEX"); return new Symbol(SimbolosLnz.HEX, yycolumn, yyline, yytext());}
tamaño                  {System.out.println("TAMAIO"); return new Symbol(SimbolosLnz.TAMANIO , yycolumn, yyline, yytext());}
cuadro                  {System.out.println("cuadro"); return new Symbol(SimbolosLnz.CUADRO , yycolumn, yyline, yytext());}
dimension_x             {System.out.println("dimension_x"); return new Symbol(SimbolosLnz.DIMENSION_X , yycolumn, yyline, yytext());}
dimension_y             {System.out.println("dimension_y"); return new Symbol(SimbolosLnz.DIMENSION_Y , yycolumn, yyline, yytext());}
png                     {System.out.println("png"); return new Symbol(SimbolosLnz.PNG , yycolumn, yyline, yytext());}
gif                     {System.out.println("gif"); return new Symbol(SimbolosLnz.GIF , yycolumn, yyline, yytext());}



<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}

    "\""                            {System.out.println("comillas"); return new Symbol(SimbolosLnz.COMILLAS , yycolumn, yyline, yytext());}
    "tama"."o"                      {System.out.println("TAMANO"); return new Symbol(SimbolosLnz.TAMANIO , yycolumn, yyline, yytext());}
    ("_"|{Letra})({Texto})*         {System.out.println("id: "+yytext()); return new Symbol(SimbolosLnz.IDENTIFICADOR , yycolumn, yyline, yytext());}
    {Numero}                        {System.out.println("NUMERO: "+yytext()); return new Symbol(SimbolosLnz.NUMERO , yycolumn, yyline, yytext());}
    "#"({LetraHEX})                 {System.out.println("CODIGO_HEX: "+yytext()); return new Symbol(SimbolosLnz.CODIGO_HEX , yycolumn, yyline, yytext());}
    ":"                             {System.out.println("dos puntos"); return new Symbol(SimbolosLnz.DOS_PUNTOS , yycolumn, yyline, yytext());}
    "{"                             {System.out.println("LLAVES ABRE"); return new Symbol(SimbolosLnz.LLAVES_A , yycolumn, yyline, yytext());}
    "}"                             {System.out.println("LLAVES CIEERRE"); return new Symbol(SimbolosLnz.LLAVES_C , yycolumn, yyline, yytext());}
    ","                             {System.out.println("COMA"); return new Symbol(SimbolosLnz.COMA , yycolumn, yyline, yytext());}
    .                               {System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext());
                                    ErrorG e = new ErrorG(yyline+1, yycolumn+1,yytext(),"Lexico","Error Lexico token: " + yytext()+"   Linea: " + (yyline+1) + " ,    Columna: " + (yycolumn+1));
                                    listaErrores.add(e);
                                    }
    
}
