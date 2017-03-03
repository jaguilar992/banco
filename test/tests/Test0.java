// TEST
// ------------------------- > TEST 01
// Pruebas con TDAS
package tests;


import tda.COLA;
import tda.LISTA;
import tda.PILA;


public class Test0 {
    public static void main(String args[]){
	LISTA lista = new LISTA();
	System.out.println(lista);
	lista.INSERTA(7,lista.FIN());
	System.out.println(lista);
	lista.INSERTA(2,lista.PRIMERO());
	System.out.println(lista);
	lista.INSERTA(30,lista.FIN());
	lista.INSERTA(30,lista.PRIMERO());
        System.out.println("AQUI: "+lista.PRIMERO());
	lista.INSERTA(5,lista.FIN());
	lista.INSERTA(6,lista.PRIMERO());
	System.out.println(lista);
	lista.SUPRIME(lista.FIN());
	System.out.println(lista);
	//lista.ANULA();
	//System.out.println(lista);
	System.out.println(lista.FIN());
	
	
	
        LISTA l1 = new LISTA();
        LISTA l2 = new LISTA();
        
        l1.INSERTA("a", l1.FIN());
        l1.INSERTA("b", l1.FIN());
        l1.INSERTA("c", l1.FIN());
        l1.INSERTA("d", l1.FIN());
        
        l2.INSERTA("b", l2.FIN());
        l2.INSERTA("c", l2.FIN());
        l2.INSERTA("d", l2.FIN());
        
        //System.out.println(l1.SUBLISTA(l2));
        
        COLA cola = new COLA();
        cola.PON_EN_COLA(1);
        cola.PON_EN_COLA(2);
        cola.PON_EN_COLA(3);
        System.out.println(cola);
        cola.QUITA_DE_COLA();
        System.out.println(cola);
        cola.PON_EN_COLA(4);
        System.out.println(cola);
        System.out.println(cola.CUENTA());
        
        PILA pila = new PILA();
        pila.METE(1);
        pila.METE(2);
        pila.METE(3);
        pila.METE(4);
        System.out.println(pila);
        pila.SACA();
        //pila.SACA();
        System.out.println(pila);
	System.out.println(pila.CUENTA());
    }
}
