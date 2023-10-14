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
import javafx.scene.control.TextArea;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class RentalViewController implements Initializable {


    @FXML
    private Button backButton;
    @FXML
    private TextArea textArea;
    @FXML
    private Button updateButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //displays all customer details in text area
        textArea.setText(App.getRentalDataHandler().getDisplayOutput());
    }    
    
    @FXML
    private void backAction(ActionEvent event) {
        //changes scene to rental menu
        App.changeScene(13);
    }

    @FXML
    private void updateAction(ActionEvent event) {
        //updates textarea when update button is clicked
        textArea.setText(App.getRentalDataHandler().getDisplayOutput());
    }

}
