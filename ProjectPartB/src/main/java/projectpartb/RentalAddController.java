/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projectpartb;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.time.temporal.ChronoUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class RentalAddController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button submitButton;
    @FXML
    private TextField regoField;
    @FXML
    private DatePicker rentalStartDate;
    @FXML
    private DatePicker rentalEndDate;
    @FXML
    private Button clearButton;
    @FXML
    private TextField rentalIDField;
    @FXML
    private TextField customerIDField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //method to clear fields
    public void clearFields() {
        rentalIDField.setText("");
        customerIDField.setText("");
        regoField.setText("");
        rentalStartDate.setValue(null);
        rentalEndDate.setValue(null);
    }
    //boolean to check if fields are blank
    public boolean isBlank() {
        if(customerIDField.getText().equals("") | customerIDField.getText().equals("") | regoField.getText().equals("") | rentalStartDate == null | rentalEndDate == null)
            return false;
        else
            return true; 
    }
    //boolean to check if input is number 
    public boolean isNumeric(String input) {
        int check = Integer.parseInt(input);
            if (check >= 0)
                return true;
            else
                return false;
    }
    //boolean to check if input is a positive number
    private boolean isPositive(String input)
    {
        int check = Integer.parseInt(input);
            if (check >= 0)
                return true;
            else
                return false;
    }
    //boolean to check if customer can drive vehicle
    private boolean canDrive(int userID, String regoID) {
        if (App.getCustomerDataHandler().checkManualLicense(userID) == false && App.getVehicleDataHandler().isVehicleManual(regoID) == true)
            return false;
        else
            return true;
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
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Rental ID and Customer ID");
        alert.show();
    }
    //alert if registration field is entered as a negative number
    public void positiveErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Customer ID, Phone Number and License are positive numbers");
        alert.show();
    }
    //alert to let user know the member already exists
    public void rentalExistsErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Rental with that ID already exists");
        alert.show();
    }
    //error message if customer doesn't exist
    public void noCustomerErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Customer ID doesn't exist");
        alert.show();
    }
    //error message if vehicle doesn't exist
    public void noVehicleErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Vehicle registration doesn't exist");
        alert.show();
    }
    //error message if vehicle is unavailable
    public void vehicleUnavailableErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Vehicle registration doesn't exist");
        alert.show();
    }
    //error message if customer cannot drive vehicle
    public void cantDriveErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Customer does not have the appropriate license to drive this vehicle");
        alert.show();
    }
    
    @FXML
    private void submitAction(ActionEvent event) {
        //check if any fields are blank
        if (!isBlank())
            blankErrorAlert();
        //check if rental id or customer id are numeric
        else if (!isNumeric(rentalIDField.getText()) | !isNumeric(customerIDField.getText()))
            numericErrorAlert();
        //check if rental id or customer id are positive numbers
        else if (!isPositive(rentalIDField.getText()) | !isPositive(customerIDField.getText()))
            positiveErrorAlert();
        //check if rental id exists
        else if (App.getRentalDataHandler().checkRentalExists(Integer.parseInt(rentalIDField.getText()))) {
            rentalExistsErrorAlert();
            rentalIDField.setText("");
        }
        //check if customer ID exists
        else if (!App.getCustomerDataHandler().checkCustomerExists(Integer.parseInt(customerIDField.getText()))) {
            noCustomerErrorAlert();
            customerIDField.setText("");
        }
        //check if rego number exists
        else if (!App.getVehicleDataHandler().checkVehicleExists(regoField.getText())) {
            noVehicleErrorAlert();
            regoField.setText("");
        }
        //check if vehicle is available
        else if (!App.getVehicleDataHandler().isVehicleAvailable(regoField.getText())) {
            vehicleUnavailableErrorAlert();
            regoField.setText("");
        }
        //check if can drive the vehicle
        else if (!canDrive(Integer.parseInt(customerIDField.getText()), regoField.getText())) {
            cantDriveErrorAlert();
            regoField.setText("");
        }
        else {
            //set localdates
            LocalDate start = rentalStartDate.getValue();
            LocalDate end = rentalEndDate.getValue();
            LocalDate today = LocalDate.now();
            //calculate days between start and end date
            int days = (int) ChronoUnit.DAYS.between(start, end);
            //calculate total cost of rental
            float totalCost = App.getVehicleDataHandler().totalCost(regoField.getText(), days);
            //assign boolean
            boolean returned = false;
            boolean overdue = false;
            //check if rental is due and hasn't been returned
            if (end.isBefore(today) &&  returned == false)
                overdue = true;
            //create rental object
            Rental r = new Rental(Integer.parseInt(rentalIDField.getText()), Integer.parseInt(customerIDField.getText()), regoField.getText(), start, end, returned, overdue, totalCost);
            //add rental object to DataHandler
            App.getRentalDataHandler().addRental(r);
            //display alert with customer details
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Rental has been added. Please confirm details :\n" + r.appDisplay());
            alert.show();
            clearFields();
        }
    }
    
    @FXML
    private void backAction(ActionEvent event) {
        //change scene to rentalMain
        App.changeScene(13);
    }

    @FXML
    private void clearAction(ActionEvent event) {
        //clear all fields
        clearFields();
    }

}
