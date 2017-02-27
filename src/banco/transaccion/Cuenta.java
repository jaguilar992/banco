/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.transaccion;

/**
 *
 * @author Planchas23
 * 
 */
public class Cuenta {
}    //Este codigo tal ves nos ayuda con la simulacion
   // import java.util.Random;

/**
  * Clase para la simulacion del flujo de clientes en un banco
  
  */
//public class Banco {
  //  private static Heap cajeros;
    //private Cliente [] clientes;
    //private Simulacion simulacion;
    //private static Cola cola = new Cola() ;
    //private static double tiempoDeEspera;
    //private static int numClientes;
    //private final int nCajeros;

  /** 
   * Constructor para la simulacion de un banco
   * @param clien -- Clientes que arriban al banco
   * @parm numCajeros -- cantidad de cajeros que hay en el banco
   */
    //public Banco (Cliente[] clien, int numCajeros) {
	//cajeros = new Heap(new comparadorCajero()) ;
	//nCajeros = numCajeros;
	//tiempoDeEspera = 0;
	//numClientes = 0;
	//simulacion = new Simulacion();
        //clientes = clien;

	//for (int i=0; i < nCajeros; i++) 
	    //cajeros.agregar(new Cajero());

	//for (int i = 0; i < clientes.length; i++)
	  //  simulacion.registrarEvento(
            //    new Llegada(clientes[i].obtenerHoraDeLlegada(), clientes[i]));
    //}

  //  public void ejecutarSimulacion() {
//	simulacion.ejecutarSimulacion();
  //  }

    /*
     * Clase para registrar la llegada de un cliente al banco.
     */
    //private class Llegada extends Evento {
	//private Cliente cliente;

    /**
     * Registra la llegada de un cliente.
     * @param double -- hora de llegada de un cliente
     * @param Cliente -- cliente que llega al banco
     */
//	Llegada (double hora, Cliente cl) { 
//	    super(hora);
//	    cliente = cl;
//	}

    /**
     * Procesa la llegada del cliente al banco
     */
//	public void procesarEvento () { //Llegada cliente
//	    if (!cajeros.estaVacia()) {
//		Cajero cajero = (Cajero) cajeros.obtenerPrimero();
//		cajeros.eliminar();

