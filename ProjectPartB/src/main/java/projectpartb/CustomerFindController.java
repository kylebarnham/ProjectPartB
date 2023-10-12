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
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class CustomerFindController implements Initializable {


    @FXML
    private Button backButton;
    @FXML
    private Button editButton;
    @FXML
    private TextField customerIDField;
    @FXML
    private TextArea textArea;
    @FXML
    private Button submitButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void backAction(ActionEvent event) {
        App.changeScene(1);
    }

    @FXML
    private void editAction(ActionEvent event) {
        App.changeScene(5);
    }

    @FXML
    private void submitAction(ActionEvent event) {
        int userID = Integer.parseInt(this.customerIDField.getText());
        textArea.setText(App.getCustomerDataHandler().searchCustomer(userID));
    }

}
