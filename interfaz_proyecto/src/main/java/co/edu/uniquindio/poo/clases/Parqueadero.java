package co.edu.uniquindio.poo.clases;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Parqueadero {
    private String nombre;
    private double ganaciasCarros;
    private double gananciasMotosHibridas;
    private double gananciasotosClasicas;
  
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
        return gananciasotosClasicas;
    }

    public void setGananciasotosClasicas(double tarifa) {
        this.gananciasotosClasicas = tarifa;
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

    // Metodo para agregar la matriz de puestos al parqueadero
    public void agregarPuestos(Puesto puestos) {
        setPuestos(puestos);
    }

    // Metodo para agrega un registro al parqueadero
    public void agregarRegistro(Registro registro) {
        // Verificar si el registro ya existe
        for (Registro r : registros) {
            if (r != null && r.equals(registro)) {
                System.out.println("El registro ya existe");
                return;
            }
        }

        // Agregar el registro si no existe
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] == null) {
                registros[i] = registro;
                break;
            }
        }
    }

    // Metodo para agregar un vehiculo a un puesto del parqueadero
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
                        break; // Salir del bucle externo si el vehículo se agregó exitosamente
                    }
                }
                if (vehiculoAgregado) {
                    break; // Salir del bucle de registros si el vehículo se agregó exitosamente
                }
            }
        }
    }

    // Metodo para obtener el registro de los vehiculos inscritos en el parqueadero
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

    // Metodo para obtener el registro de los vehiculos que estan en el parqueadero
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

    // Metodo para obtener el dueño de un vehiculo mediante el puesto ingresado
    public String obtenerDueñoMediantePuesto(int fila_2, int columna_2) {
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
                        vehiculoEncontrado = "El Propietario del vehiuclo en el puesto " + (i + 1) + "," + (j + 1)
                                + " es " + puestos.getListPuestos()[i][j].getPropietario().getNombre();
                    } else {
                        vehiculoEncontrado = "Este puesto está libre.";
                    }
                    return vehiculoEncontrado; // Salir del bucle una vez encontrado el puesto
                }
            }
        }
        return vehiculoEncontrado;
    }

    // metodo para darle salida a un vehiculo del parqueadero
    public String despacharVehiculo(String placa, LocalTime horaSalida) {
        for (Registro registro : registros) {
            if (registro.getVehiculo() != null && registro.getVehiculo().getPlaca().equals(placa)) {
                registro.setHoraSalida(horaSalida);

                double tarifa = calcularTarifa(registro);
                if(registro.getVehiculo() instanceof Carro){
                    setGanaciasCarros(tarifa);
                }else if (registro.getVehiculo() instanceof MotoClasica){
                    setGananciasotosClasicas(tarifa);
                }else{
                    setGananciasMotosHibridas(tarifa);
                }
                String menasaje = "El total a pagar del vehículo " + registro.getVehiculo().getModelo() + " es "
                        + tarifa
                        + " pesos.";
                retirarVehiculo(placa);
                return menasaje;

            }
        }
        return "El vehículo con la placa " + placa + " no existe.";
    }

    // Metodo para obtener el total a pargar de un vehiculo
    private double calcularTarifa(Registro registro) {
        long tiempoEstacionado = Duration.between(registro.getHoraEntrada(), registro.getHoraSalida()).toHours();
        return tiempoEstacionado * registro.getVehiculo().getTarifa().getValor();
    }

    // Método para retirar un vehículo de la matriz
    private void retirarVehiculo(String placa) {
        for (int i = 0; i < puestos.getListPuestos().length; i++) {
            for (int j = 0; j < puestos.getListPuestos()[i].length; j++) {
                if (puestos.getListPuestos()[i][j] != null && puestos.getListPuestos()[i][j].getPlaca().equals(placa)) {
                    System.out.println("Vehículo " + puestos.getListPuestos()[i][j].getModelo() + " retirado");
                    puestos.getListPuestos()[i][j] = null;
                    return; // Salir del método una vez encontrado y retirado el vehículo
                }
            }
        }
    }

    public String obtenerReporteDia() {
        String reporte;
        reporte = "Ganancias de vehiculos: "+ganaciasCarros+"\n"+"Ganancias Motos Clasicas: "+gananciasotosClasicas+"\n"+"Ganancias Motos Hibridas: "+gananciasMotosHibridas;
        return reporte;

    }

    public String obtenerReporteMes() {
        String reporteMes;
        reporteMes = "En el mes de "+LocalDate.now()+" fueron: \n"+"Ganancias de vehiculos: "+ganaciasCarros+"\n"+"Ganancias Motos Clasicas: "+gananciasotosClasicas+"\n"+"Ganancias Motos Hibridas: "+gananciasMotosHibridas;
        return reporteMes;
    }

}
