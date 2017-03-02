/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import banco.dinero.Billetera;
import banco.transaccion.Transaccion;
import tda.COLA;
import tda.PILA;

/**
 *
 * @author jaguilar992
 */
public class Caja {
    
    private final Billetera wallet = new Billetera();
    private final int fondo = 1000000;
    private final COLA clientes = new COLA();
    private static final int LIMIT_COLA=20;
    private int CUENTA_COLA=0;
    public static final float DELAY_MIN=9.6f; // MINUTOS
    public static final float DELAY_MAX=4.8f; // MINUTOS
    private int ID;
    private boolean abierto;
    private Registro reg;
    
    public Caja(){
        wallet.llenar(fondo);
    }
    public boolean agrega_cliente(Cliente a){
         if (this.cuenta_cola()<Caja.LIMIT_COLA) {
            clientes.PON_EN_COLA(a);
            this.CUENTA_COLA++;
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
                client.billet().guardar(next.getDinero());
                this.clientes.QUITA_DE_COLA();
                return true;
            }
            case 'R':{
                // Detectar si se necesita prestamo entre cajas
                // En el peor de los casos, si no hay fondos en las cajas, contar cliente no atendido.
                PILA retiro = wallet.obtener(next.getNecesidad());
                if (retiro==null) {
                    PILA prestamo = this.prestar(next.getNecesidad());
                    if (prestamo==null) {
                        this.reg.no_atendido(next);
                        this.clientes.QUITA_DE_COLA();
                        return false;
                    }else{
                        client.billet().guardar(prestamo);
                        this.reg.atendido(next);
                        this.clientes.QUITA_DE_COLA();
                        return true;
                    }
                }else{
                    client.billet().guardar(retiro);
                    this.reg.atendido(next);
                    this.clientes.QUITA_DE_COLA();
                    return true;
                }
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
    
    public PILA prestar(String str){
        PILA prestamo = new PILA();
        return prestamo;
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
    
    public void setControl(Registro reg){
        this.reg=reg;
    }
    
    public Registro getControl(){
        return this.reg;
    }
    
    
}