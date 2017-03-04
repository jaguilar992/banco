/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Scanner;

/**
 *
 * @author jaguilar992
 */
public class Switch extends Thread{
    private final Banco reg;
    public Switch(Banco reg){
        this.reg = reg;
    }

    @Override
    public void run() {
        Scanner c = new Scanner(System.in);
        String s="O";
        while (!s.equals("FIN") && reg.is_abierto()) {            
            s=c.nextLine();
        }
        this.reg.cerrar();
    }
    
    
}
