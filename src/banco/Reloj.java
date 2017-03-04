/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author jaguilar992
 */
public class Reloj {
    private static int scala;
    public Reloj(int scala){
        Reloj.scala = scala; // Numero de milisegundos que representan 1 min de simulacion
    }
    
    public static void sleep(float ms) {
        try {
            Thread.sleep((long) ms*Reloj.scala);
            //System.err.println((long) ms*Reloj.scala);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
