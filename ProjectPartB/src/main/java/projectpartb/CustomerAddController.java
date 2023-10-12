/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projectpartb;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class CustomerAddController implements Initializable {


    @FXML
    private Button backButton;
    @FXML
    private Button submitButton;
    @FXML
    private Button clearButton;
    @FXML
    private TextField customerIDField;
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker dobDate;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField licenseNumberField;
    @FXML
    private DatePicker licenseExpiryDate;
    @FXML
    private RadioButton manualLicense;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void clearFields() {
        customerIDField.setText("");
        nameField.setText("");
        dobDate.getEditor().clear();
        phoneField.setText("");
        emailField.setText("");
        licenseNumberField.setText("");
        licenseExpiryDate.getEditor().clear();
        manualLicense.setSelected(false);
    }
    
    public boolean isBlank() {
        if(customerIDField.getText().equals("") | nameField.getText().equals("") | phoneField.getText().equals("") | licenseNumberField.getText().equals(""))
            return false;
        else
            return true; 
    }
    
    public boolean isNumeric(String input) {
        int check = Integer.parseInt(input);
            if (check >= 0)
                return true;
            else
                return false;
    }
    
    //alert for blank fields
    public void blankErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure all fields are completed");
        alert.show();
    }
    
    //alert for member ID, phone number, registration fee and discount not being numeric
    public void numericErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Customer ID, Phone Number and License are numeric");
        alert.show();
    }
    
    //alert if registration field is entered as a negative number
    public void positiveErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Customer ID, Phone Number and License are positive numbers");
        alert.show();
    }
    
    //alert to let user know the member already exists
    public void customerExistsErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Member with that Customer ID already exists");
        alert.show();
    }
    
    @FXML
    private void backAction(ActionEvent event) {
        clearFields();
        App.changeScene(1);
    }

    @FXML
    private void submitAction(ActionEvent event) { 
        //checks if any fields are blank
        if (!isBlank())
            blankErrorAlert();
        //checks if customer, phone and license number field are numeric
        else if (!isNumeric(customerIDField.getText()) | !isNumeric(phoneField.getText()) | !isNumeric(licenseNumberField.getText()))
            numericErrorAlert();
        //checks if member ID exists
        else if (App.getCustomerDataHandler().checkCustomerExists(Integer.parseInt(this.customerIDField.getText()))) {
            customerExistsErrorAlert();
            customerIDField.setText("");
        }
        else {
            //check if manual license is selected
            boolean isManualLicense;
            if (manualLicense.isSelected())
                isManualLicense = true;
            else
                isManualLicense = false;
            //set localdate for date of birth and license expiry
            LocalDate dob = this.dobDate.getValue();
            LocalDate licenseExpiry = this.licenseExpiryDate.getValue();
            //creates customer object
            Customer c = new Customer(Integer.parseInt(this.customerIDField.getText()), this.nameField.getText(), dob, this.phoneField.getText(), this.emailField.getText(), Integer.parseInt(this.licenseNumberField.getText()), licenseExpiry, isManualLicense);
            //adds customer object to arraylist
            App.getCustomerDataHandler().addCustomer(c);
            //alert to confirm customer details
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Customer has been added. Please confirm details :\n" + c.appDisplay());
            alert.show();
            clearFields();
        }
    }
    
    @FXML
    private void clearAction(ActionEvent event) {
        clearFields();
    }

}
