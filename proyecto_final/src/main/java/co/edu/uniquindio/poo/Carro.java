package co.edu.uniquindio.poo;

public class Carro extends Vehiculo{

    public Carro(String placa, String modelo, Propietario propietario, Tarifa tarifa) {
        super(placa, modelo, propietario, tarifa);
    
    }


    @Override
    public String toString() {
        return "Carro []";
    }


    
}
