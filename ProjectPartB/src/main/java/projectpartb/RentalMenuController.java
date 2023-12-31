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
public class RentalMenuController implements Initializable {


    @FXML
    private Button creatButton;
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
    private void createAction(ActionEvent event) {
        //change scene to rental add
        App.changeScene(14);
    }

    @FXML
    private void viewAction(ActionEvent event) {
        //change scene to rental view
        App.changeScene(15);
    }

    @FXML
    private void findAction(ActionEvent event) {
        //change scene to rental edit
        App.changeScene(17);
    }
    
    @FXML
    private void deleteAction(ActionEvent event) {
        //change scene to rental delete
        App.changeScene(18);
    }

    @FXML
    private void exitAction(ActionEvent event) {
        // change scene to main menu
        App.changeScene(0);
    }
}
