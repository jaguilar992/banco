/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import banco.transaccion.Transaccion;
import tda.LISTA;

/**
 *
 * @author jaguilar992
 */
public class Registro {
    private static  int clientes_no; // Contador de clientes no atendidos desde entrada.
    private static int clientes_no_caja; // Contador de clientes no atendidos desde la caja.
    public static final float DELAY_MIN = 2f; // MINUTOS
    public static final float DELAY_MAX = 5f; // MINUTOS
    private final LISTA cajas = new LISTA();
    private boolean abierto;
    
    public Registro(){}
    
    public synchronized void atendido(Transaccion t){
    }
    
    public synchronized void no_atendido(Transaccion t){
        Registro.clientes_no_caja++;
    }
    
    public void no_atendido(){
        Registro.clientes_no++;
    }
    
    public Cliente nuevo_cliente(){
        return new Cliente();
    }
    
    public synchronized boolean cliente_a_caja(Cliente c){ // Manda cliente c a una de las cajas, para posible atencion
        int espera=0;
        int WAIT = 20;
        int n = this.cajas.FIN(); // Tamaño de la lista de cajas
        int caja_i, cuenta_i; // Caja seleccionada para agregar Cliente c (Aleatoriamente)
        do{
            caja_i = Util.randint(n-1); // Random
            espera++;
            cuenta_i = ((Caja)cajas.RECUPERA(caja_i)).cuenta_cola();
        }while(cuenta_i>=20 && espera<WAIT); 
        // Revisará WAIT veces las cajas (repeticiones) aleatoriamente antes de desistir
        // Ya que podria haber liberacion de algun cupo

        if (espera>=WAIT) { // Se alcanzo limite de espera, el cliente no se atenderá en cola
            return false;
        }else{
            ((Caja)cajas.RECUPERA(caja_i)).agrega_cliente(c); // Agregra cliente a la caja i
            return true;
        }
    }
    
    public void abrir(){
        this.abierto=true;
    }
    
    public void cerrar(){
        this.abierto=false;
    }
    
    public synchronized boolean is_abierto(){
        return this.abierto;
    }

    public void enlaza_caja(Caja caja){
        caja.setControl(this);
        this.cajas.INSERTA(caja,this.cajas.FIN());
    }
    
    public synchronized LISTA cajas(){
        return this.cajas;
    }
    
    public Caja caja_i(int i){
        return (Caja)this.cajas.RECUPERA(i);
    }
}


