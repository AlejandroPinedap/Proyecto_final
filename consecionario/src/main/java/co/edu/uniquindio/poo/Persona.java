package co.edu.uniquindio.poo;

public class Persona {
    private String nombre;
    private String id;
    private String correo;
    private String telefono;

    public Persona(String nombre, String id, String correo, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean esAdministrador() {
        return false;  // Por defecto, la Persona no es Administrador
    }

    // Método para verificar si la persona es un Empleado
    public boolean esEmpleado() {
        return false;  // Por defecto, la Persona no es Empleado
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
