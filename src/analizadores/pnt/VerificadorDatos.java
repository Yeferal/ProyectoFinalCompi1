
package analizadores.pnt;

public class VerificadorDatos {
    
    public boolean resultado;
    public boolean existeError;
    
    public void verificar(Object obj1, Object obj2, int operacion){
        if(verificarTipoDato(obj1) && verificarTipoDato(obj2)){
            existeError = false;
            numeroNumero(obj1, obj2, operacion);
        }else if(verificarTipoObjeto(obj1)==2 && verificarTipoObjeto(obj2)==2){
            if(operacion==1 || operacion==6){
                existeError = false;
                boleanoBoleano(obj1, obj2, operacion);
            }else{
                existeError = true;
            }
        }else{
            existeError = false;
            textoTexto(obj1, obj2, operacion);
        }
        
        
    }
    
    public int verificarTipoObjeto(Object o){
        if(o instanceof Integer){
            return 1;
        }else if(o instanceof Boolean){
            return 2;
        }
        return 3;
    }
    
    public boolean verificarTipoDato(Object o){
        try {
		Integer.parseInt((String) o);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
        catch (ClassCastException ex){
		return true;
	}
    }
    
    public int convertirNumero(Object o){
        try {
		int val = Integer.parseInt((String) o);
		return val;
	}catch (ClassCastException ex){
		int val = (int) o;
		return val;
	}
    }
    
    public void numeroNumero(Object obj1, Object obj2, int operacion){
        int val1 = convertirNumero(obj1);
        int val2 = convertirNumero(obj2);
        System.out.println(val1+"--"+operacion+"--"+val2);
        switch(operacion){
            case 1:
                if(val1==val2){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 2:
                if(val1<val2){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 3:
                if(val1>val2){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 4:
                if(val1>=val2){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 5:
                if(val1<=val2){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 6:
                if(val1!=val2){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
        }
    }
    public void textoTexto(Object obj1, Object obj2, int operacion){
        String val1 = (String) obj1;
        String val2 = (String) obj1;
        
        switch(operacion){
            case 1:
                if(val1.equals(obj2)){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 2:
                if(val1.length()<val2.length()){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 3:
                if(val1.length()>val2.length()){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 4:
                if(val1.length()>=val2.length()){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 5:
                if(val1.length()<=val2.length()){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 6:
                if(!val1.equals(obj2)){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
        }
    }
    public void boleanoBoleano(Object obj1, Object obj2, int operacion){
        boolean val1 = (boolean) obj1;
        boolean val2 = (boolean) obj1;
        
        switch(operacion){
            case 1:
                if(val1==val1){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
            case 6:
                if(val1!=val1){
                    resultado = true;
                }else{
                    resultado = false;
                }
                break;
        }
    }
    
}
