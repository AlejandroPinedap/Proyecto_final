package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private Propietario propietario;
    private Tarifa tarifa;
    public Vehiculo(String placa, String modelo, Propietario propietario, Tarifa tarifa) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.tarifa = tarifa;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Propietario getPropietario() {
        return propietario;
    }
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    public Tarifa getTarifa() {
        return tarifa;
    }
    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", modelo=" + modelo + ", propietario=" + propietario + ", tarifa=" + tarifa
                + "]";
    }

}
