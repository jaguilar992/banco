// NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR
package tda;

public class PILA {
    
    private LISTA pila;
    
    public PILA(){
        this.pila = new LISTA();
    };
    
    public void ANULA(){
        pila.ANULA();
        
    }
   
    public void METE(Object x){
        pila.INSERTA(x, pila.FIN());
        
    }
    
    public boolean VACIA(){
        return pila.PRIMERO()==pila.FIN();     
    }
    
    public Object TOPE(){
        if (this.VACIA()!=true) {
            return pila.RECUPERA(pila.ANTERIOR(pila.FIN()));
        }else{
            System.err.println("No se halló TOPE: PILA vacía");
            return null;
        }
    }
    
    public void SACA(){
    	if (this.VACIA()!=true) {
	        pila.SUPRIME(pila.ANTERIOR(pila.FIN()));
    	}else{
    	    System.err.println("No se halló TOPE: PILA vacía");
    	}	
    }
    
    public int CUENTA() { // AÑADIDA: DEVUELVE EL NUMERO DE ELEMENTOS EN PILA
	return pila.FIN();
    }

   @Override // util para impresion
    public String toString() {
	String m ="P[";
	for (int i = this.pila.PRIMERO(); i <this.pila.FIN(); i++) {
	    m+=(this.pila.getArrLista()[i]).toString()+" ";
	}
	return m+"|";
    } 
}
  
    

