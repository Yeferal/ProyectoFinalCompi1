
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu May 21 17:25:41 CST 2020
//----------------------------------------------------

package analizadores.clrs;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import objetos.*;
import tablas.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu May 21 17:25:41 CST 2020
  */
public class AnalizadorSintacticoClrs extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintacticoClrs() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoClrs(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoClrs(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\025\000\002\002\004\000\002\002\005\000\002\002" +
    "\004\000\002\002\004\000\002\013\002\000\002\003\010" +
    "\000\002\014\002\000\002\004\011\000\002\005\004\000" +
    "\002\005\002\000\002\015\002\000\002\016\002\000\002" +
    "\007\012\000\002\006\004\000\002\006\002\000\002\010" +
    "\007\000\002\010\003\000\002\011\005\000\002\011\005" +
    "\000\002\011\005\000\002\012\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\064\000\006\003\005\011\004\001\002\000\004\013" +
    "\060\001\002\000\014\015\020\025\016\026\017\027\015" +
    "\030\010\001\002\000\004\002\007\001\002\000\004\002" +
    "\001\001\002\000\004\006\055\001\002\000\004\002\ufffe" +
    "\001\002\000\006\002\ufff1\012\ufff1\001\002\000\004\002" +
    "\uffff\001\002\000\004\007\051\001\002\000\004\006\047" +
    "\001\002\000\004\006\045\001\002\000\004\006\043\001" +
    "\002\000\004\006\ufffb\001\002\000\004\006\022\001\002" +
    "\000\004\011\023\001\002\000\004\015\024\001\002\000" +
    "\004\006\ufff7\001\002\000\004\012\026\001\002\000\010" +
    "\002\ufff8\007\027\012\ufff8\001\002\000\004\015\020\001" +
    "\002\000\006\002\ufffa\012\ufffa\001\002\000\006\002\ufff9" +
    "\012\ufff9\001\002\000\004\006\033\001\002\000\004\011" +
    "\034\001\002\000\012\025\016\026\017\027\015\030\010" +
    "\001\002\000\004\012\036\001\002\000\006\007\ufff6\012" +
    "\ufff6\001\002\000\006\007\040\012\ufff3\001\002\000\004" +
    "\015\024\001\002\000\004\012\ufff5\001\002\000\004\012" +
    "\ufff4\001\002\000\004\016\044\001\002\000\010\002\ufff0" +
    "\007\ufff0\012\ufff0\001\002\000\004\020\046\001\002\000" +
    "\006\002\uffed\012\uffed\001\002\000\004\016\050\001\002" +
    "\000\010\002\uffef\007\uffef\012\uffef\001\002\000\010\026" +
    "\017\027\015\030\010\001\002\000\004\007\053\001\002" +
    "\000\010\026\017\027\015\030\010\001\002\000\006\002" +
    "\ufff2\012\ufff2\001\002\000\004\016\056\001\002\000\010" +
    "\002\uffee\007\uffee\012\uffee\001\002\000\004\012\066\001" +
    "\002\000\004\006\ufffd\001\002\000\004\006\062\001\002" +
    "\000\004\011\063\001\002\000\004\015\020\001\002\000" +
    "\004\012\065\001\002\000\004\012\ufffc\001\002\000\004" +
    "\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\064\000\004\002\005\001\001\000\004\003\056\001" +
    "\001\000\012\004\012\010\010\011\013\012\011\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\014\020\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\007\024\001\001\000\004\015\031\001" +
    "\001\000\002\001\001\000\004\005\027\001\001\000\004" +
    "\004\030\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\010\010\034\011\013" +
    "\012\011\001\001\000\002\001\001\000\004\016\036\001" +
    "\001\000\004\006\040\001\001\000\004\007\041\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\011\051\001\001\000" +
    "\002\001\001\000\004\011\053\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\013\060\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\004\063\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintacticoClrs$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintacticoClrs$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintacticoClrs$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    TablaSimbolos tablaSimbolos;
    TablaSimbolos tablaSimbolosColor;
    public ArrayList<ErrorG> listaErrores = new  ArrayList<>();
    
    public void setTablaColor(TablaSimbolos tablaSimbolosColor){
        this.tablaSimbolosColor = tablaSimbolosColor; 
    }

    public TablaSimbolos getTablaColor(){
        return tablaSimbolosColor; 
    }
    public void setTabla(TablaSimbolos tablaSimbolos){
        this.tablaSimbolos = tablaSimbolos; 
    }

    public TablaSimbolos getTabla(){
        return tablaSimbolos; 
    }

    private Symbol s;
    public void syntaxError(Symbol s){
        this.s = s;
    }
    public Symbol getS(Symbol s){
        return this.s = s;
    }

    public void setAccion(String tipo,String mensaje,String accion){
            System.out.println(tipo+"         "+mensaje);
        }

    public void syntax_error(Symbol s){
            if(s!=null){
                ErrorG e = new ErrorG(s.right,s.left,(String) s.value,"Sintactico","Error Sintaxis token: "+(String) s.value+" ------ Linea: " + (s.right+1) + ",   Columna: " + (s.left+1));
                listaErrores.add(e);
                setAccion("ERROR","Error Sintaxis token: Linea: " + (s.right+1) + ",   Columna: " + (s.left+1) + ",  Simbolo: " + s.value, "");
            }
    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintacticoClrs$actions {


    TablaSimbolos tablaSimbolos = new TablaSimbolos();
    TablaSimbolos tablaColores = new TablaSimbolos();
    Lienzo lienzo;
    Color color;
    String nombreLienzo;
    boolean correcto;
    boolean existeLienzo;

  private final AnalizadorSintacticoClrs parser;

  /** Constructor */
  CUP$AnalizadorSintacticoClrs$actions(AnalizadorSintacticoClrs parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoClrs$do_action(
    int                        CUP$AnalizadorSintacticoClrs$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoClrs$parser,
    java.util.Stack            CUP$AnalizadorSintacticoClrs$stack,
    int                        CUP$AnalizadorSintacticoClrs$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintacticoClrs$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintacticoClrs$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // ATRIB_HEX ::= HEX DOS_PUNTOS CODIGO_HEX 
            {
              Object RESULT =null;
		int hleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).left;
		int hright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).right;
		Object h = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.peek()).value;
		 color.setFondoHEX((String) h); 
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("ATRIB_HEX",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // ATRIB_RGB ::= GREEN DOS_PUNTOS NUMERO 
            {
              Object RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).right;
		Object g = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.peek()).value;
		 color.setGreen(Integer.parseInt((String) g)); RESULT = 3;
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("ATRIB_RGB",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // ATRIB_RGB ::= BLUE DOS_PUNTOS NUMERO 
            {
              Object RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.peek()).value;
		 color.setBlue(Integer.parseInt((String) b)); RESULT = 2;
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("ATRIB_RGB",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // ATRIB_RGB ::= RED DOS_PUNTOS NUMERO 
            {
              Object RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).right;
		Object r = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.peek()).value;
		 color.setRed(Integer.parseInt((String) r)); RESULT = 1;
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("ATRIB_RGB",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // ESTRUCTURA_FONDO ::= ATRIB_HEX 
            {
              Object RESULT =null;
		color.setTipoFondo(2);
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_FONDO",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ESTRUCTURA_FONDO ::= ATRIB_RGB COMA ATRIB_RGB COMA ATRIB_RGB 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-4)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-4)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-4)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-2)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-2)).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.peek()).value;
		 color.setTipoFondo(1);
                        int a1 = (int) a;
                        int a2 = (int) b;
                        int a3 = (int) c;
                        if(a1==a2 || a1==a3 || a2==a3){
                            correcto = false;
                            ErrorG e = null;
                            //error dato duplicado
                            System.out.println("se duplico algun atributo");
                            if(a1==a2){
                                e = new ErrorG(bright+1,bleft+1,(String) a,"Sintactico","Error Sintaxis token: "+(String) a+" ------ Linea: "+(bright+1)+",   Columna: "+(bleft+1));
                                System.out.println("Error Sintaxis token: "+(String) a+" ------ Linea: "+(bright+1)+",   Columna: "+(bleft+1));
                            }
                            if(a1==a3){
                                e = new ErrorG(cright+1,cleft+1,(String) a,"Sintactico","Error Sintaxis token: "+(String) a+" ------ Linea: "+(cright+1)+",   Columna: "+(cleft+1));
                                System.out.println("Error Sintaxis token: "+(String) a+" ------ Linea: "+(cright+1)+",   Columna: "+(cleft+1));
                            }

                            if(a2==a3){
                                e = new ErrorG(cright+1,cleft+1,(String) a,"Sintactico","Error Sintaxis token: "+(String) a+" ------ Linea: "+(cright+1)+",   Columna: "+(cleft+1));
                                System.out.println("Error Sintaxis token: "+(String) a+" ------ Linea: "+(cright+1)+",   Columna: "+(cleft+1));
                            }
                            
                            parser.listaErrores.add(e);
                        }
                    
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_FONDO",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-4)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // S1 ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("S1",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // S1 ::= COMA PARAMETROS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("S1",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // PARAMETROS ::= IDENTIFICADOR NT$2 DOS_PUNTOS LLAVES_A ESTRUCTURA_FONDO LLAVES_C NT$3 S1 
            {
              Object RESULT =null;
              // propagate RESULT from NT$3
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-7)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-7)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-7)).value;

              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("PARAMETROS",5, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-7)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // NT$3 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-4)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-5)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-5)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-5)).value;

            if(existeLienzo && correcto){
                if(!tablaColores.buscarSimboloTipo((String) a, nombreLienzo)){
                    SimboloObject simbolo = new SimboloObject((String) a, nombreLienzo, color);
                    tablaColores.agregarSimbolo(simbolo);
                }else{
                    ErrorG e = new ErrorG(aright+1,aleft+1,(String) a,"Semantico","El simbolo "+(String) a+" Tipo Color YA EXISTE");
                    parser.listaErrores.add(e);
                    System.out.println("Semantico: El simbolo "+(String) a+" Tipo Color YA EXISTE");
                }
            }
            
            
            
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("NT$3",12, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // NT$2 ::= 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.peek()).value;
color = new Color(); color.setNombre((String) a);  correcto = true; 
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("NT$2",11, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // S0 ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("S0",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // S0 ::= COMA ESTRUCTURA_PARAMETROS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("S0",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ESTRUCTURA_PARAMETROS ::= IDENTIFICADOR NT$1 DOS_PUNTOS LLAVES_A PARAMETROS LLAVES_C S0 
            {
              Object RESULT =null;
              // propagate RESULT from NT$1
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-5)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-6)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-6)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-6)).value;

              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_PARAMETROS",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // NT$1 ::= 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.peek()).value;

                        nombreLienzo = (String) a;
                        if(tablaSimbolos.buscarSimboloTipo((String) a,"Lienzo")){
                            existeLienzo = true;
                        }else{
                            existeLienzo = false;
                            ErrorG e = new ErrorG(aright+1,aleft+1,(String) a,"Semantico","El simbolo "+(String) a+" Tipo Lienzo NO EXISTE");
                            parser.listaErrores.add(e);
                            System.out.println("Semantico: El simbolo "+(String) a+" Tipo Lienzo NO EXISTE");
                        }
                        
                        
                        
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("NT$1",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ESTRUCTURA_COLORES ::= COLORES NT$0 DOS_PUNTOS LLAVES_A ESTRUCTURA_PARAMETROS LLAVES_C 
            {
              Object RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-4)).value;
		 parser.setTablaColor(tablaColores); 
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("ESTRUCTURA_COLORES",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-5)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // NT$0 ::= 
            {
              Object RESULT =null;
tablaSimbolos = parser.getTabla();
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("NT$0",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INICIO ::= error ESTRUCTURA_FONDO 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).value;
		parser.syntax_error((Symbol)e);
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INICIO ::= error ESTRUCTURA_PARAMETROS 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).value;
		parser.syntax_error((Symbol)e);
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= LLAVES_A ESTRUCTURA_COLORES LLAVES_C 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoClrs$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintacticoClrs$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.elementAt(CUP$AnalizadorSintacticoClrs$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoClrs$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintacticoClrs$parser.done_parsing();
          return CUP$AnalizadorSintacticoClrs$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}
