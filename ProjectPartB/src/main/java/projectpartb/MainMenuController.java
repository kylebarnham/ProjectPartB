/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projectpartb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class MainMenuController implements Initializable {


    @FXML
    private Button customerButton;
    @FXML
    private Button vehicleButton;
    @FXML
    private Button rentalButton;
    @FXML
    private Button exitButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void customerAction(ActionEvent event) {
        //change scene to customer main
        App.changeScene(1);
    }

    @FXML
    private void vehicleAction(ActionEvent event) {
        //change scene to vehicle main
        App.changeScene(7);
    }

    @FXML
    private void rentalAction(ActionEvent event) {
        //change scene to rental main
        App.changeScene(13);
    }

    @FXML
    private void exitAction(ActionEvent event) {
        //saves all data to datahandlers on app exit
        App.getCustomerDataHandler().saveData();
        App.getVehicleDataHandler().saveData(); 
        App.getRentalDataHandler().saveData(); 
     
        //confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Close?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
            }
        });  
    }

}
