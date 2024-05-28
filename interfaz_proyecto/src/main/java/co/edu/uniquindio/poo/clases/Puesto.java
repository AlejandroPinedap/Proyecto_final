package co.edu.uniquindio.poo.clases;
public class Puesto {
    private final int fila;
    private final int columna;
    private Vehiculo[][] listaPuestos;
    private String listaReporte;

    public Puesto(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.listaPuestos = new Vehiculo[fila][columna];
        this.listaReporte = "";
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Vehiculo[][] getListPuestos() {
        return listaPuestos;
    }

    public void setListPuestos(Vehiculo[][] listaVehiculos) {
        this.listaPuestos = listaVehiculos;
    }

    public String getListaReporte() {
        return listaReporte;
    }

    public void setListaReporte(String listaReporte) {
        this.listaReporte = listaReporte;
    }
    //Metodo para agregar un vehiculo a un puesto en especifico 
    public void agregarVehiculo(Vehiculo vehiculo, int filaAñadir, int columnaAñadir) {
        if (filaAñadir < fila && columnaAñadir < columna) {
            if (listaPuestos[filaAñadir][columnaAñadir] == null) {
                boolean placaDuplicada = false;
                for (int i = 0; i < listaPuestos.length; i++) {
                    for (int j = 0; j < listaPuestos[i].length; j++) {
                        if (listaPuestos[i][j] != null && listaPuestos[i][j].getPlaca().equals(vehiculo.getPlaca())) {
                            placaDuplicada = true;
                            break;
                        }
                    }
                    if (placaDuplicada) {
                        break;
                    }
                }
                if (!placaDuplicada) {
                    listaPuestos[filaAñadir][columnaAñadir] = vehiculo;
                    System.out.println("Vehículo agregado: " + vehiculo.getModelo() + " en fila: " + (filaAñadir+1) + ", columna: " + (columnaAñadir+1));
                } else {
                    System.out.println("El vehículo con placa " + vehiculo.getPlaca() + " ya está estacionado en otro puesto.");
                }
            } else {
                System.out.println("El espacio en fila: " + filaAñadir + ", columna: " + columnaAñadir + " está ocupado.");
            }
        } else {
            System.out.println("Posición fuera de los límites de la matriz.");
        }
    }
}