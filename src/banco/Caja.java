/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import banco.dinero.Billete;
import banco.dinero.Billetera;
import banco.transaccion.Transaccion;
import tda.COLA;
import tda.LISTA;
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
    public static final float DELAY_MAX=9.6f; // MINUTOS
    public static final float DELAY_MIN=4.8f; // MINUTOS
    private int ID;
    private boolean abierto;
    private Registro reg;
    private LISTA deuda_str = new LISTA(); // Aqui se agregaran las deudas de la caja actual hacia las demas (Cadena necesidad)
    private LISTA deuda_i = new LISTA(); // Numero de caja a la que se le debe en deuda_i
    
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
                this.reg.atendido(next);
                this.clientes.QUITA_DE_COLA();
                return true;
            }
            case 'R':{
                // Detectar si se necesita prestamo entre cajas
                // En el peor de los casos, si no hay fondos en las cajas, contar cliente no atendido.
                PILA retiro = wallet.obtener(next.getNecesidad());
                if (retiro==null) {
                    PILA dinero = this.prestar(next.getNecesidad());
                    if (dinero==null) {
                        this.reg.no_atendido(next);
                        this.clientes.QUITA_DE_COLA();
                        return false;
                    }else{
                        client.billet().guardar(dinero);
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
                PILA cambio = wallet.obtener(next.getNecesidad());
                if (cambio== null) {
                    PILA dinero = this.prestar(next.getNecesidad());
                    if (dinero == null) {
                        this.reg.no_atendido(next);
                        this.clientes.QUITA_DE_COLA();
                        return false;
                    } else {
                        wallet.guardar(next.getDinero());
                        client.billet().guardar(dinero);
                        this.reg.atendido(next);
                        this.clientes.QUITA_DE_COLA();
                        return true;
                    }
                } else {
                    wallet.guardar(next.getDinero());
                    client.billet().guardar(cambio);
                    this.reg.atendido(next);
                    this.clientes.QUITA_DE_COLA();
                    return true;
                }
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
    
    public synchronized PILA prestar(String str){
        PILA prestamo = new PILA();
        LISTA cajas = this.reg.cajas();
        int n = cajas.ANTERIOR(cajas.FIN());
        
        
        return prestamo;
    }
    
    public synchronized boolean pagar(){
        String deuda = (String)deuda_str.RECUPERA(deuda_str.PRIMERO());
        int monto_deuda = Billete.contar(deuda);
        
        PILA pago = wallet.obtener(deuda); // Prueba devolviendo los mismos billetes que se le prestaron
        PILA pago2 = wallet.obtener(monto_deuda); // Prueba devolviendo el monto deglosado
        int n_caja =(int)deuda_i.RECUPERA((int)deuda_i.PRIMERO())-1; // OJO, debido a la implementacion de RECUPERA, PRIMERO(L)->0, DEBERIA ARREGLARSE, PERO YA ESTAMOS SOBRE TIEMPO
        Caja pagare = (Caja)this.reg.cajas().RECUPERA(n_caja);
        if (pago!=null) {
            pagare.billet().guardar(pago);
            return true;
        }else if (pago2!=null) {
            pagare.billet().guardar(pago2);
            return true;
        }else{
            return false;
        }
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

    @Override
    public String toString() {
        return "Caja{" + ", ID:" + ID + " dinero: " + wallet.get_saldo()+" clientes"+clientes.CUENTA()+" }";
    }
    
    
}