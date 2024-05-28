package co.edu.uniquindio.poo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import co.edu.uniquindio.poo.clases.Parqueadero;
import co.edu.uniquindio.poo.clases.Puesto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CrearParqueaderoController {
   

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCrearParqueadero;

    @FXML
    private TextField txNombreParqueadero;

    @FXML
    private TextField txtColumna;

    @FXML
    private TextField txtFila;
    //se crea el parqueadero y se envia al menu parqueadero
    @FXML
    private void switchToSecondary() throws IOException {
        String nombreParqueadero = txNombreParqueadero.getText();
        int fila = Integer.parseInt(txtFila.getText());
        int columna = Integer.parseInt(txtColumna.getText());
        if(!nombreParqueadero.isBlank()){
            Puesto puesto =new Puesto(fila, columna);
            Parqueadero parqueadero = new Parqueadero(nombreParqueadero);
            parqueadero.agregarPuestos(puesto);
            ControlParqueaderoController.getcontrolParqueaderoController().recibirParqueadero(parqueadero);
            App.setRoot("menuParqueadero");
            System.out.println("Se creo el parqueadero con nombre: "+parqueadero.getNombre()+" y con: "+parqueadero.obtenerRegistro());
           
            
        }
        
    }

  
   

   

}
