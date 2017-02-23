// NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR
package banco.dinero;

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
        return cuenta;
    }
    
    @Override
    public String toString() {
        return this.valor+"";
    }
    
    
}
