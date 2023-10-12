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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class RentalEditController implements Initializable {


    @FXML
    private Button backButton;
    @FXML
    private Button submitButton;
    @FXML
    private TextField RentalIDField;
    @FXML
    private TextField CustomerIDField;
    @FXML
    private TextField regoField;
    @FXML
    private DatePicker rentalStartDate;
    @FXML
    private DatePicker rentalEndDate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void backAction(ActionEvent event) {
    }

    @FXML
    private void submitAction(ActionEvent event) {
    }

}
