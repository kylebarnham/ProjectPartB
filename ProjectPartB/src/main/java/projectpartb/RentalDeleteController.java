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
public class RentalDeleteController implements Initializable {


    @FXML
    private Button searchButton;
    @FXML
    private TextArea textArea;
    @FXML
    private Button deleteButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField rentalIDField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void searchAction(ActionEvent event) {
        int rentalID = Integer.parseInt(rentalIDField.getText());
        //uses search rental method from datahandler
        textArea.setText(App.getRentalDataHandler().searchRental(rentalID));
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        int rentalID = Integer.parseInt(rentalIDField.getText());
        //checks if rental ID exists
        if (App.getRentalDataHandler().checkRentalExists(rentalID)) {    
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Rental will be deleted. Are you sure you want to continue?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                //deletes record from arraylist in datahandler 
                App.getRentalDataHandler().deleteRental(rentalID);
                rentalIDField.setText("");
                textArea.setText("");
                }
            });
        }
        else {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Rental ID doesn't exist");
        alert.show();
        }
    }

    @FXML
    private void backAction(ActionEvent event) {
        //change scene to rentalMenu
        App.changeScene(13);
    }

}
