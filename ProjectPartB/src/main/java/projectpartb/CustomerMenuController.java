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
public class CustomerMenuController implements Initializable {


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
        //change scene to customer add
        App.changeScene(2);
    }

    @FXML
    private void viewAction(ActionEvent event) {
        //change scene to customer view
        App.changeScene(3);
    }

    @FXML
    private void findAction(ActionEvent event) {
        //change scene to customer edit
        App.changeScene(4);
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        //change scene to customer delete
        App.changeScene(6);
    }
    @FXML
    private void exitAction(ActionEvent event) {
        //change scene to main menu
        App.changeScene(0);
    }
}
