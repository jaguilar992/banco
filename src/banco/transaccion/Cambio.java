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
public class Cambio extends Transaccion{
    
    public Cambio() {
        super("C"); // DEFINIR LO QUE RECIBE
        // Recibe un monto, un arreglo de billete(s) y una cadena de necesidad de cambio
        // int monto , Billete[] billete_a_cambiar, String necesidad_de_billetes
        // Ejemplo
        //String Necesidad = "{500:5,100:2,20:1}" // No espacios
    }
    
}
