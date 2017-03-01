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
    public static final float DELAY_MIN = 1f;
    public static final float DELAY_MAX = 5f;
    private final LISTA cajas = new LISTA();
    private boolean abierto;
    
    public Registro(){}
    
    public void no_atendido(String necesidad, Transaccion t){
        Registro.clientes_no_caja++;
    }
    
    public void no_atendido(){
        Registro.clientes_no++;
    }
    
    public Cliente crea_cliente(){
        return new Cliente();
    }
    
    public boolean cliente_a_caja(Cliente c){
        int n = this.cajas.ANTERIOR(this.cajas.FIN());
        return false;
    }
    
    public void abrir(){
        this.abierto=true;
    }
    
    public  void cerrar(){
        this.abierto=false;
    }
    
    public boolean is_abierto(){
        return this.abierto;
    }
}


