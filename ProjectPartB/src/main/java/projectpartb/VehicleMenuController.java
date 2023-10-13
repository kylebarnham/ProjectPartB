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

/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class VehicleMenuController implements Initializable {

    @FXML
    private Button addButton;
    @FXML
    private Button viewButton;
    @FXML
    private Button findButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button deleteButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addAction(ActionEvent event) {
        App.changeScene(8);
    }

    @FXML
    private void viewAction(ActionEvent event) {
        App.changeScene(9);
    }

    @FXML
    private void findAction(ActionEvent event) {
        App.changeScene(11);
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        App.changeScene(12);
    }
    
    @FXML
    private void exitAction(ActionEvent event) {
        App.changeScene(0);
    }
}
