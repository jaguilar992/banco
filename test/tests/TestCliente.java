/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import banco.Cliente;
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
        System.out.println(Antonio.billet());
        Antonio.billet().guardar(banco.obtener("{1:200}"));
        System.out.println(Antonio.billet());
        System.out.println(banco);
        
    }
}
