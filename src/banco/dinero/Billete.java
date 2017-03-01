// NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR
package banco.dinero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tda.PILA;

public class Billete {
    private int valor;
    public Billete(int valor){
	this.valor = valor;
    }
    
    public int get_valor(){
	return this.valor;
    }

    public static int contar(PILA dinero){
        int cuenta=0;
        PILA aux = new PILA();
        while (!dinero.VACIA()) {            
            cuenta+=((Billete)dinero.TOPE()).get_valor();
            aux.METE(dinero.TOPE());
            dinero.SACA();
        }
        while (!aux.VACIA()) {            
            dinero.METE(aux.TOPE());
            aux.SACA();
        }
        return cuenta;
    }
    
    public static int contar(String str){
        // Recibe una cadena de la forma 
        //{den_1:cant_1,den_2:cant_2, ... , den_n:cant_n}
        int dinero=0;
        str = str.replaceAll("\\s", "");
        String regexp = "[0-9]+\\s*\\:\\s*[0-9]+";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(str);
        while (m.find()) {
            String pair = m.group();
            int den = Integer.parseInt(pair.split(":")[0]);
            int cant = Integer.parseInt(pair.split(":")[1]);
            dinero+=(den*cant);
        }
        return dinero;
    }
    
    @Override
    public String toString() {
        return this.valor+"";
    }
    
    
}