//		double descanso = cajero.obtenerInicioDescanso();
//		if (hora < descanso)
//		    hora = descanso;
//		simulacion.registrarEvento (new AtencionCliente(hora, cliente, cajero));
//	    } else //Espera a que se desocupe el primer cajero
//		simulacion.registrarEvento (new EsperaCajeroDesocupado(hora+0.1, cliente, true));
//	}
  //  }

    /* 
     * Clase encargada de registrar la hora en que un cliente es
     * atendido por un cajero
     */
    //private class AtencionCliente extends Evento {
	//private Cliente cliente;
	//private Cajero cajero;

	/**
	 * Registra la hora de atención al cliente
	 * @param double -- hora de atención al cliente
	 * @param Cliente -- cliente que se atiende en este momento
	 * @param Cajero -- cajero que atiende al cliente
	 */
	//AtencionCliente (double hora, Cliente cl, Cajero caj) { 
	  //  super(hora);
	    //cliente = cl;
	    //cajero = caj;
	//}

	/**
	 * Método que actualiza los datos para las estadísticas y vuelve a
	 * poner disponible al cajero que atendió al cliente
	 */
	//public void procesarEvento () { //atencion a clientes
	  //  System.out.println("El cajero "+ cajero+ " atendió al cliente "+cliente+ " a las "+hora);
	    //double espera = hora - cliente.obtenerHoraDeLlegada();

	   // tiempoDeEspera += espera;  //Acumula tiempo de espera de los clientes
	    //numClientes++; // Otro cliente atendido
                       // Actualiza datos para la estadística
	    //cajero.acumularTiempoOcupado(cliente.obtenerDuracionDeOperaciones());
	    //cajero.acumularClientesAtendidos();
	    //cajero.acumularTiempoDesocupado(hora-cajero.obtenerInicioDescanso());
	               //Actualiza hora de descanso
	    //cajero.asignarIniciaDescanso(hora+cliente.obtenerDuracionDeOperaciones());
	    //cajeros.agregar(cajero);
	//}
    //}

    /*
     * Clase encargada de poner en cola de espera a un cliente hasta que
     *  un cajero se desocupe. 
     */
    //private class EsperaCajeroDesocupado extends Evento {
	/**
	 * Pone un cliente en la cola en espera de que se desocupe un cajero
	 * @param double -- hora en que entra a la cola de espera un cliente
	 * @param Cliente -- cliente que espera a que lo atiendan
	 * @param boolean -- para indicar si el cajero es uno nuevo en la cola
	 */
	//EsperaCajeroDesocupado (double hora, Cliente cliente, boolean nuevo) {
	  //  super (hora);
	    //if (nuevo)
		//cola.agregar(cliente);
	//}

	/**
	 * Método que pone en la cola de espera a un cliente hasta que un cajero 
	 * se desocupe. 
	 */
	//public void procesarEvento () { //Espera cajero desocupado
	  //  Cliente cliente = (Cliente) cola.tomar();

	    //if (cajeros.estaVacia()) {
		//simulacion.registrarEvento (new EsperaCajeroDesocupado(hora+0.1, cliente, false));
	//	return;
	  //  }
	    //Cajero cajero = (Cajero) cajeros.obtenerPrimero();
	    //cajeros.eliminar();
	    //cola.eliminar();

	    //double descanso = cajero.obtenerInicioDescanso();
	    //if (hora <= descanso) //El cajero está desocupado
		//hora = descanso;
	    //simulacion.registrarEvento (new AtencionCliente(hora, cliente, cajero));
	//}
    //}

     /* 
      * Clase para determinar, cuando hay dos cajeros, cuál se
      * desocupa primero. 
      */
    //private class comparadorCajero implements java.util.Comparator {

	//public int compare (Object uno, Object dos) {
	  //  Cajero c1 = (Cajero) uno;
	    //Cajero c2 = (Cajero) dos;
	    //if (c1.obtenerInicioDescanso() < c2.obtenerInicioDescanso())
		//return -1;
	    //else if (c1.obtenerInicioDescanso() > c2.obtenerInicioDescanso())
		//return 1;
	    //else return 0;
	//}

	//public boolean equals (Object obj) {
	//	return compare(this, obj) == 0;
	//}
    //}

    //public static void main(String [] pps) {
	//Cliente[] cl = new Cliente [] {
        //new Cliente(1.5, 5.7),
        //new Cliente(2.8, 1.9),
        //new Cliente(3.3, 8.7),
        //new Cliente(9.2, 2.7),
        //new Cliente(9.5, 1.7),
        //new Cliente(9.6, 2.12),
        //new Cliente(9.6, 1.15),
        //new Cliente(9.8, 3.20),
        //new Cliente(11.2, 3.30),
        //new Cliente(11.3, 1.17),
        //new Cliente(11.3, 2.9),
       // new Cliente(12.0, 1.4),
        //new Cliente(12.1, 3.6),
        //new Cliente(12.6, 1.10),
        //new Cliente(13.0, 1.13),
        //new Cliente(14.2, 2.6),
        //new Cliente(14.2, 0.9),
        //new Cliente(15.9, 2.3)
             // Aquí se crean clientes para la simulación.
	//}; 

	//Banco b = new Banco(cl,2);
	//b.ejecutarSimulacion();

	//System.out.println("\n\nEl tiempo de espera en promedio por cliente es de "
	//		   + tiempoDeEspera/numClientes+"");

	//while(!cajeros.estaVacia()) {
	  //  Cajero cajero = (Cajero) cajeros.obtenerPrimero();
	    //cajeros.eliminar();
	    //System.out.println("El cajero "+cajero+
		//   " estuvo ocupado "+ cajero.obtenerTiempoOcupado() +
  	          // " tuvo " +cajero.obtenerTiempoDesocupado() + " tiempo libre" +
 	          // " y atendio a " +cajero.obtenerClientesAtendidos() + " clientes.");
	//}

    //}


//}

//}
