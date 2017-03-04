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
    private static int atentido;
    public static final float DELAY_MIN = 1f; // MINUTOS
    public static final float DELAY_MAX = 3f; // MINUTOS
    private final LISTA cajas = new LISTA();
    private boolean abierto;
    private boolean log;
    private int D=0;
    private int R=0;
    private int C=0;
    private int DN=0;
    private int RN=0;
    private int CN=0;
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\033[36m";
    public static final String RED = "\033[35m";
    
    public Registro(){}
    
    public synchronized void atendido(Caja caja,Transaccion t){
        Registro.atentido++;       
        switch(t.tipo()){
            case 'D':
                if(log) System.out.println(CYAN+"Caja"+caja.getID()+":: "+t.tipo()+" : "+t.getMonto()+RESET);
                D+=t.getMonto();
                DN++;
            break;case 'R':
                if(log) System.out.println(CYAN+"Caja"+caja.getID()+":: "+t.tipo()+" : "+t.getMonto()+" : "+t.getNecesidad()+RESET);
                R+=t.getMonto();
                RN++;
            break; case 'C':
                if(log) System.out.println(CYAN+"Caja"+caja.getID()+":: "+t.tipo()+" : "+t.getMonto()+" : "+t.getNecesidad()+RESET);
                C+=t.getMonto();
                CN++;
            break;default:
            break;
        }
    }
    
    public synchronized void no_atendido(Caja caja,Transaccion t){
        Registro.clientes_no_caja++;
        switch (t.tipo()) {
            case 'D':
                if(log) System.out.println(RED+"#Caja" + caja.getID() + ":: " + t.tipo() + " : " + t.getMonto()+RESET);
                D += t.getMonto();
                break;
            case 'R':
                if(log) System.out.println(RED+"#Caja" + caja.getID() + ":: " + t.tipo() + " : " + t.getMonto() + " : " + t.getNecesidad()+RESET);
                R += t.getMonto();
                break;
            case 'C':
                if(log) System.out.println(RED+"#Caja" + caja.getID() + ":: " + t.tipo() + " : " + t.getMonto() + " : " + t.getNecesidad()+RESET);
                C += t.getMonto();
                break;
            default:
                break;
        }
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
        if (n>0) {
            do {
                caja_i = Util.randint(n - 1); // Random
                espera++;
                cuenta_i = ((Caja) cajas.RECUPERA(caja_i)).cuenta_cola();
            } while (cuenta_i >= 20 && espera < WAIT);
            // Revisará WAIT veces las cajas (repeticiones) aleatoriamente antes de desistir
            // Ya que podria haber liberacion de algun cupo

            if (espera >= WAIT) { // Se alcanzo limite de espera, el cliente no se atenderá en cola
                return false;
            } else {
                ((Caja) cajas.RECUPERA(caja_i)).agrega_cliente(c); // Agregra cliente a la caja i
                return true;
            }
        }else{
            return false;
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
    
    public void log(boolean log){
        this.log=log;
    }

    @Override
    public String toString() {
        return "Registro{\n"+
                "Total Atendidos: " +Registro.atentido+"\n"+
                "Transacciones No realizadas: "+ Registro.clientes_no_caja+"\n"+
                "Clientes No atendidos: "+ Registro.clientes_no+"\n"+
                "Total Dinero Retiros ("+RN+"): "+R+"\n"+
                "Total Dinero Depositos ("+DN+"):"+D+"\n"+
                "Total Dinero Cambios ("+CN+"): "+C+"\n"+
                "}";
    }
    
    
}


