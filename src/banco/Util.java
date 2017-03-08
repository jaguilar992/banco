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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tda.LISTA;

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
    
    public static float rand_float(float l, float h ){
        return r.nextFloat()*(h-l) + l;
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
    
    public static synchronized Caja buscaCaja(LISTA cajas, int id){
        for (int i = cajas.PRIMERO(); i < cajas.FIN(); i++) {
            int idi = ((Caja)cajas.RECUPERA(i)).getID();
            if (id==idi) {
                return (Caja)cajas.RECUPERA(i);
            }
        }
        return null;
    }
    
    public static String clean(String nec){
        // FORMATEO Y limpieza de cadena str
        // Evitar {50:320,20:1,}{500:3,100:4,50:1,20:1,10:1,1:1,}
        // En su lugar {500:3, 100:4, 50:321, 20:1, 10:1, 1:1}
        int [] denom = {1,2,5,10,20,50,100,500};
        int [] values = new int[denom.length];
        
        nec=nec.replaceAll("\\s", "");
        String obtenido="{";
        String regexp = "[0-9]+\\s*\\:\\s*[0-9]+";
        Pattern p  = Pattern.compile(regexp);
        Matcher m = p.matcher(nec);
        while(m.find()){
            String pair = m.group();
            int den = Integer.parseInt(pair.split(":")[0]);
            int cant = Integer.parseInt(pair.split(":")[1]);
            int i = Util.search(denom, den);
            if (i!=-1) {
                values[i]+=(cant);
            }
        }
        
        for (int i = denom.length-1; i >=0; i--) {
            if (values[i]>0) {
                obtenido+=(denom[i]+":"+values[i]+",");
            }
        }
        
        return obtenido+"}";
    }
    
    public static int search(int[]array , int n){
        for (int i = 0; i < array.length; i++) {
            if (array[i]==n) {
                return i;
            }
        }
        return -1;
    }

}
