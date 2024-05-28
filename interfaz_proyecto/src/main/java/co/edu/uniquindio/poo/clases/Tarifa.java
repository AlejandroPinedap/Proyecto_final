package co.edu.uniquindio.poo.clases;

public enum Tarifa {
    CARRO(3000),
    MOTO_HIBRIDA(1500),
    MOTO_CLASICA(1000);

    private int valor;

    private Tarifa(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
