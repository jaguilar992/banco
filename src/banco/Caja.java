/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import banco.dinero.Billetera;
import banco.transaccion.Transaccion;
import tda.COLA;

/**
 *
 * @author jaguilar992
 */
public class Caja {
    
    public Billetera wallet;
    private final int fondo = 1000000;
    private COLA clientes;
    private final int lim_cola=20;
    public static final float DELAY_MIN=10;
    public static final float DELAY_MAX=30;
    
    public Caja(){
        wallet.llenar(fondo);
    }
    public boolean agrega_cliente(Cliente a){
         if (lim_cola < 20) {
            clientes.PON_EN_COLA(a);
            return true;
         }else{
             return false;
         }
     }
    public void atiende_cliente(Cliente a){
        Cliente client = (Cliente)clientes.FRENTE();
        Transaccion next = client.transaccion();
        switch(next.tipo()){
            case 'D':{
            }
            break; case 'R':{
            }
            break; case 'C':{
            }
            break; default:
            break;
        }
    }
      
    public Billetera billet(){
        return this.wallet;
    }
}