package banco.transaccion;
import banco.dinero.Billete;
import tda.PILA;

						


//RETIRO
// Recibe monto entre 500-50,000 y Necesidad de Billetes(String)
// int monto, String necesidad_de_billetes
// Ejemplo
//String Necesidad = "{500:5,100:2,20:1}" // No espacios

//DEPOSITO
// Recibe un monto y los billetes a "depositar" (Puede que se necesite cambio(Vuelto))
// int monto, PILA billetes_a_depositar

//CAMBIO
// Recibe un monto, un arreglo de billete(s) y una cadena de necesidad de cambio
// int monto , Billete[] billete_a_cambiar, String necesidad_de_billetes
// Ejemplo
//String Necesidad = "{500:5,100:2,20:1}" // No espacios

public class Transaccion {
    private int monto;
    private PILA dinero;
    private String necesidad;
    private final char tipo;
    public static final char[] TRANS = {'D','R','C'};
    
    public Transaccion(char tipo){
        this.tipo=tipo;
    }
    
    
    
    public char tipo(){
        return this.tipo;
    }
    
    public int getMonto(){
        return this.monto;
    }

    /**
     * @return the dinero
     */
    public PILA getDinero() {
        return dinero;
    }

    /**
     * @param dinero the dinero to set
     */
    public void setDinero(PILA dinero) {
        this.dinero = dinero;
        this.monto = Billete.contar(dinero);
    }

    /**
     * @return the necesidad
     */
    public String getNecesidad() {
        return necesidad;
    }

    /**
     * @param necesidad the necesidad to set
     */
    public void setNecesidad(String necesidad) {
        this.necesidad = necesidad;
        this.monto = Billete.contar(necesidad);
    }
    
}
