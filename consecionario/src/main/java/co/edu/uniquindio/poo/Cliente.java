package co.edu.uniquindio.poo;

public class Cliente extends Persona {
    private String direccion;
    private String telefono;

    public Cliente(String nombre, String id, String correo, String direccion, String telefono) {
        super(nombre, id, correo, telefono);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getNombre() + '\'' +
                ", id='" + getId() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

