/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
// REGEXP y RANDOM

import banco.Cliente;
import banco.Util;
import banco.dinero.Billetera;

/**
 *
 * @author jaguilar992
 */
public class Test2 {
    public static void main(String args[]){
//        Billetera wallet = new Billetera();
//        wallet.llenar(6880688);
//        System.out.println(wallet);
//        wallet.obtener("{500:5, 10 0:2,20:1}");
//        System.out.println(wallet);
//        String a = "{500: 5100:    2,20:  1}";
//        a=a.replaceAll("\\s", "");
//        //System.out.println(a);
//        
//        
//        char[] list = {'a','b','c','d','e','f'};
        //System.out.println(Util.randchar(list));
        Cliente n = new Cliente();
        System.out.println(n.transaccion().tipo());
        System.out.println(n.transaccion().getMonto());
        System.out.println(n.transaccion().getNecesidad());
        System.out.println(n.billet());
    }
    
}
