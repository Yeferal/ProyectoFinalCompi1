package analizadores.tmp;
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
%class AnalizadorLexicoTmp
%cupsym SimbolosTmp
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
LetraHEX        = ([A-F]|[0-8]) ([A-F]|[0-8]) ([A-F]|[0-8]) ([A-F]|[0-8]) ([A-F]|[0-8]) ([A-F]|[0-8])
Texto           = ({Letra}|{Numero}|{Caracter})+
Digito          = [0-9]
Numero          = {Digito} {Digito}*
Espacio         = [ \t\r\n]+
%%


TIEMPOS                 {System.out.println("TIEMPOS"); return new Symbol(SimbolosTmp.TIEMPOS , yycolumn, yyline, yytext());}
nombre                  {System.out.println("NOMBRE"); return new Symbol(SimbolosTmp.NOMBRE , yycolumn, yyline, yytext());}
tipo                    {System.out.println("TIPO"); return new Symbol(SimbolosTmp.TIPO , yycolumn, yyline, yytext());}
FONDO                   {System.out.println("FONDO"); return new Symbol(SimbolosTmp.FONDO , yycolumn, yyline, yytext());}
Red                     {System.out.println("Red"); return new Symbol(SimbolosTmp.RED , yycolumn, yyline, yytext());}
HEX                     {System.out.println("HEX"); return new Symbol(SimbolosTmp.HEX, yycolumn, yyline, yytext());}
tamaño                  {System.out.println("TAMAIO"); return new Symbol(SimbolosTmp.TAMANIO , yycolumn, yyline, yytext());}
inicio                  {System.out.println("inicio"); return new Symbol(SimbolosTmp.INICIO_RSRVD , yycolumn, yyline, yytext());}
fin                     {System.out.println("fin"); return new Symbol(SimbolosTmp.FIN , yycolumn, yyline, yytext());}
imagenes                {System.out.println("imagenes"); return new Symbol(SimbolosTmp.IMAGENES , yycolumn, yyline, yytext());}
id                      {System.out.println("id"); return new Symbol(SimbolosTmp.ID , yycolumn, yyline, yytext());}
duracion                {System.out.println("duracion"); return new Symbol(SimbolosTmp.DURACION , yycolumn, yyline, yytext());}



<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    "\""                            {System.out.println("comillas"); return new Symbol(SimbolosTmp.COMILLAS , yycolumn, yyline, yytext());}
    "tama"."o"                      {System.out.println("TAMANO"); return new Symbol(SimbolosTmp.TAMANIO , yycolumn, yyline, yytext());}
    ("_"|{Letra})({Texto})*         {System.out.println("id: "+yytext()); return new Symbol(SimbolosTmp.IDENTIFICADOR , yycolumn, yyline, yytext());}
    ({Numero}|{Numero}"."{Numero})  {System.out.println("NUMERO: "+yytext()); return new Symbol(SimbolosTmp.NUMERO , yycolumn, yyline, yytext());}
    "#"({LetraHEX})                 {System.out.println("CODIGO_HEX: "+yytext()); return new Symbol(SimbolosTmp.CODIGO_HEX , yycolumn, yyline, yytext());}
    ":"                             {System.out.println("dos puntos"); return new Symbol(SimbolosTmp.DOS_PUNTOS , yycolumn, yyline, yytext());}
    "["                             {System.out.println("CHORCHETE ABRE"); return new Symbol(SimbolosTmp.CORCHETE_A , yycolumn, yyline, yytext());}
    "]"                             {System.out.println("CORCHE CIERRE"); return new Symbol(SimbolosTmp.CORCHETE_C , yycolumn, yyline, yytext());}
    "{"                             {System.out.println("LLAVES ABRE"); return new Symbol(SimbolosTmp.LLAVES_A , yycolumn, yyline, yytext());}
    "}"                             {System.out.println("LLAVES CIEERRE"); return new Symbol(SimbolosTmp.LLAVES_C , yycolumn, yyline, yytext());}
    ","                             {System.out.println("COMA"); return new Symbol(SimbolosTmp.COMA , yycolumn, yyline, yytext());}
    .                               {System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext());
                                    ErrorG e = new ErrorG(yyline+1, yycolumn+1,yytext(),"Lexico","Error Lexico token: " + yytext()+"   Linea: " + (yyline+1) + " ,    Columna: " + (yycolumn+1));
                                    listaErrores.add(e);
                                    }
    
}
