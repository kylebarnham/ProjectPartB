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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class CustomerEditController implements Initializable {


    @FXML
    private Button backButton;
    @FXML
    private Button submitButton;
    @FXML
    private TextField customerIDField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField licenseNumberField;
    @FXML
    private DatePicker dobDate;
    @FXML
    private DatePicker licenseExpiryDate;
    @FXML
    private Button getButton;
    @FXML
    private RadioButton manualLicense;
    @FXML
    private TextArea textArea;
    @FXML
    private Button clearButton;
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
        textArea.setText("");
    }
    
    public boolean isBlank() {
        if(customerIDField.getText().equals("") | nameField.getText().equals("") | phoneField.getText().equals("") | licenseNumberField.getText().equals(""))
            return false;
        else
            return true; 
    }
    
    //check if a string is numeric
    private boolean isNumeric(String str)
    {
	for (int i = 0; i < str.length(); i++)
    	{
    	    if (!Character.isDigit(str.charAt(i)))
		return false;
	}

	return true;
    }
    
    public boolean isPositive(String input) {
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
    
    public void positiveErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Customer ID, Phone Number and License are positive numbers");
        alert.show();
    }
    
    //alert to let user know the member already exists
    public void noCustomerErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "No Customers with that ID exists");
        alert.show();
    }
    
    @FXML
    private void backAction(ActionEvent event) {
        App.changeScene(1);
    }

    @FXML
    private void submitAction(ActionEvent event) {
        if (!isBlank())
            blankErrorAlert();
        else if (!isNumeric(customerIDField.getText()) | !isNumeric(phoneField.getText()) | !isNumeric(licenseNumberField.getText()))
            numericErrorAlert();
        else if (!isPositive(customerIDField.getText()) | !isPositive(phoneField.getText()) | !isPositive(licenseNumberField.getText()))
            positiveErrorAlert();
        else if (!App.getCustomerDataHandler().checkCustomerExists(Integer.parseInt(this.customerIDField.getText()))) {
            noCustomerErrorAlert();
            customerIDField.setText("");
        }
        else {
            boolean isManualLicense;
            if (manualLicense.isSelected())
                isManualLicense = true;
            else
                isManualLicense = false;
            LocalDate dob = this.dobDate.getValue();
            LocalDate licenseExpiry = this.licenseExpiryDate.getValue();
            Customer c = new Customer(Integer.parseInt(this.customerIDField.getText()), this.nameField.getText(), dob, this.phoneField.getText(), this.emailField.getText(), Integer.parseInt(this.licenseNumberField.getText()), licenseExpiry, isManualLicense);
            App.getCustomerDataHandler().updateCustomer(Integer.parseInt(this.customerIDField.getText()), c);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Customer has been updated :\n" + c.appDisplay());
            alert.show();
            clearFields();
        }
    }

    @FXML
    private void getAction(ActionEvent event) {
        int userID = Integer.parseInt(this.customerIDField.getText());
        textArea.setText(App.getCustomerDataHandler().searchCustomer(userID));
    }

    @FXML
    private void clearAction(ActionEvent event) {
        clearFields();
    }

}
