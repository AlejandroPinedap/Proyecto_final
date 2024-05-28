package co.edu.uniquindio.poo;

public class Propietario {
    private String nombre;
    private String cedula;
    private String numeroTelefonico;
    public Propietario(String nombre, String cedula, String numeroTelefonico) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numeroTelefonico = numeroTelefonico;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    
}
