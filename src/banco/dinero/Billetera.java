/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dinero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tda.PILA;

public class Billetera {
    // Diccionario de PILAS 
    // clave: denominacion, elemento de {1,2,5,10,20,50,100,500}
    // Valor: PILA de objetos de tipo Billete
    private final int [] denom = {1,2,5,10,20,50,100,500};
    private final PILA pilas [];
       
    public Billetera(){
        this.pilas = new PILA[8];
        
        //Inicializar Pilas de Billetes (Deben contener Objetos Billete)
        for (int i = 0; i < 8; i++) {
            pilas[i]=new PILA();
        }
    }
    
    public int dinero() { // Cuenta los billetes =) Para dar la suma total
        int saldo=0;
        for (int i : denom) {
            saldo+=(this.get_pila_billetes_i(i).CUENTA()*i);
        }
        return saldo;
    }
    
    public void llenar(int saldo){
            // Cantidad por Denominaciones fijas, faltante por desglose.
        if (saldo>=688) {
            int provis=0;
            int nbil = saldo/688;
            for (int i = 0; i < nbil; i++) {
                for (int j : denom) {
                    Billete c = new Billete(j);
                    this.get_pila_billetes_i(j).METE(c);
                    provis += j;
                }
            }
            if (provis!=saldo) {
                int faltante=saldo-provis;
                this.guardar(this.desglose(faltante));
            }
        }else{
            this.guardar(this.desglose(saldo));
        }
    }
        
    public PILA desglose(int monto){ // CREA Billetes De forma desglosada
        // Retorna una PILA de Billetes
        //  con el numero de Billetes Optimo que suman monto
        // Ejemplo: Saldo: 789
        // 500 , 100, 100, 50, 20, 10, 5, 2, 2
        PILA pila = new PILA();
        for (int i = this.denom.length - 1; i >= 0; i--) {
            if (monto >= denom[i]) {
                int cantb = (monto / denom[i]);
                for (int j = 0; j < cantb; j++) {
                    pila.METE(new Billete(denom[i]));
                }
                monto = monto % denom[i];
            }
        }
        return pila; // Regresa una PILA con los Billetes
    }
    
    public String desglose_str(int monto){ // CREA Billetes De forma desglosada
        // Retorna una cadena de Billetes {den_1:cant_1,den_2:cant_2, ... , den_n:cant_n}
        //  con el numero de Billetes Optimo que suman monto
        // Ejemplo: Saldo: 789
        // {500:1,100:2,20:1,10:1,5:1,2:2}
        String rest="{";
        for (int i = this.denom.length - 1; i >= 0; i--) {
            if (monto >= denom[i]) {
                int cantb = (monto / denom[i]);
                rest+=(denom[i]+":"+cantb+",");
                monto = monto % denom[i];
            }
        }
        return rest+"}"; // Regresa una PILA con los Billetes
    }
    
    public synchronized PILA obtener(int monto){
        // Obtiene monto de la billetera por desglose (PILA de Billetes)
        // null si no es posible
        PILA obtenida = this.obtener(this.desglose_str(monto));
        return obtenida;
    }
    
    public synchronized PILA obtener(String str){ 
        // Recibe una cadena de la forma 
        //{den_1:cant_1,den_2:cant_2, ... , den_n:cant_n}
        // Devuelve una PILA de Billetes, segun se pide
        // Devuelve null si no es posible hacerlo (Falta)
        PILA obtenido = new PILA();
        str=str.replaceAll("\\s", "");
        String regexp = "[0-9]+\\s*\\:\\s*[0-9]+";
        Pattern p  = Pattern.compile(regexp);
        Matcher m = p.matcher(str);
        while(m.find()){
            String pair = m.group();
            int den = Integer.parseInt(pair.split(":")[0]);
            int cant = Integer.parseInt(pair.split(":")[1]);
            try{ 
                PILA c = this.get_pila_billetes_i(den);
                for (int i = 0; i < cant; i++) {
                    if (!c.VACIA()) {
                        obtenido.METE((Billete) c.TOPE());
                        c.SACA();
                    }else{
                        //System.out.println(str);
                        //System.out.println("No hay "+cant+" billetes de: "+den);
                        this.guardar(obtenido);
                        return null; // Devuelve null si al menos una de las get_pila_billetes_i a usar está vacía
                    }
                }
            }catch(NullPointerException e){ 
            // Ignorar Pilas nulas, valores no permitidos en this.denom
                System.out.println("No existe denominacion: "+den);
            }
        }
        return obtenido;
    }
    
    public synchronized void guardar(PILA nuevos){
        // Recibe una PILA de Billetes(Variada) y los guarda en las get_pila_billetes_i correspondientes
        try{
            while (!nuevos.VACIA()) {
                Billete billete_tope = (Billete) nuevos.TOPE(); // Obtiene Billete en el tope
                int valor = billete_tope.get_valor();
                PILA recip = this.get_pila_billetes_i(valor);
                if (recip != null) {
                    nuevos.SACA(); // Saca el billete de la PILA y luego
                    recip.METE(billete_tope);// Guarda el billete en la que corresponde.
                } else {
                    System.out.println("Se detectó Billete Falso: " + billete_tope);
                    nuevos.SACA(); // Sacar billete falso xD
                }
            }
        }catch(NullPointerException e){
            System.out.println("PILA a guardar en billetera está VACIA");
        }
    }
    
    public synchronized PILA get_pila_billetes_i(int i){ // Acceso a la PILA de Billetes con denominacion i
        // Busqueda Binaria (Entrada: Denominacion, Salida: PILA)
        int c,bajo=0,alto=this.denom.length-1, cval;
        while (bajo<=alto) {            
            c=(bajo+alto)/2; cval=denom[c];
            if (i==cval) return pilas[c]; // Regresa PILA con denominacion i
            else if (i<cval) alto=c-1;
            else bajo=c+1; 
        } // Fin Busqueda Binaria
        System.out.println("No existe PILA con valores: "+i);
        return null; //Regresa null si no existe PILA con denominacion i
    }

    @Override
    public String toString() { // Impresion de Billetera
        String m = "Billetera: "+this.dinero()+"{";
        for (int key : denom) {
            m+=("  "+key+":"+this.get_pila_billetes_i(key).CUENTA()+",");
        }
        return m+"}";
    }
}
