/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import banco.dinero.Billete;
import banco.dinero.Billetera;
import banco.transaccion.Transaccion;
import tda.PILA;

/**
 *
 * @author jaguilar992
 */
public class Cliente {
    private final int init;
    private int monto=0;
    private Billetera wallet = new Billetera();
    private Transaccion trans;
    
    public Cliente(){
        this.init = Util.randint(500, 50000);
        wallet.llenar(init,Util.randbool());
        trans = new Transaccion(Util.randchar(Transaccion.TRANS));

        switch (trans.tipo()) {
                case 'D':{
                   // this.set_deposito();
                }
                break; case 'R':{
                  //  this.set_retiro();
                }
                break; case 'C':{
                   // this.set_cambio();
                }
                break; default:
                break;
        }
    }
    
    
    public int dinero(){
        return wallet.get_saldo();
    }
    
    public Billetera billet(){
        return this.wallet;
    }
    
    public Transaccion transaccion(){
        return this.trans;
    }
    
    public void set_retiro(){// Ajusta el retiro en transaccion trans de cliente
        String necesidad="{"; // Cadena que se le pasa a Retiro, con el numero de billetes por cada denominacion.
        // De la forma: {den_1:cant_1,den_2:cant_2, ... , den_n:cant_n}
        int limit_retiro = 20000; // El Cliente podrá retirar hasta 10000 unidades de dinero
        this.monto=Util.randint(500, limit_retiro); // Se escoge aleatoriamente un monto
        int cambio_1=(int) (Util.randint(70,100)*this.monto/100); // Al menos del 70% de este dinero
        int [] denom = {500,100,50,20}; // el Cliente podra elegir si se le dan billetes de 100 o 500
        int[] billete_group = Util.rand_shuffle(denom); // Mezcla el arreglo denom para elegir primer billete a desglosar 500 o 100
        for (int i : billete_group) { // Para cada denominccion desglosa
            if (cambio_1>=i) {
                //Desglose entre 100 y 500
                int cantb = (cambio_1 / i); // Entregara cantb de i (100 o 500)
                necesidad += (i + ":" + cantb + ","); // Agrega la informacion a necesidad
                cambio_1 = cambio_1 % i;
            }
        }
        // El resto se completara con la minima cantidad de billetes que sumen dicho resto.
        int cambio_2 = this.monto-Billete.contar(necesidad);
        necesidad+=("}"+wallet.desglose_str(cambio_2));
        trans.setNecesidad(necesidad);// agrega el necesidad a Transaccion trans del Cliente
    }

    public void set_deposito(){// Ajusta el deposito en transaccion trans de cliente
        PILA deposito = new PILA(); // Pila a depositar
        int [] denom = {1,2,5,10,20,50,100,500}; 
        for (int i=denom.length-1; i>=0; i--) { // Revisar las pilas por denominaciones
            PILA actual = wallet.pilas(denom[i]);
            if (!actual.VACIA()) { // Si la pila actual no está vacía
                int total_actual = actual.CUENTA(); // del total de billetes
                
                int pick = Util.randint(1,total_actual); // Elige al menos 1
                for (int j=0; j<pick; j++) {
                    deposito.METE(actual.TOPE()); // Sacar de la pila de dinero
                    actual.SACA(); // Para meterlo en deposito
                }
            }
        }
        trans.setDinero(deposito); // agrega el dinero a Transaccion trans del Cliente
    }

    public void set_cambio(){ //Depurar y MUCHO XD
        PILA dinero = new PILA();
        int [] denom = {20,50,100,500}; //El menor billete que devolvera caja sera 20
        int pick = Util.randint(1,denom.length-1);
        int denom_pick = denom[pick];
        while (wallet.pilas(denom_pick).CUENTA()<=1) {
            pick = Util.randint(1,denom.length-1);
            denom_pick = denom[pick];
        }
        
        int total = wallet.pilas(denom_pick).CUENTA();
        int n_pick;
        if (total>=40) { // En el peor de los casos, el total será 40 Billetes de 500
            // Dando un total para el limite de cambio de 20000 (igual que retiro)
            n_pick = Util.randint(1,40);
        }else{
            n_pick = Util.randint(1,total);
        }
        for (int i = 0; i < n_pick; i++) {
            dinero.METE(wallet.pilas(denom_pick).TOPE());
            wallet.pilas(denom_pick).SACA();
        }
        
        int change_denom=denom[Util.randint(pick-1)];
        
        System.out.println("{"+denom_pick+":"+n_pick+"} en billetes de "+change_denom);
        String necesidad = "{"+change_denom+":"+denom_pick*n_pick/change_denom+"}";
        System.out.println(necesidad);
        System.out.println(dinero);
        System.out.println(Billete.contar(dinero));


    }
}