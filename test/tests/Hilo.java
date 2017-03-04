/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import banco.Caja;
import banco.Reloj;
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
            
            int l = Util.randint(0, 100);
            for (int i = 0; i < l ; i++) {
                System.out.println(caja.getID()+" i:"+i);
                PILA dinero = caja.prestar("{10:2}");
                caja.billet().guardar(dinero);
                Reloj.sleep(100);
            }
        
            //System.out.println("Caja"+caja.getID()+" "+caja.get_deudas());
            System.out.println("Caja"+caja.getID()+" "+caja.get_deudas_id()+ "l:"+l);
            //System.out.println(((Caja)Util.buscaCaja(caja.banco().cajas(), 5)).billet());
        //)
    }       
}
