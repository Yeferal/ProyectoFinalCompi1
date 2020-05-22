package analizadores.clrs;
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
%class AnalizadorLexicoClrs
%cupsym SimbolosClrs
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
Texto           = ({Letra}|{Numero}|{Caracter})+
Digito          = [0-9]
Numero          = {Digito} {Digito}*
Espacio         = [ \t\r\n]+
%%


COLORES                 {System.out.println("COLORES"); return new Symbol(SimbolosClrs.COLORES , yycolumn, yyline, yytext());}
nombre                  {System.out.println("NOMBRE"); return new Symbol(SimbolosClrs.NOMBRE , yycolumn, yyline, yytext());}
tipo                    {System.out.println("TIPO"); return new Symbol(SimbolosClrs.TIPO , yycolumn, yyline, yytext());}
FONDO                   {System.out.println("FONDO"); return new Symbol(SimbolosClrs.FONDO , yycolumn, yyline, yytext());}
Red                     {System.out.println("Red"); return new Symbol(SimbolosClrs.RED , yycolumn, yyline, yytext());}
Blue                    {System.out.println("Blue"); return new Symbol(SimbolosClrs.BLUE , yycolumn, yyline, yytext());}
Green                   {System.out.println("Green"); return new Symbol(SimbolosClrs.GREEN , yycolumn, yyline, yytext());}
HEX                     {System.out.println("HEX"); return new Symbol(SimbolosClrs.HEX, yycolumn, yyline, yytext());}
tamaño                  {System.out.println("TAMAIO"); return new Symbol(SimbolosClrs.TAMANIO , yycolumn, yyline, yytext());}
cuadro                  {System.out.println("cuadro"); return new Symbol(SimbolosClrs.CUADRO , yycolumn, yyline, yytext());}
dimension_x             {System.out.println("dimension_x"); return new Symbol(SimbolosClrs.DIMENSION_X , yycolumn, yyline, yytext());}
dimension_y             {System.out.println("dimension_y"); return new Symbol(SimbolosClrs.DIMENSION_Y , yycolumn, yyline, yytext());}
png                     {System.out.println("png"); return new Symbol(SimbolosClrs.PNG , yycolumn, yyline, yytext());}
gif                     {System.out.println("gif"); return new Symbol(SimbolosClrs.GIF , yycolumn, yyline, yytext());}



<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    "\""                            {System.out.println("comillas"); return new Symbol(SimbolosClrs.COMILLAS , yycolumn, yyline, yytext());}
    "tama"."o"                      {System.out.println("TAMANO"); return new Symbol(SimbolosClrs.TAMANIO , yycolumn, yyline, yytext());}
    ("_"|{Letra})({Texto})*         {System.out.println("id: "+yytext()); return new Symbol(SimbolosClrs.IDENTIFICADOR , yycolumn, yyline, yytext());}
    ({Numero}|{Numero}"."{Numero})  {System.out.println("NUMERO: "+yytext()); return new Symbol(SimbolosClrs.NUMERO , yycolumn, yyline, yytext());}
    "#"({LetraHEX})                 {System.out.println("CODIGO_HEX: "+yytext()); return new Symbol(SimbolosClrs.CODIGO_HEX , yycolumn, yyline, yytext());}
    ":"                             {System.out.println("dos puntos"); return new Symbol(SimbolosClrs.DOS_PUNTOS , yycolumn, yyline, yytext());}
    "["                             {System.out.println("CHORCHETE ABRE"); return new Symbol(SimbolosClrs.CORCHE_A , yycolumn, yyline, yytext());}
    "]"                             {System.out.println("CORCHE CIERRE"); return new Symbol(SimbolosClrs.CORCHE_C , yycolumn, yyline, yytext());}
    "{"                             {System.out.println("LLAVES ABRE"); return new Symbol(SimbolosClrs.LLAVES_A , yycolumn, yyline, yytext());}
    "}"                             {System.out.println("LLAVES CIEERRE"); return new Symbol(SimbolosClrs.LLAVES_C , yycolumn, yyline, yytext());}
    ","                             {System.out.println("COMA"); return new Symbol(SimbolosClrs.COMA , yycolumn, yyline, yytext());}
    .                               {System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext());
                                    ErrorG e = new ErrorG(yyline+1, yycolumn+1,yytext(),"Lexico","Error Lexico token: " + yytext()+"   Linea: " + (yyline+1) + " ,    Columna: " + (yycolumn+1));
                                    listaErrores.add(e);
                                    }
    
}
