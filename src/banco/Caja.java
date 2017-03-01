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
    
    private final Billetera wallet = new Billetera();
    private final int fondo = 1000000;
    private final COLA clientes = new COLA();
    private static final int LIMIT_COLA=20;
    public static final float DELAY_MIN=9.6f;
    public static final float DELAY_MAX=4.8f;
    private int ID;
    private boolean abierto;
    
    public Caja(){
        wallet.llenar(fondo);
    }
    public boolean agrega_cliente(Cliente a){
         if (this.cuenta_cola()<Caja.LIMIT_COLA) {
            clientes.PON_EN_COLA(a);
            return true;
         }else{
             return false;
         }
     }
    public boolean atiende_cliente(Cliente a){
        Cliente client = (Cliente)clientes.FRENTE();
        Transaccion next = client.transaccion();
        switch(next.tipo()){
            case 'D':{
                wallet.guardar(next.getDinero());
                return true;
            }
            case 'R':{
                // Detectar si se necesita prestamo entre cajas
                // En el peor de los casos, si no hay fondos en las cajas, contar cliente no atendido.
                return true;
            }
            case 'C':{
                // Detectar si se necesita prestamo entre cajas
                return true;
            }
            default:
                return false;
        }
    }
      
    public Billetera billet(){
        return this.wallet;
    }
    
    public int cuenta_cola(){
        return this.clientes.CUENTA();
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public void abrir() {
        this.abierto = true;
    }

    public void cerrar() {
        this.abierto = false;
    }

    public boolean is_abierto() {
        return this.abierto;
    }
    
}