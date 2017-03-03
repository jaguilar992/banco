/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import banco.Caja;
import banco.Cliente;
import banco.Registro;
import banco.Util;
import tda.LISTA;

/**
 *
 * @author jaguilar992
 */
public class PruebaRegistro {
    public static void main(String[] args) throws InterruptedException {
        Registro wachi = new Registro(); // Jaja
//        LISTA cajas = new LISTA();
        Caja caja1 = new Caja();
        Caja caja2 = new Caja();
        Caja caja3 = new Caja();
        Caja caja4 = new Caja();
        Caja caja5 = new Caja();
        
        caja1.setID(1);
        caja2.setID(2);
        caja3.setID(3);
        caja4.setID(4);
        caja5.setID(5);
        
        //caja1.setControl(wachi);
        
        wachi.enlaza_caja(caja1);
        wachi.enlaza_caja(caja2);
        wachi.enlaza_caja(caja3);
        wachi.enlaza_caja(caja4);
        wachi.enlaza_caja(caja5);
        
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i+1);
//            Cliente c = wachi.nuevo_cliente();
//            boolean agregado = wachi.cliente_a_caja(c);
//            System.out.println(agregado);
//            System.out.println(caja1);
//            System.out.println(caja2);
//            System.out.println(caja3);
//            System.out.println(caja4);
//            System.out.println(caja5);
//            
//            System.out.println();
//        }

        String str = "{50:0, 2:100}";
        LISTA a = new LISTA();
        LISTA ai = new LISTA();
        
        LISTA b = new LISTA();
        LISTA bi = new LISTA();
        
        LISTA c = new LISTA();
        LISTA ci = new LISTA();
        
        LISTA d = new LISTA();
        LISTA di = new LISTA();
        for (int j = 0; j < 100; j++) {
            a.INSERTA(str,a.FIN());
            ai.INSERTA(5, ai.FIN());
            
            b.INSERTA(str,b.FIN());
            bi.INSERTA(5, bi.FIN());
            
            c.INSERTA(str,c.FIN());
            ci.INSERTA(5, ci.FIN());
            
            d.INSERTA(str,d.FIN());
            di.INSERTA(5, di.FIN());
        }
        
       // System.out.println(a.CUENTA());
       // System.out.println(ai);
        
        //caja1.setDeuda_str(a);
        //caja1.setDeuda_i(ai);
      
        //caja2.setDeuda_str(b);
        //caja2.setDeuda_i(bi);
      
        //caja3.setDeuda_str(c);
        //caja3.setDeuda_i(ci);
        
        //caja4.setDeuda_str(d);
        //caja4.setDeuda_i(di);
      
        Hilo hilo1 = new Hilo(caja1);
        Hilo hilo2 = new Hilo(caja2);
        Hilo hilo3 = new Hilo(caja3);
        Hilo hilo4 = new Hilo(caja4);
        Hilo hilo5 = new Hilo(caja5);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        
        
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
        hilo5.join();
        
        System.out.println("Caja "+caja1.getID()+caja1.billet());
        System.out.println("Caja "+caja2.getID()+caja2.billet());
        System.out.println("Caja "+caja3.getID()+caja3.billet());
        System.out.println("Caja "+caja4.getID()+caja4.billet());
        System.out.println("Caja "+caja5.getID()+caja5.billet());
        System.out.println(
                        caja1.billet().get_saldo()+
                        caja2.billet().get_saldo()+
                        caja3.billet().get_saldo()+
                        caja4.billet().get_saldo()+
                        caja5.billet().get_saldo()
        );
        
        
//      caja1.prestar(str);
//      caja1.prestar(str2);
//      System.out.println(caja1.get_deudas());
//      System.out.println(caja1.get_deudas_id());
//      caja1.pagar();
//      System.out.println(caja1.get_deudas());
//      System.out.println(caja1.get_deudas_id());
        
    }
}


