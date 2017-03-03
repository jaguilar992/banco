/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import banco.Caja;
import banco.Util;
import tda.PILA;

/**
 *
 * @author jaguilar992
 */
public class Hilo extends Thread{
    private Caja caja;
    public Hilo(Caja caja){
        this.caja = caja;
    }

    @Override
    public void run() {
        //int i=0;
//        while (caja.get_deudas().CUENTA()>0) {
//            if (caja.pagar()) {
//                System.out.println("Caja: "+caja.getID()+" Ciclo: "+i+": Pago -- "+caja.get_deudas().CUENTA());
//            }else{
//                System.out.println();
//            }
//            i++;
//            this.sleep(50);
//        }
        //synchronized(
        
            for (int i = 0; i < 1500; i++) {
                PILA dinero = new PILA();
                dinero = caja.prestar("{10:2}");
                caja.billet().guardar(dinero);
                //sleep(100);
            }
        
            //System.out.println("Caja"+caja.getID()+" "+caja.get_deudas());
            System.out.println("Caja"+caja.getID()+" "+caja.get_deudas_id());
            //System.out.println(((Caja)Util.buscaCaja(caja.getControl().cajas(), 5)).billet());
        //)
    }
    
    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
            
}
