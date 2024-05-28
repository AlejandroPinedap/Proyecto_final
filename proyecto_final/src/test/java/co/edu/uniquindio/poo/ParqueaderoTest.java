/**
 * Clase para probar el funcionamiento del código
 * @author Alejandro Pineda Patiño
 * Licencia GNU/GPL V3.0 
 */
package co.edu.uniquindio.poo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;

public class ParqueaderoTest {

    private Parqueadero parqueadero;
    private Puesto puesto;
    private Propietario propietario;
    private Carro carro;
    private Registro registro;

    @BeforeEach
    public void setUp() {
        parqueadero = new Parqueadero("mememe");
        puesto = new Puesto(2, 2);
        propietario = new Propietario("Manuel", "10946468", "89645231");
        carro = new Carro("PTA-234", "Twingo", propietario, Tarifa.CARRO);
        registro = new Registro(carro);
    }

    

    /*
     //Test para verificar los registros
     */

    @Test
    public void testObtenerRegistro() {
        parqueadero.agregarRegistro(registro);
        assertNotNull(parqueadero.obtenerRegistro());
    }

     /*
     //Test para verificar el vehiculo mediante el puesto
     */

    @Test
    public void testObtenerVehiculoMediantePuesto() {
        parqueadero.agregarPuestos(puesto);
        parqueadero.agregarRegistro(registro);
        parqueadero.agregarVehiculoPuesto("PTA-234", LocalTime.of(9, 00));
        assertNotNull(parqueadero.obtenerVehiculoMediantePuesto(1, 1));
    }

    /*
     //Test para verificar el Dueño mediante el pueto del vehiculo
     */


    @Test
    public void testObtenerDueñoMediantePuesto() {
        parqueadero.agregarPuestos(puesto);
        parqueadero.agregarRegistro(registro);
        parqueadero.agregarVehiculoPuesto("PTA-234", LocalTime.of(9, 00));
        assertNotNull(parqueadero.obtenerDueñoMediantePuesto(1, 1));
    }

    /*
     //Test para verificar el retiro del vehiculo
     */


    @Test
    public void testDespacharVehiculo() {
        parqueadero.agregarPuestos(puesto);
        parqueadero.agregarRegistro(registro);
        parqueadero.agregarVehiculoPuesto("PTA-234", LocalTime.of(9, 00));
        assertNotNull(parqueadero.despacharVehiculo("PTA-234", LocalTime.of(13, 00)));
    }

    /*
     //Test para verificar el reporte diario 
     */


    @Test
    public void testObtenerReporteDia() {
        parqueadero.agregarPuestos(puesto);
        parqueadero.agregarRegistro(registro);
        parqueadero.agregarVehiculoPuesto("PTA-234", LocalTime.of(9, 00));
        parqueadero.despacharVehiculo("PTA-234", LocalTime.of(13, 00));
        assertNotNull(parqueadero.obtenerReporteDia());
    }

    /*
     //Test para verificar el reporte mensual
     */


    @Test
    public void testObtenerReporteMes() {
        parqueadero.agregarPuestos(puesto);
        parqueadero.agregarRegistro(registro);
        parqueadero.agregarVehiculoPuesto("PTA-234", LocalTime.of(9, 00));
        parqueadero.despacharVehiculo("PTA-234", LocalTime.of(13, 00));
        assertNotNull(parqueadero.obtenerReporteMes());
    }
}







