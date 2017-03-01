/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import banco.Cliente;
import banco.Util;
import banco.dinero.Billetera;

/**
 *
 * @author jaguilar992
 */
public class MediaRetiro {
    public static void main(String[] args) {
        Billetera banco = new Billetera();
        banco.llenar(2000000);
        int sum=0;
        int N=1000;
        int N2=0;
        
        int sum2=0;
        for (int i = 1; i <= N; i++) {
            //System.out.println();  
            //System.out.println("Prueba "+i);
            int n = Util.randint(50,100);
            //System.out.println(n+" clientes");
            sum2+=n;
            for (int j = 1; j <= n; j++) {
                Cliente c = new Cliente();
                //c.set_retiro();
                //System.out.println(j+" "+c.transaccion().getNecesidad()+": "+Billete.contar(c.transaccion().getNecesidad()));
                if (banco.obtener(c.transaccion().getMonto())==null) {
              //      System.out.println("Falla at "+j);
                    sum+=j;
                    N2++;
                    break;
                }
            }
            //System.out.println("#######################################################");
            banco = new Billetera();
            banco.llenar(1000000);
        }
        System.out.println("Clientes: "+sum2*1.0/N);
        System.out.println("Falla a: "+sum*1.0/N2+" "+(N2*100.00/N)+"%");
    }
}
