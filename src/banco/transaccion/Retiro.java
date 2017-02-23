/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.transaccion;

/**
 *
 * @author jaguilar992
 */
public class Retiro extends Transaccion{
    
    public Retiro() {
        super("R"); // DEFINIR LO QUE RECIBE
        // Recibe monto entre 500-50,000 y Necesidad de Billetes(String)
        // int monto, String necesidad_de_billetes
        // Ejemplo
        //String Necesidad = "{500:5,100:2,20:1}" // No espacios
        
    }
    
}
