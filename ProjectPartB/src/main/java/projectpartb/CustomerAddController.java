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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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

    public void clearFields() {
        // Clear the fields
        customerIDField.clear();
        nameField.clear();
        dobDate.getEditor().clear();
        phoneField.clear();
        emailField.clear();
        licenseNumberField.clear();
        licenseExpiryDate.getEditor().clear();
        manualLicense.setSelected(false);
    }

    public boolean isBlank() {
        if (customerIDField.getText().isEmpty() || nameField.getText().isEmpty() || phoneField.getText().isEmpty() || licenseNumberField.getText().isEmpty())
            return true;
        else
            return false;
    }

    public boolean isNumeric(String input) {
        try {
            int check = Integer.parseInt(input);
            return check >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void blankErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure all fields are completed");
        alert.show();
    }

    public void numericErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Customer ID, Phone Number, and License are numeric");
        alert.show();
    }

    public void customerExistsErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Customer with that Customer ID already exists");
        alert.show();
    }

    @FXML
    private void backAction(ActionEvent event) {
        clearFields();
        App.changeScene(1); // Assuming 1 is the scene for the Customer menu
    }

    @FXML
    private void submitAction(ActionEvent event) {
        if (isBlank())
            blankErrorAlert();
        else if (!isNumeric(customerIDField.getText()) || !isNumeric(phoneField.getText()) || !isNumeric(licenseNumberField.getText()))
            numericErrorAlert();
        else if (App.getCustomerDataHandler().checkCustomerExists(Integer.parseInt(customerIDField.getText()))) {
            customerExistsErrorAlert();
            customerIDField.setText("");
        } else {
            boolean isManualLicense = false;
                if(manualLicense.isSelected())
                    isManualLicense = false;
            LocalDate dob = dobDate.getValue();
            LocalDate licenseExpiry = licenseExpiryDate.getValue();
            Customer c = new Customer(
                    Integer.parseInt(customerIDField.getText()), nameField.getText(), dob, phoneField.getText(),
                    emailField.getText(), Integer.parseInt(licenseNumberField.getText()), licenseExpiry, isManualLicense
            );
            App.getCustomerDataHandler().addCustomer(c);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Customer has been added. Please confirm details:\n" + c.appDisplay());
            alert.show();
            clearFields();
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {
        clearFields();
    }
}
