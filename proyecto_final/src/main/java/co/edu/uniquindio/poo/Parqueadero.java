package co.edu.uniquindio.poo;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Parqueadero {
    private String nombre;
    private double ganaciasCarros;
    private double gananciasMotosHibridas;
    private double gananciasMotosClasicas;
  
    private Registro[] registros;
    private Puesto puestos;

    public Parqueadero(String nombre) {
        this.nombre = nombre;
        this.registros = new Registro[10];

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Puesto getPuestos() {
        return puestos;
    }

    public void setPuestos(Puesto puestos) {
        this.puestos = puestos;
    }

   
    

    public double getGanaciasCarros() {
        return ganaciasCarros;
    }

    public void setGanaciasCarros(double tarifa) {
        this.ganaciasCarros = tarifa;
    }

    public double getGananciasMotosHibridas() {
        return gananciasMotosHibridas;
    }

    public void setGananciasMotosHibridas(double tarifa) {
        this.gananciasMotosHibridas = tarifa;
    }

    public double getGananciasotosClasicas() {
        return gananciasMotosClasicas;
    }

    public void setGananciasotosClasicas(double tarifa) {
        this.gananciasMotosClasicas = tarifa;
    }
    

    public Registro[] getRegistros() {
        return registros;
    }

    public void setRegistros(Registro[] registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        return "Parqueadero [nombre=" + nombre + ", reporteDia="  + ", reporteMes=" 
                + ", registros=" + Arrays.toString(registros) + ", puestos=" + puestos + "]";
    }
    /* 
    // Metodo para agregar la matriz de puestos al parqueadero
    */
    public void agregarPuestos(Puesto puestos) {
        setPuestos(puestos);
    }
    /* 
    // Metodo para agrega un registro al parqueadero
    */
    public void agregarRegistro(Registro registro) {
        /* 
        // Verificar si el registro ya existe
        */
        for (Registro r : registros) {
            if (r != null && r.equals(registro)) {
                System.out.println("El registro ya existe");
                return;
            }
        }

        /* 
        // Agregar el registro si no existe
        */
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] == null) {
                registros[i] = registro;
                break;
            }
        }
    }

     /* 
    // Metodo para agregar un vehiculo a un puesto del parqueadero
    */
    public void agregarVehiculoPuesto(String placa, LocalTime horaEntrada) {
        for (Registro registro : registros) {
            if (registro != null && registro.getVehiculo().getPlaca().equals(placa)) {
                Vehiculo vehiculo = registro.getVehiculo();
                registro.setHoraEntrada(horaEntrada);
                boolean vehiculoAgregado = false;
                for (int i = 0; i < puestos.getListPuestos().length; i++) {
                    for (int j = 0; j < puestos.getListPuestos()[i].length; j++) {
                        if (puestos.getListPuestos()[i][j] == null) {
                            puestos.agregarVehiculo(vehiculo, i, j);
                            System.out.println("Se pasa a la clase puestos para agregar el vehiculo");
                            vehiculoAgregado = true;
                            break;
                        }
                    }
                    if (vehiculoAgregado) {
                        break; 
                    }
                }
                if (vehiculoAgregado) {
                    break; 
                }
            }
        }
    }

    /* 
    // Metodo para obtener el registro de los vehiculos inscritos en el parqueadero
    */
    public String obtenerRegistro() {
        String registroActualizado = "Registro de clientes: \n";
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null) {
                registroActualizado = registroActualizado + "Propietario: "
                        + registros[i].getVehiculo().getPropietario().getNombre() + " Cedula: "
                        + registros[i].getVehiculo().getPropietario().getCedula() + " Telefono: "
                        + registros[i].getVehiculo().getPropietario().getNumeroTelefonico() + " Vehiculo: "
                        + registros[i].getVehiculo().getModelo() + " Placa:"+registros[i].getVehiculo().getPlaca()+"\n";
            }else{
                registroActualizado = registroActualizado +"No hay clientes";
                break;
            }
        }
        return registroActualizado;
    }

    /* 
    // Metodo para obtener el registro de los vehiculos que estan en el parqueadero
    */
    public String obtenerRegistroVehiculos() {
        String registroVehiculo = "Registro vehiculos en el parqueadero:\n";

        for (int i = 0; i < puestos.getListPuestos().length; i++) {
            for (int j = 0; j < puestos.getListPuestos()[i].length; j++) {
                if (puestos.getListPuestos()[i][j] != null) {
                    registroVehiculo = registroVehiculo + "El vehiculo " + puestos.getListPuestos()[i][j].getModelo()
                            + " en el puesto " + (i + 1) + "," + (j + 1) + " es de "
                            + puestos.getListPuestos()[i][j].getPropietario().getNombre() +" Placa: "+puestos.getListPuestos()[i][j].getPlaca()+ "\n";
                } else {
                    registroVehiculo = registroVehiculo + "El puesto " + (i + 1) + "," + (j + 1) + " esta libre" + "\n";
                }
            }
        }
        return registroVehiculo;

    }

    /* 
    // Metodo para obtener el vehiculo mediante el puesto en el parqueadero
    */

    public String obtenerVehiculoMediantePuesto(int fila_2, int columna_2) {
        String vehiculoEncontrado = "";
        int fila = fila_2 - 1;
        int columna = columna_2 - 1;

        // Verificar si las coordenadas están dentro de los límites del array
        if (fila < 0 || fila >= puestos.getListPuestos().length || columna < 0
                || columna >= puestos.getListPuestos()[fila].length) {
            return "El puesto indicado está fuera de los límites.";
        }

        for (int i = 0; i < puestos.getListPuestos().length; i++) {
            for (int j = 0; j < puestos.getListPuestos()[i].length; j++) {
                if (i == fila && j == columna) {
                    if (puestos.getListPuestos()[i][j] != null) {
                        vehiculoEncontrado = "El vehículo en el puesto " + (i + 1) + "," + (j + 1) + " es "
                                + puestos.getListPuestos()[i][j].getModelo();
                    } else {
                        vehiculoEncontrado = "Este puesto está libre.";
                    }
                    return vehiculoEncontrado; // Salir del bucle una vez encontrado el puesto
                }
            }
        }

        // Si no se encuentra el puesto especificado (no debería ocurrir)
        return "Puesto no encontrado.";
    }

    /* 
    // Metodo para obtener el dueño de un vehiculo mediante el puesto ingresado
    */
    public String obtenerDueñoMediantePuesto(int fila_2, int columna_2) {
        String vehiculoEncontrado = "";
        int fila = fila_2 - 1;
        int columna = columna_2 - 1;


        /* 
        // Verificar si las coordenadas están dentro de los límites del array
        */
        if (fila < 0 || fila >= puestos.getListPuestos().length || columna < 0
                || columna >= puestos.getListPuestos()[fila].length) {
            return "El puesto indicado está fuera de los límites.";
        }

        for (int i = 0; i < puestos.getListPuestos().length; i++) {
            for (int j = 0; j < puestos.getListPuestos()[i].length; j++) {
                if (i == fila && j == columna) {
                    if (puestos.getListPuestos()[i][j] != null) {
                        vehiculoEncontrado = "El Propietario del vehiuclo en el puesto " + (i + 1) + "," + (j + 1)
                                + " es " + puestos.getListPuestos()[i][j].getPropietario().getNombre();
                    } else {
                        vehiculoEncontrado = "Este puesto está libre.";
                    }
                    return vehiculoEncontrado; 
                }
            }
        }
        return vehiculoEncontrado;
    }

    /* 
    // Método para darle salida a un vehículo del parqueadero
    */
    public String despacharVehiculo(String placa, LocalTime horaSalida) {
        for (Registro registro : registros) {
            if (registro.getVehiculo() != null && registro.getVehiculo().getPlaca().equals(placa)) {
                registro.setHoraSalida(horaSalida);

                /* 
                // Calcular la tarifa y realizar otros cálculos necesarios
                */
                double tarifa = calcularTarifa(registro);

                /* 
                // Incrementar las ganancias del tipo de vehículo correspondiente
                */
                if (registro.getVehiculo() instanceof Carro) {
                    ganaciasCarros += tarifa;
                } else if (registro.getVehiculo() instanceof MotoClasica) {
                    gananciasMotosClasicas += tarifa;
                } else if (registro.getVehiculo() instanceof MotoHibrida) {
                    gananciasMotosHibridas += tarifa;
                }

                
                puestos.removerVehiculo(placa);

                
                return "El total a pagar del vehículo " + registro.getVehiculo().getModelo() + " es " + tarifa
                        + " pesos.";
            }
        }
        
        return "El vehículo con la placa " + placa + " no existe.";
    }


    /* 
    // Método para caluclar la tarifa del vehiculo una vez registre su salida
    */
    public double calcularTarifa(Registro registro) {
        LocalTime horaEntrada = registro.getHoraEntrada();
        LocalTime horaSalida = registro.getHoraSalida();

        
        LocalDate fechaActual = LocalDate.now();

        /* 
        // Convertir las horas de entrada y salida a LocalDateTime
        */
        LocalDateTime entrada = LocalDateTime.of(fechaActual, horaEntrada);
        LocalDateTime salida = LocalDateTime.of(fechaActual, horaSalida);

        
        Duration duracionEstacionamiento = Duration.between(entrada, salida);

        /* 
        // Verificar si la duración es negativa (hora de salida anterior a hora de entrada)
        */
        if (duracionEstacionamiento.isNegative()) {

            /* 
            // Agregar un día completo a la hora de salida
            */
            salida = salida.plusDays(1);
            

            duracionEstacionamiento = Duration.between(entrada, salida);
        }

        /* 
        // Obtener las horas totales de estacionamiento
        */
        long tiempoEstacionado = duracionEstacionamiento.toHours();
        return tiempoEstacionado * registro.getVehiculo().getTarifa().getValor();
    }
    
    /* 
    // Método para obtner el reporte del dia
    */
    public String obtenerReporteDia() {
        String reporte;
        reporte = "Ganancias de vehículos: " + ganaciasCarros + "\n" + "Ganancias Motos Clásicas: " + gananciasMotosClasicas
                + "\n" + "Ganancias Motos Híbridas: " + gananciasMotosHibridas;
        return reporte;
    }


    /* 
    // Método para obtner el reporte del mes
    */
    public String obtenerReporteMes() {
        String reporteMes;
        reporteMes = "En el mes de " + LocalDate.now().getMonth() + " fueron: \n" + "Ganancias de vehículos: "
                + ganaciasCarros + "\n" + "Ganancias Motos Clásicas: " + gananciasMotosClasicas + "\n"
                + "Ganancias Motos Híbridas: " + gananciasMotosHibridas;
        return reporteMes;
    }


    /* 
    // Método para registrar la salida del vehiculo
    */
    public void registrarSalida(Scanner scanner) {
        System.out.print("Ingrese el número de placa del vehículo: ");
        String placa = scanner.nextLine();
        
        boolean placaExistente = false;
        for (Registro registro : this.registros) {
            if (registro != null && registro.getVehiculo().getPlaca().equals(placa)) {
                placaExistente = true;
                break;
            }
        }
        
        if (!placaExistente) {
            System.out.println("La placa ingresada no existe en el parqueadero. Por favor, ingrese la placa correctamente.");
            return;
        }
        
        System.out.print("Ingrese la hora de salida (HH:MM): ");
        String horaSalidaString = scanner.nextLine();
        
        LocalTime horaSalida;
        try {
            horaSalida = LocalTime.parse(horaSalidaString);
            /* 
            //Validar si la hora está dentro del rango de 00:00 a 23:59
            */ 
            if (horaSalida.isBefore(LocalTime.MIN) || horaSalida.isAfter(LocalTime.MAX)) {
                System.out.println("La hora de salida ingresada no es válida. Por favor, ingrese una hora válida.");
                return;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato de hora de salida inválido. Por favor, ingrese una hora en formato HH:MM.");
            return;
        }
        
        String mensaje = this.despacharVehiculo(placa, horaSalida);
        System.out.println(mensaje);
    }

    /* 
    // Método para el estado del parqeuadero
    */
    public void mostrarEstado() {
        System.out.println(this.obtenerRegistroVehiculos());
    }
}

