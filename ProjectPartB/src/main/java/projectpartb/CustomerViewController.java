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
public class CustomerViewController implements Initializable {


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
        //display all customer details
        textArea.setText(App.getCustomerDataHandler().getDisplayOutput());
    }    
    @FXML
    private void backAction(ActionEvent event) {
        //change scene to customer menu
        App.changeScene(1);
    }

    @FXML
    private void updateAction(ActionEvent event) {
        //update all customer details
        textArea.setText(App.getCustomerDataHandler().getDisplayOutput());
    }

}
