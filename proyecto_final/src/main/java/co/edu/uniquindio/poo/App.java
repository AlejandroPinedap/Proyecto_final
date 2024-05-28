package co.edu.uniquindio.poo;

import java.time.LocalTime;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero("mememe");
        System.out.println(parqueadero.getNombre());
        Puesto puestos = new Puesto(2, 2);
        parqueadero.agregarPuestos(puestos);
        Propietario propietario = new Propietario("Manuel", "10946468", "89645231");
        Carro carro__1 = new Carro("PTA-234", "Twingo", propietario, Tarifa.CARRO);
        Registro registro = new Registro(carro__1, null);
        
        parqueadero.agregarRegistro(registro);

        parqueadero.agregarVehiculoPuesto("PTA-234", LocalTime.of(9, 00));

        System.out.println(parqueadero.obtenerRegistro());
        System.out.println(parqueadero.obtenerRegistroVehiculos());
        System.out.println(parqueadero.obtenerVehiculoMediantePuesto(1, 1));
        System.out.println(parqueadero.obtenerDueñoMediantePuesto(1, 1));
        System.out.println(parqueadero.despacharVehiculo("PTA-234", LocalTime.of(13, 00)));
        System.out.println(parqueadero.obtenerReporteDia());
        System.out.println( parqueadero.obtenerReporteMes());
        

    }
}
