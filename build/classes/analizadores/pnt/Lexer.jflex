package analizadores.pnt;
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
%class AnalizadorLexicoPnt
%cupsym SimbolosPnt
%cup
%char
%line
%column
%full
//%ignorecase

//%unicode

    //expreciones regulares

Caracter        = [_]
Letra           = ([a-zA-Z] | ñ | Ñ)
LetraHEX        = ([A-F]|[0-8]) ([A-F]|[0-8]) ([A-F]|[0-8]) ([A-F]|[0-8]) ([A-F]|[0-8]) ([A-F]|[0-8])
Texto           = ({Letra}|{Numero}|{Caracter})+
Digito          = [0-9]
Numero          = {Digito} {Digito}*
Espacio         = [ \t\r]+
%%

VARS                {System.out.println("VARS"); return new Symbol(SimbolosPnt.VARS , yycolumn, yyline, yytext());}
int                 {System.out.println("INT"); return new Symbol(SimbolosPnt.INT , yycolumn, yyline, yytext());}
String                  {System.out.println("STRING"); return new Symbol(SimbolosPnt.STRING , yycolumn, yyline, yytext());}
boolean                    {System.out.println("BOOLEAN"); return new Symbol(SimbolosPnt.BOOLEAN , yycolumn, yyline, yytext());}
if                   {System.out.println("IF"); return new Symbol(SimbolosPnt.IF , yycolumn, yyline, yytext());}
else                     {System.out.println("ELSE"); return new Symbol(SimbolosPnt.ELSE , yycolumn, yyline, yytext());}
while                     {System.out.println("WHILE"); return new Symbol(SimbolosPnt.WHILE , yycolumn, yyline, yytext());}
AND                     {System.out.println("AND"); return new Symbol(SimbolosPnt.AND, yycolumn, yyline, yytext());}
OR                  {System.out.println("OR"); return new Symbol(SimbolosPnt.OR , yycolumn, yyline, yytext());}
INSTRUCCIONES                  {System.out.println("INSTRUCCIONES"); return new Symbol(SimbolosPnt.INSTRUCCIONES , yycolumn, yyline, yytext());}
PINTAR                  {System.out.println("PINTAR"); return new Symbol(SimbolosPnt.PINTAR , yycolumn, yyline, yytext());}
Pintar                  {System.out.println("PINTAR_MIN"); return new Symbol(SimbolosPnt.PINTAR_MIN , yycolumn, yyline, yytext());}
true                  {System.out.println("true"); return new Symbol(SimbolosPnt.TRUE , yycolumn, yyline, yytext());}
false                  {System.out.println("false"); return new Symbol(SimbolosPnt.FALSE , yycolumn, yyline, yytext());}



<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    "\n"                            {System.out.println("salto"); return new Symbol(SimbolosPnt.SALTO , yycolumn, yyline, yytext());}
    "\""                            {System.out.println("comillas"); return new Symbol(SimbolosPnt.COMILLAS , yycolumn, yyline, yytext());}
    ("_"|{Letra})({Texto})*         {System.out.println("id: "+yytext()); return new Symbol(SimbolosPnt.IDENTIFICADOR , yycolumn, yyline, yytext());}
    ({Numero}|{Numero}"."{Numero})  {System.out.println("NUMERO: "+yytext()); return new Symbol(SimbolosPnt.NUMERO , yycolumn, yyline, yytext());}
    ":"                             {System.out.println("dos puntos"); return new Symbol(SimbolosPnt.DOS_PUNTOS , yycolumn, yyline, yytext());}
    "["                             {System.out.println("CHORCHETE ABRE"); return new Symbol(SimbolosPnt.CORCHETE_A , yycolumn, yyline, yytext());}
    "]"                             {System.out.println("CORCHE CIERRE"); return new Symbol(SimbolosPnt.CORCHETE_C , yycolumn, yyline, yytext());}
    "{"                             {System.out.println("LLAVES ABRE"); return new Symbol(SimbolosPnt.LLAVES_A , yycolumn, yyline, yytext());}
    "}"                             {System.out.println("LLAVES CIEERRE"); return new Symbol(SimbolosPnt.LLAVES_C , yycolumn, yyline, yytext());}
    ";"                             {System.out.println("PUNTO_COMA"); return new Symbol(SimbolosPnt.PUNTO_COMA , yycolumn, yyline, yytext());}
    ","                             {System.out.println("COMA"); return new Symbol(SimbolosPnt.COMA , yycolumn, yyline, yytext());}
    "="                             {System.out.println("IGUAL"); return new Symbol(SimbolosPnt.IGUAL , yycolumn, yyline, yytext());}
    "+"                             {System.out.println("MAS"); return new Symbol(SimbolosPnt.MAS , yycolumn, yyline, yytext());}
    "-"                             {System.out.println("MENOS"); return new Symbol(SimbolosPnt.MENOS , yycolumn, yyline, yytext());}
    "*"                             {System.out.println("ASTERISCO"); return new Symbol(SimbolosPnt.ASTERISCO , yycolumn, yyline, yytext());}
    "/"                             {System.out.println("DIAGONAL"); return new Symbol(SimbolosPnt.DIAGONAL , yycolumn, yyline, yytext());}
    "<"                             {System.out.println("MENOR_QUE"); return new Symbol(SimbolosPnt.MENOR_QUE , yycolumn, yyline, yytext());}
    ">"                             {System.out.println("MAYOR_QUE"); return new Symbol(SimbolosPnt.MAYOR_QUE , yycolumn, yyline, yytext());}
    "("                             {System.out.println("PARENTESIS_A"); return new Symbol(SimbolosPnt.PARENTESIS_A , yycolumn, yyline, yytext());}
    ")"                             {System.out.println("PARENTESIS_C"); return new Symbol(SimbolosPnt.PARENTESIS_C , yycolumn, yyline, yytext());}
    "."                             {System.out.println("punto"); return new Symbol(SimbolosPnt.PUNTO , yycolumn, yyline, yytext());}
    ".."                             {System.out.println("PUNTO_PUNTO"); return new Symbol(SimbolosPnt.PUNTO_PUNTO , yycolumn, yyline, yytext());}
    "<="                             {System.out.println("MENOR_IGUAL"); return new Symbol(SimbolosPnt.MENOR_IGUAL , yycolumn, yyline, yytext());}
    ">="                             {System.out.println("MAYOR_IGUAL"); return new Symbol(SimbolosPnt.MAYOR_IGUAL , yycolumn, yyline, yytext());}
    "=="                             {System.out.println("IGUAL_IGUAL"); return new Symbol(SimbolosPnt.IGUAL_IGUAL , yycolumn, yyline, yytext());}
    "<>"                             {System.out.println("DIFERENTE"); return new Symbol(SimbolosPnt.DIFERENTE , yycolumn, yyline, yytext());}



    .                               {System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext());
                                    ErrorG e = new ErrorG(yyline+1, yycolumn+1,yytext(),"Lexico","Error Lexico token: " + yytext()+"   Linea: " + (yyline+1) + " ,    Columna: " + (yycolumn+1));
                                    listaErrores.add(e);
                                    }
    
}

