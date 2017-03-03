/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import banco.Util;

/**
 *
 * @author usuario
 */
public class PruebaSearch {
    public static void main(String[] args) {
        int [] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            numeros[i]=Util.randint(0, 100);
        }
//        for (int numero : numeros) {
//            System.out.print(numero+",");
//        }
//        System.out.println();
                
      //  Util.quick_sort(numeros, 0, numeros.length-1);
        //System.out.println(Util.in_array(10, numeros));
        for (int numero : numeros) {
            System.out.print(numero+",");
        }
        
        int n = numeros[0];
        
        
    }
}
