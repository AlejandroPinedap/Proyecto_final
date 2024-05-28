package co.edu.uniquindio.poo;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import co.edu.uniquindio.poo.clases.Parqueadero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ControlParqueaderoController {

    private static ControlParqueaderoController controlParqueaderoController;
    private Parqueadero parqueadero;

    public ControlParqueaderoController() {

    }

    // metodo singleton
    public static ControlParqueaderoController getcontrolParqueaderoController() {
        if (controlParqueaderoController == null) {
            controlParqueaderoController = new ControlParqueaderoController();
        }
        return controlParqueaderoController;
    }

    // metodo para recibir la clase parqueadero de la calse""CrearParqueadero"
    @SuppressWarnings("exports")
    public void recibirParqueadero(Parqueadero parqueaderoActualizado) {
        this.parqueadero = parqueaderoActualizado;
        if (parqueadero != null) {
            System.out.println("Recibido parqueadero en ControlParqueadero: " + parqueadero.getNombre());

        } else {
            System.out.println("El objeto parqueadero es null al recibirlo");
        }
    }

    @FXML
    private ResourceBundle resources;
    @FXML
    private Button btnRepoteMensual;
    @FXML
    private URL location;

    @FXML
    private Button btnActivarRegistro;

    @FXML
    private Button btnAgregarVehiculo;

    @FXML
    private Button btnDespcharVehiculo;

    @FXML
    private Button btnRegistroDia;

    @FXML
    private TextArea txtRegitroParqueadero;
    @FXML
    private TextArea txtRegistroVehiculos;

    @FXML
    void inicializarRegistro(ActionEvent event) {
        txtRegitroParqueadero
                .setText(ControlParqueaderoController.getcontrolParqueaderoController().parqueadero.obtenerRegistro());
        txtRegistroVehiculos.setText(
                ControlParqueaderoController.getcontrolParqueaderoController().parqueadero.obtenerRegistroVehiculos());

    }

    // Boton para agregar vehiculo, el cual envia "parqueadero" a la clase "agregar
    // vehiculo"
    @FXML
    void ventanaAgregarVehiculo() throws IOException {
        System.out.println(controlParqueaderoController.parqueadero.getNombre());
        if (controlParqueaderoController.parqueadero != null) {
            System.out.println("Pasando parqueadero a AgregarVehiculoController: "
                    + controlParqueaderoController.parqueadero.getNombre());
            parqueadero = controlParqueaderoController.parqueadero;
            AgregarVehiculoController.getaAgregarVehiculoController().recibirParqueadero(parqueadero);
            App.setRoot("agregarVehiculo");

        } else {
            System.out.println("El objeto parqueadero es null. No se puede abrir la ventana de agregar vehículo.");
        }
    }

    @FXML
    void ventanaDespacho() throws IOException {
        if (controlParqueaderoController.parqueadero != null) {
            parqueadero = controlParqueaderoController.parqueadero;
            DespacharVehiculoController.getDespacharVehiculoController().recibirParqueadero(parqueadero);
            App.setRoot("despachar");
        } else {
            System.out.println("El objeto es null. No se puede abrir la ventana deschar");
        }
    }

    @FXML
    void obtenerReporteDia() throws IOException {
        mostrarAlerta("Reporte Dia", controlParqueaderoController.parqueadero.obtenerReporteDia(), AlertType.INFORMATION);
    }

    @FXML
    void ventanaAgregarRegistro(ActionEvent actionEvent) throws IOException {
        System.out.println(controlParqueaderoController.parqueadero.getNombre());
        if (controlParqueaderoController.parqueadero != null) {
            System.out.println("Pasando parqueadero a AgregarVehiculoController: "
                    + controlParqueaderoController.parqueadero.getNombre());
            parqueadero = controlParqueaderoController.parqueadero;
            AgregarRegistroController.getaAgregarRegistroController().recibirParqueadero(parqueadero);
            App.setRoot("agregarRegistro");
        } else {
            System.out.println("El objeto parqueadero es null. No se puede abrir la ventana de agregar vehiculo");
        }
    }

    @FXML
    void obtenerReporteMensual(ActionEvent event) {
        mostrarAlerta("Reporte Mensual", controlParqueaderoController.parqueadero.obtenerReporteMes(), AlertType.INFORMATION);
    }


    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
