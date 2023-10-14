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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the controller
    }
    //method to clear fields
    public void clearFields() {
        customerIDField.clear();
        nameField.clear();
        dobDate.getEditor().clear();
        phoneField.clear();
        emailField.clear();
        licenseNumberField.clear();
        licenseExpiryDate.setValue(null);
        manualLicense.setSelected(false);
    }
    //check if fields are blank
    public boolean isBlank() {
        LocalDate expiry = licenseExpiryDate.getValue();
        if (customerIDField.getText().isEmpty() || nameField.getText().isEmpty() || phoneField.getText().isEmpty() || licenseNumberField.getText().isEmpty() | expiry == null)
            return true;
        else
            return false;
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
    //check if string is positive
    public boolean isPositive(String input) {
        try {
            int check = Integer.parseInt(input);
            return check >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //error alert if fields are blank
    public void blankErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure all fields are completed");
        alert.show();
    }
    //error alert if customer id, phone number and licsense number are numeric
    public void numericErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Customer ID, Phone Number, and License are numeric");
        alert.show();
    }
    //error alert if customer id, phone number and license are negative numbers
    public void positiveErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Customer ID, Phone Number, and License are positive numbers");
        alert.show();
    }
    //error alert if customer id exists
    public void customerExistsErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Customer with that Customer ID already exists");
        alert.show();
    }

    @FXML
    private void backAction(ActionEvent event) {
        //clear all fields
        clearFields();
        //change scene to customer menu
        App.changeScene(1);
    }

    @FXML
    private void submitAction(ActionEvent event) {
        //check any fields are blank
        if (isBlank())
            blankErrorAlert();
        //check if custmer id, phone number and license are numeric
        else if (!isNumeric(customerIDField.getText()) || !isNumeric(phoneField.getText()) || !isNumeric(licenseNumberField.getText()))
            numericErrorAlert();
        //check if customer id, phone number and license are positive numbers
        else if (!isPositive(customerIDField.getText()) || !isPositive(phoneField.getText()) || !isPositive(licenseNumberField.getText()))
            positiveErrorAlert();
        //check if customer id exists
        else if (App.getCustomerDataHandler().checkCustomerExists(Integer.parseInt(customerIDField.getText()))) {
            customerExistsErrorAlert();
            customerIDField.setText("");
        } else {
            //set manual license to false
            boolean isManualLicense = false;
                //check if manual radio button is selected
                if(manualLicense.isSelected())
                    //set manual license to true
                    isManualLicense = true;
            //get localdates for dob and license expiry
            LocalDate dob = dobDate.getValue();
            LocalDate licenseExpiry = licenseExpiryDate.getValue();
            //create cusotmer object
            Customer c = new Customer(
                    Integer.parseInt(customerIDField.getText()), nameField.getText(), dob, phoneField.getText(),
                    emailField.getText(), Integer.parseInt(licenseNumberField.getText()), licenseExpiry, isManualLicense
            );
            //add customer object to datahandler
            App.getCustomerDataHandler().addCustomer(c);
            //display confirmation alert with customer details
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Customer has been added. Please confirm details:\n" + c.appDisplay());
            alert.show();
            //clear all fields
            clearFields();
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {
        //clear all fields
        clearFields();
    }
}
