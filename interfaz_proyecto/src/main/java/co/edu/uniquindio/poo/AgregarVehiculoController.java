package co.edu.uniquindio.poo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.clases.Parqueadero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AgregarVehiculoController {
    private static AgregarVehiculoController agregarVehiculoController;
    private Parqueadero parqueadero;
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public AgregarVehiculoController() {

    }

    public static AgregarVehiculoController getaAgregarVehiculoController() {
        if (agregarVehiculoController == null) {
            agregarVehiculoController = new AgregarVehiculoController();
        }
        return agregarVehiculoController;
    }

    // Metdoodo que recibe "parqueadero" de la clase ""ControlParqeuadero"
    @SuppressWarnings("exports")
    public void recibirParqueadero(Parqueadero parqueadero) {
        if (parqueadero != null) {
            System.out.println("Parqueadero recibido en AgregarVehiculoController: " + parqueadero.getNombre());
            this.parqueadero = parqueadero;
            System.out.println(parqueadero.obtenerRegistro());
        } else {
            System.out.println("El objeto parqueadero es null en AgregarVehiculoController");
        }
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnObtenerRegistro;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnagregarVehiculo;

    @FXML
    private TextField txtHoraEntrada;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextArea txtRegitro;

    @FXML
    void agregarVehiculo(ActionEvent event) {
        String placa = txtPlaca.getText();
        String horaEntradaStr = txtHoraEntrada.getText();
        LocalTime horaEntrada = LocalTime.parse(horaEntradaStr, timeFormatter);
        if(!placa.isBlank() && !horaEntradaStr.isBlank()){
            parqueadero.agregarVehiculoPuesto(placa, horaEntrada);
            mostrarAlerta("Éxito", "Vehiculo agregado exitosamente", AlertType.INFORMATION);
        }
        txtHoraEntrada.setText("");
        txtPlaca.setText("");
        
    }

    @FXML
    void registro(ActionEvent event) {
        parqueadero = agregarVehiculoController.parqueadero;
        txtRegitro.setText(parqueadero.obtenerRegistro());
       
    }

    @FXML
    void regresar() throws IOException {
        parqueadero = agregarVehiculoController.parqueadero;
        ControlParqueaderoController.getcontrolParqueaderoController().recibirParqueadero(parqueadero);
        System.out.println("Parqueadero enviado a ControlParqueadero");
        App.setRoot("menuParqueadero");
    }
    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
