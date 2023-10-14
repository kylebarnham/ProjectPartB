/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projectpartb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class VehicleDeleteController implements Initializable {


    @FXML
    private TextField regoVehicle;
    @FXML
    private Button searchButton;
    @FXML
    private TextArea textArea;
    @FXML
    private Button deleteButton;
    @FXML
    private Button backButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void searchAction(ActionEvent event) {
        String rego = regoVehicle.getText();
        //gets search vehicle method from datahandler to display vehicle details
        textArea.setText(App.getVehicleDataHandler().searchVehicle(rego));
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        String rego = regoVehicle.getText();
        //checks if vehicle rego exists
        if (App.getVehicleDataHandler().checkVehicleExists(rego)) { 
            //confirmation alert to make sure user wants to delete record
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle will be deleted. Do you want to continue?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    App.getVehicleDataHandler().deleteVehicle(rego);
                    regoVehicle.setText("");
                    textArea.setText("");
                }
            });
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vehicle registration doesn't exist");
            alert.show();
        }
    }

    @FXML
    private void backAction(ActionEvent event) {
        //changes scene to vehicle main
        App.changeScene(7);
    }
}
