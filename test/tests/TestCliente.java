/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import banco.Caja;
import banco.Cliente;
import banco.Util;
import banco.dinero.Billetera;

/**
 *
 * @author jaguilar992
 */
public class TestCliente {
    public static void main(String [] args){
        Billetera banco = new Billetera();
        banco.llenar(1000000);
        Cliente Antonio = new Cliente();
        //System.out.println(Antonio.billet());
//        Antonio.billet().guardar(banco.obtener("{1:200}"));
        //System.out.println(Antonio.billet());
        //System.out.println(banco);
        
        //Caja box = new Caja();
        for (int i = 1; i < 100; i++) {
            Cliente c = new Cliente();
            //System.out.print(c.transaccion().tipo()+",");
        }
        
        //System.out.println(i+" "+box.agrega_cliente(new Cliente()));
            //System.out.println(box.cuenta_cola());
        String k = "{500:2,100:3}{500:2,100:2,50:1}";
        //System.out.println(banco.obtener(k));
        
        //System.out.println(Antonio.billet());
//        Antonio.set_cambio();
        //System.out.println(Antonio.transaccion().getNecesidad());
        
        //System.out.println(Antonio.transaccion().getMonto());
        //System.out.println(Antonio.transaccion().getDinero());
        
        int n = Util.randint(40,160);
        
//        for (int i = 0; i < 150; i++) {
//            Cliente c = new Cliente();
//            c.set_retiro();
//            System.out.println(c.transaccion().getMonto());
//            c.transaccion().getNecesidad();
//            System.out.println(i+"--->"+banco.obtener(c.transaccion().getNecesidad()));
//            System.out.println();
//            System.out.println(banco);
//            System.out.println();
//        }
        
        //Antonio.set_deposito();
        //System.out.println(Antonio.transaccion().getDinero());
        //System.out.println(Antonio.transaccion().getMonto());
        
        for (int i = 0; i < 1000; i++) {
            Cliente c = new Cliente();
            c.set_cambio();
            System.out.println();
        }
    }
}
