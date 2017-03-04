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
public class HiloCaja extends Thread{
    private final Caja caja;
    public HiloCaja(Caja caja){
        this.caja = caja;
    }

    @Override
    public void run() {
        while (caja.getControl().is_abierto() || caja.cuenta_cola()>0 || caja.get_deudas().CUENTA()>0) {            
            caja.pagar(); // Si es que debe
            float duracion = Util.rand_float(Caja.DELAY_MIN, Caja.DELAY_MAX);
            if (caja.cuenta_cola()!=0) {
                boolean atencion = caja.atiende_cliente();
                Reloj.sleep(duracion); //Reloj
            }
        }
    }
    
            
}
