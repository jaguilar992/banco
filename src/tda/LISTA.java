// NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR - NO MODIFICAR
package tda;
public class LISTA{
	private final int n = 10000;
	private Object [] arrLista = new Object[n];
	private int ultimo = -1; // Inicia vacío
	
	public int PRIMERO(){
		return 0; // Siempre retorna la primera cubeta del arreglo
	}

	public int ANTERIOR(int pos){
	    if (pos>this.PRIMERO() && pos<=this.FIN()) { // Verifica que la posicion sea valida en lista
		return pos-1;
	    }else{
		System.err.println("Error en ANTERIOR("+pos+"): Posición no existe");
		return -1;
	    }
	}

	public int SIGUIENTE(int pos){
	    if(pos>=this.PRIMERO() && pos<this.FIN()){ // Verifica que la posicion sea valida en lista
		return pos+1;
	    }else{
		System.err.println("Error en SIGUIENTE("+pos+"): Posición no existe");
		return -1;
	    }
	}

	public void ANULA(){
		this.arrLista=new Object[this.n]; // Inicializa el arreglo, Problema: Basura en memoria
		this.ultimo=-1; // Resetea ultimo
	}

	public int FIN(){
		return this.ultimo+1;
	}

	public int LOCALIZA(Object x){ // Devuelve la posicion del objeto x en Lista
		for (int i=0;i<this.FIN();i++ ) {
			if (getArrLista()[i].equals(x)) {
				return i;
			}
		}
		return this.FIN(); // sino lo encuentra devuelve fin
	}
	
	public Object RECUPERA(int pos){
		if (pos>=this.PRIMERO() && pos<this.FIN()) { // Verifica que la posicion sea valida
	    		return getArrLista()[pos]; // Devuelve el dato en la posicion pos
		}else{ // En caso de no existir posicion en lista
			System.err.println("ERROR en RECUPERA("+pos+"): Posicion no existe");
			return null;
		}
	}
	
	public void INSERTA(Object x,int pos){
	    if(ultimo!=this.n-1){
		    if(pos>=this.PRIMERO() && pos<=this.FIN()){ // Verificar que la insercion sea valida
		        for (int i = FIN(); i >pos; i--) { // Corre los elementos un espacio adelante, comenzando en fin
		        	 arrLista[i] = getArrLista()[ANTERIOR(i)]; // Copiar en [i] lo que hay en [i-1]
		        }
		        arrLista[pos] = x;
		        this.ultimo++;
	           }else{
		       System.err.println("ERROR en INSERTA("+pos+"): Posición inválida");
	           }
	    }else{
		    System.err.println("ERROR en INSERTA: Memoria insuficiente");
	    }
	}
	
	public void SUPRIME(int pos){
	    if(pos>=this.PRIMERO() && pos<this.FIN()){ // Verificar que suprimir sea valida
		for (int i = pos; i < this.ANTERIOR(this.FIN()); i++) {
			arrLista[i]=getArrLista()[i+1]; // Corre los elementos hacia atrás, desde la pos+1 hasta fin
		    }
		    arrLista[this.ANTERIOR(this.FIN())]=null; // Resetea la ultima cubeta a null
		    this.ultimo--;
	    }else{
		System.err.println("ERROR en SUPRIME("+pos+"): posición no válida");
	    }
	}
        
        public int CUENTA(){ //AÑADIDA
	    return this.FIN();
	}

    @Override // util para impresion
    public String toString() {
	String m ="L <";
	for (int i = this.PRIMERO(); i <this.FIN(); i++) {
	    m+=(this.arrLista[i]).toString()+",";
	}
	return m+">";
    }

    /**
     * @return the arrLista
     */
    public Object[] getArrLista() {
        return arrLista;
    }
}
