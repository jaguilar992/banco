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
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------   Simulación    ---------");
        System.out.println("--------- Agencia Bancaria ---------");
        Registro banco = new Registro();
        int mins = 1;
        Reloj reloj = new Reloj(mins*60*1000/480);
        banco.abrir();
        Scanner n = new Scanner(System.in);
        System.out.print("¿Desea imprimir informe de cajas en tiempo real? (S/N): ");
        String resp = n.nextLine();
        banco.log(resp.equals("S"));
        System.out.println("Para terminar, ingrese FIN:");
        Caja caja1 = new Caja();
        Caja caja2 = new Caja();
        Caja caja3 = new Caja();
        Caja caja4 = new Caja();
        Caja caja5 = new Caja();
        
        caja1.setID(1);
        caja2.setID(2);
        caja3.setID(3);
        caja4.setID(4);
        caja5.setID(5);
                
        banco.enlaza_caja(caja1);
        banco.enlaza_caja(caja2);
        banco.enlaza_caja(caja3);
        banco.enlaza_caja(caja4);
        banco.enlaza_caja(caja5);
              
        Switch hilo6 = new Switch(banco);
        HiloCaja hilo1 = new HiloCaja(caja1);
        HiloCaja hilo2 = new HiloCaja(caja2);
        HiloCaja hilo3 = new HiloCaja(caja3);
        HiloCaja hilo4 = new HiloCaja(caja4);
        HiloCaja hilo5 = new HiloCaja(caja5);
        
        hilo6.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        
        // LOOP TEMPORAL, Creacion de nuevos clientes.
        int j =0;
        while(j<480 && banco.is_abierto()){
            Cliente cli = banco.nuevo_cliente();
            boolean colocado = banco.cliente_a_caja(cli);
            if (!colocado) {
                banco.no_atendido();
            }
            float cli_en = Util.rand_float(Registro.DELAY_MIN, Registro.DELAY_MIN); // Aparicion del siguiente cliente
            j++;
            Reloj.sleep(cli_en);
        }
        banco.cerrar(); // Cerrar el banco xD
        System.out.println("¡El banco ha cerrado! ... Cerrando cajas...");
        
        hilo1.join();// Esperar que los hilos hijo terminen
        hilo2.join();
        hilo3.join();
        hilo4.join();
        hilo5.join();
        
        //Impresión Reportes
        System.out.println("\n---------- REPORTES ----------");
        System.out.println("Caja"+caja1.getID()+" "+caja1.billet());
        System.out.println("Caja"+caja2.getID()+" "+caja2.billet());
        System.out.println("Caja"+caja3.getID()+" "+caja3.billet());
        System.out.println("Caja"+caja4.getID()+" "+caja4.billet());
        System.out.println("Caja"+caja5.getID()+" "+caja5.billet());
        System.out.println(
                        "\nTotal en cajas: "+(
                        caja1.billet().get_saldo()+
                        caja2.billet().get_saldo()+
                        caja3.billet().get_saldo()+
                        caja4.billet().get_saldo()+
                        caja5.billet().get_saldo())
        );
        System.out.println("\n"+caja1);
        System.out.println(caja2);
        System.out.println(caja3);
        System.out.println(caja4);
        System.out.println(caja5);
        
        System.out.println("\n"+banco);        
    }
}


