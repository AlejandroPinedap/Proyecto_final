package co.edu.uniquindio.poo;

import java.time.LocalTime;
import java.util.Scanner;

public class ParqueaderoMenu {
    /*
     // Menu interactivo para el Paqueadero
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        /* 
        // Crear el objeto Parqueadero
         */
        Parqueadero parqueadero = new Parqueadero("Mi Parqueadero");
        Puesto puestos = new Puesto(5, 5); // Suponiendo una matriz de 5x5 puestos
        parqueadero.agregarPuestos(puestos);

        while (running) {
            System.out.println("\nMenú del Parqueadero:");
            System.out.println("1. Registrar entrada de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Mostrar estado del parqueadero");
            System.out.println("4. Obtener reporte del día");
            System.out.println("5. Obtener reporte del mes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarEntrada(parqueadero, scanner);
                    break;
                case 2:
                    registrarSalida(parqueadero, scanner);
                    break;
                case 3:
                    mostrarEstado(parqueadero);
                    break;
                case 4:
                    System.out.println(parqueadero.obtenerReporteDia());
                    break;
                case 5:
                    System.out.println(parqueadero.obtenerReporteMes());
                    break;
                case 6:
                    running = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }

        scanner.close();
    }

    /*
     //registramos las entradas o los vehiculos que ingresan al parqueadero
     */

    private static void registrarEntrada(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese el número de placa del vehículo: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el nombre del propietario: ");
        String nombrePropietario = scanner.nextLine();
        System.out.print("Ingrese la cédula del propietario: ");
        String cedulaPropietario = scanner.nextLine();
        System.out.print("Ingrese el teléfono del propietario: ");
        String telefonoPropietario = scanner.nextLine();
        System.out.print("Ingrese el tipo de vehículo (1. Carro, 2. Moto Clasica, 3. Moto Hibrida): ");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la velocidad máxima (solo para motos): ");
        int velocidadMaxima = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la hora de entrada en formato 24 horas (HH:mm): ");
        String horaEntradaStr = scanner.nextLine();
        LocalTime horaEntrada = LocalTime.parse(horaEntradaStr);

        Propietario propietario = new Propietario(nombrePropietario, cedulaPropietario, telefonoPropietario);
        Vehiculo vehiculo;
        Tarifa tarifa;

        switch (tipoVehiculo) {
            case 1:
                tarifa = Tarifa.CARRO;
                vehiculo = new Carro(placa, modelo, propietario, tarifa);
                break;
            case 2:
                tarifa = Tarifa.MOTO_CLASICA;
                vehiculo = new MotoClasica(placa, modelo, propietario, tarifa, velocidadMaxima);
                break;
            case 3:
                tarifa = Tarifa.MOTO_HIBRIDA;
                vehiculo = new MotoHibrida(placa, modelo, propietario, tarifa, velocidadMaxima);
                break;
            default:
                System.out.println("Tipo de vehículo no válido.");
                return;
        }

        Registro registro = new Registro(vehiculo);
        registro.setHoraEntrada(horaEntrada);
        parqueadero.agregarRegistro(registro);
        parqueadero.agregarVehiculoPuesto(placa, horaEntrada);
        System.out.println("Vehículo registrado correctamente.");
    }

    private static void registrarSalida(Parqueadero parqueadero, Scanner scanner) {
        parqueadero.registrarSalida(scanner);
    }
    
    private static void mostrarEstado(Parqueadero parqueadero) {
        parqueadero.mostrarEstado();
    }
  
}