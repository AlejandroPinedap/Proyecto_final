package co.edu.uniquindio.poo.clases;

public abstract class Moto extends Vehiculo {
    private int velocidad;

    public Moto(String placa, String modelo, Propietario propietario, Tarifa tarifa, int velocidad) {
        super(placa, modelo, propietario, tarifa);
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
}
