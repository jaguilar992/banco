/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jaguilar992
 */
public class Util {
    private static Random r = new Random();
    
    public static int randint(int l,int h){
        return r.nextInt(h-l+1) + l;
    }
    
    public static int randint(int h){
        return Util.randint(0, h);
    }
    
    
    public static boolean randbool(){
        return Util.randint(0, 1)==1;
    }
    
    public static char randchar(char[] array){
        return array[Util.randint(array.length-1)];
    }
    
    public static float randrate(){
        return r.nextFloat();
    }
    
    public static int[] rand_shuffle(int[] array) {
        List<Integer> list = new ArrayList<>();
        int[] new_array=new int[array.length];
        for (int i : array) {
            list.add(i);
        }

        Collections.shuffle(list);

        for (int i = 0; i < array.length; i++) {
            new_array[i] = list.get(i);
        }    
        return new_array;
    }
}
