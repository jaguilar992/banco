/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import banco.dinero.Billetera;
import banco.transaccion.Transaccion;

/**
 *
 * @author jaguilar992
 */
public class Cliente {
    private final int init;
    public Billetera wallet = new Billetera();
    Transaccion t;
    
    public Cliente(){
        this.init = Util.randint(500, 50000);
        wallet.llenar(init,Util.randbool());
    };
    
    public int dinero(){
        return wallet.get_saldo();
    }
}
