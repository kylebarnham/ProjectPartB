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
public class CustomerDeleteController implements Initializable {


    @FXML
    private Button searchButton;
    @FXML
    private TextArea textArea;
    @FXML
    private Button deleteButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField customerIDField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void searchAction(ActionEvent event) {
        int userID = Integer.parseInt(customerIDField.getText());
        textArea.setText(App.getCustomerDataHandler().searchCustomer(userID));
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        int userID = Integer.parseInt(customerIDField.getText());
        if (App.getCustomerDataHandler().checkCustomerExists(userID)) {    
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want delete this customer?");
                alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    App.getCustomerDataHandler().deleteCustomer(userID);
                    customerIDField.setText("");
                    textArea.setText("");
                }
            }
        );}
    }

    @FXML
    private void backAction(ActionEvent event) {
        App.changeScene(1);
    }

}
