package co.edu.uniquindio.poo.clases;

import java.time.LocalTime;


public class Registro {
    private LocalTime horaSalida;
    private LocalTime horaEntrada;
    private Vehiculo vehiculo;
    public Registro( Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public LocalTime getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    @Override
    public String toString() {
        return "Registro [horaSalida=" + horaSalida + ", horaEntrada=" + horaEntrada + ", vehiculo=" + vehiculo + "]";
    }

    
}
