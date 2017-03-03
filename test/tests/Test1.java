// TEST
// ------------------------- > TEST 1
// Descripcion: Pruebas con Billetera

package tests;

import banco.dinero.Billete;
import banco.dinero.Billetera;
import tda.PILA;

public class Test1 {
    public static void main(String args[]){
        Billetera wallet = new Billetera();
//        PILA p= wallet.pilas(500);
//        
//        
//        Billete [] no = new Billete[10];
//        
//        for (int i = 0; i < 9; i++) {
//            no[i]= new Billete(10);
//            no[9]= null;
//        }
//        
//        

//        
//        
//        
//        
//        wallet.llenar(1000000,false);
//        wallet.guardar(no);
        //System.out.println(wallet.desglose(300));
//        
//        System.out.println(wallet);
//        PILA are=wallet.desglose(13780);
//        System.out.println(are);
         // System.out.println(wallet.desglose(789));
          //wallet.llenar(5000);
          //System.out.println(wallet);
          //wallet.guardar(nuevos);
          //System.out.println(wallet);
          //System.out.println(wallet.get_saldo());
          
       //PILA nuevos = new PILA();   
       //nuevos.METE(new Billete(3));
       //wallet.guardar(nuevos);
        
        wallet.llenar(1000000);
       //System.out.println(wallet);
        //System.out.println(wallet.obtener("{500:1}"));
        //wallet.obtener(1000);
        System.out.println(wallet);
          
    }
}
