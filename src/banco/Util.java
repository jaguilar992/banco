/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Random;

/**
 *
 * @author jaguilar992
 */
public class Util {
    public static Random r = new Random();
    
    public static int randint(int l,int h){
        return r.nextInt(h-l+1) + l;
    }
    
    public static boolean randbool(){
        return Util.randint(0, 1)==1;
    }
    
}
