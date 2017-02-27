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
    private Billetera wallet = new Billetera();
    Transaccion t;
    
    public Cliente(){
        this.init = Util.randint(500, 50000);
        wallet.llenar(init,Util.randbool());
        t = new Transaccion(Util.randchar(Transaccion.TRANS));
    };
    
    public int dinero(){
        return wallet.get_saldo();
    }
    
    public Billetera billet(){
        return this.wallet;
    }
    
    public Transaccion transaccion(){
        return this.t;
    }
}
