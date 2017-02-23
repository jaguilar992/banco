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
public class Deposito extends Transaccion{
    
    public Deposito() {
        super("D"); // DEFINIR LO QUE RECIBE
        // Recibe un monto y los billetes a "depositar" (Puede que se necesite cambio(Vuelto))
        // int monto, Billete[] billetes_a_depositar
    }
    
}
