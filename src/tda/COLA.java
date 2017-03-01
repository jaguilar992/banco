// NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR
package tda;
public class COLA {
	private LISTA cola = new LISTA();
    
        public COLA(){};
	
	public void ANULA(){
		cola.ANULA();
	}
	
	public void PON_EN_COLA(Object x){
		cola.INSERTA(x, cola.FIN());
	}
	
	public void QUITA_DE_COLA (){
		if (!this.VACIA()) {
			cola.SUPRIME(cola.PRIMERO());
		}else{
			System.err.println("No se encontró FRENTE: COLA vacía");
		}
	}
	
	public Object FRENTE (){
		if (!this.VACIA()) {
			return cola.RECUPERA(cola.PRIMERO());
		}else{
			System.err.println("No se encontró FRENTE: COLA vacía");
			return null;	
		}
	}
	
	public boolean VACIA(){
	    return cola.PRIMERO()==cola.FIN();
	}
	
	public int CUENTA(){ //AÑADIDA
	    return cola.FIN();
	}

    @Override // util para impresion
    public String toString() {
	String m ="C <";
	for (int i = this.cola.PRIMERO(); i <this.cola.FIN(); i++) {
	    m+=(this.cola.getArrLista()[i]).toString()+" ";
	}
	return m+"<--";
    }   
}
