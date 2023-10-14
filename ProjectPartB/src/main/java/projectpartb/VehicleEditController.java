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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class VehicleEditController implements Initializable {


    @FXML
    private TextField odoFieldCar;
    @FXML
    private TextField colourFieldCar;
    @FXML
    private TextField modelFieldCar;
    @FXML
    private TextField typeFieldCar;
    @FXML
    private TextField passengerFieldCar;
    @FXML
    private TextField yearFieldCar;
    @FXML
    private TextField costFieldCar;
    @FXML
    private TextField manufacturerFieldCar;
    @FXML
    private Button submitButtonCar;
    @FXML
    private Button backButtonCar;
    @FXML
    private TextField odoFieldVan;
    @FXML
    private TextField colourFieldVan;
    @FXML
    private TextField manufacturerFieldVan;
    @FXML
    private TextField passengerFieldVan;
    @FXML
    private TextField yearFieldVan;
    @FXML
    private TextField costFieldVan;
    @FXML
    private TextField modelFieldVan;
    @FXML
    private Button submitButtonVan;
    @FXML
    private Button backButtonVan;
    @FXML
    private TextField odoFieldBus;
    @FXML
    private TextField colourFieldBus;
    @FXML
    private TextField modelFieldBus;
    @FXML
    private TextField passengerFieldBus;
    @FXML
    private TextField yearFieldBus;
    @FXML
    private TextField costFieldBus;
    @FXML
    private TextField manufacturerFieldBus;
    @FXML
    private Button submitButtonBus;
    @FXML
    private Button backButtonBus;
    @FXML
    private TextField typeFieldBus;
    @FXML
    private Button clearButtonCar;
    @FXML
    private Button clearButtonVan;
    @FXML
    private Button clearButtonBus;
    @FXML
    private RadioButton manualRadioCar;
    @FXML
    private RadioButton availableRadioCar;
    @FXML
    private RadioButton wheelchairRadio;
    @FXML
    private RadioButton manualRadioVan;
    @FXML
    private RadioButton availableRadioVan;
    @FXML
    private RadioButton availableRadioBus;
    @FXML
    private RadioButton manualRadioBus;
    @FXML
    private TextField regoField;
    @FXML
    private Button getButton;
    @FXML
    private TextArea textArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //method to clear all fields in car tab
    public void clearCarFields() {
        manufacturerFieldCar.setText("");
        modelFieldCar.setText("");
        yearFieldCar.setText("");
        colourFieldCar.setText("");
        odoFieldCar.setText("");
        costFieldCar.setText("");
        typeFieldCar.setText("");
        passengerFieldCar.setText("");
        availableRadioCar.setSelected(false);
    }
    //method to clear all fields in van tab
    public void clearVanFields() {
        manufacturerFieldVan.setText("");
        modelFieldVan.setText("");
        yearFieldVan.setText("");
        colourFieldVan.setText("");
        odoFieldVan.setText("");
        costFieldVan.setText("");
        passengerFieldVan.setText("");
        availableRadioCar.setSelected(false);
        wheelchairRadio.setSelected(false);
    }
    //method to clear all fields in bus tab
    public void clearBusFields() {
        manufacturerFieldBus.setText("");
        modelFieldBus.setText("");
        yearFieldBus.setText("");
        colourFieldBus.setText("");
        odoFieldBus.setText("");
        costFieldBus.setText("");
        typeFieldBus.setText("");
        passengerFieldBus.setText("");
        availableRadioCar.setSelected(false);
    }
    //checks if fields in car tab are blank
    public boolean carIsBlank() {
        if(regoField.getText().equals("") | manufacturerFieldCar.getText().equals("") | modelFieldCar.getText().equals("") | yearFieldCar.getText().equals("") | colourFieldCar.getText().equals("") | odoFieldCar.getText().equals("") | costFieldCar.getText().equals("") | typeFieldCar.getText().equals("") | passengerFieldCar.getText().equals(""))
            return false;
        else
            return true; 
    }
    //checks if fields in van tab are blank
    public boolean vanIsBlank() {
        if(regoField.getText().equals("") | manufacturerFieldVan.getText().equals("") | modelFieldVan.getText().equals("") | yearFieldVan.getText().equals("") | colourFieldVan.getText().equals("") | odoFieldVan.getText().equals("") | costFieldVan.getText().equals("") | passengerFieldVan.getText().equals(""))
            return false;
        else
            return true; 
    }
    //checks if fields in bus tab are blank
    public boolean busIsBlank() {
        if(regoField.getText().equals("") | manufacturerFieldBus.getText().equals("") | modelFieldBus.getText().equals("") | yearFieldBus.getText().equals("") | colourFieldBus.getText().equals("") | odoFieldBus.getText().equals("") | costFieldBus.getText().equals("") | typeFieldBus.getText().equals("") | passengerFieldBus.getText().equals(""))
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
    //checks if string is positive
    private boolean isPositive(String input)
    {
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
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Year, Odometer, Cost and Number of Passengers are numeric");
        alert.show();
    }
    //alert if registration field is entered as a negative number
    public void positiveErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure Year, Odometer, Cost and Number of Passengers are positive numbers");
        alert.show();
    }
    //alert to let user know the member already exists
    public void vehicleExistsErrorAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "No Vehicle with that rego exists");
        alert.show();
    }
    
    @FXML
    private void submitCar(ActionEvent event) {
        //checks if fields in car tab are blank
        if(!carIsBlank())
            blankErrorAlert();
        //checks if fields in car tab are numeric
        else if(!isNumeric(yearFieldCar.getText()) | !isNumeric(odoFieldCar.getText()) | !isNumeric(costFieldCar.getText()) | !isNumeric(passengerFieldCar.getText()))
            numericErrorAlert();
        //checks if fields in car tab are positive
        else if(!isPositive(yearFieldCar.getText()) | !isPositive(odoFieldCar.getText()) | !isPositive(costFieldCar.getText()) | !isPositive(passengerFieldCar.getText()))
            positiveErrorAlert();
        //checks if rego exists
        else if(!App.getVehicleDataHandler().checkVehicleExists(regoField.getText()))
            vehicleExistsErrorAlert();
        else {
            //sets manual and available as false
            boolean manual = false;
            boolean available = false;
            //if manual radio button is selected set as true
            if(manualRadioCar.isSelected())
                manual = true;
            //if available radio button is selected set as true
            if(availableRadioCar.isSelected())
                available = true;
            //creates car object
            Vehicle v = new Car(regoField.getText(), manufacturerFieldCar.getText(), modelFieldCar.getText(), Integer.parseInt(yearFieldCar.getText()), colourFieldCar.getText(), Integer.parseInt(odoFieldCar.getText()), manual, Float.parseFloat(costFieldCar.getText()), available, typeFieldCar.getText(), Integer.parseInt(passengerFieldCar.getText()));
            //updates object in vehicledatahandler arraylsit
            App.getVehicleDataHandler().updateVehicle(regoField.getText(), v);
            //alert to confirm vehicle details
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle has been updated. Please confirm details :\n" + v.appDisplay());
            alert.show();
            //clear fields in car tab
            clearCarFields();
        }
    }

    @FXML
    private void submitVan(ActionEvent event) {
        //checks if fields in van tab are blank
        if(!carIsBlank())
            blankErrorAlert();
        //checks if fields in van tab are numeric
        else if(!isNumeric(yearFieldVan.getText()) | !isNumeric(odoFieldVan.getText()) | !isNumeric(costFieldVan.getText()) | !isNumeric(passengerFieldVan.getText()))
            numericErrorAlert();
        //checks if fields in van tab are positive
        else if(!isPositive(yearFieldVan.getText()) | !isPositive(odoFieldVan.getText()) | !isPositive(costFieldVan.getText()) | !isPositive(passengerFieldVan.getText()))
            positiveErrorAlert();
        //checks if rego exists
        else if(!App.getVehicleDataHandler().checkVehicleExists(regoField.getText()))
            vehicleExistsErrorAlert();
        else {
            //set manual, available and wheelchair as false
            boolean manual = false;
            boolean available = false;
            boolean wheelchair = false;
            //if manual radio button is selected set as true
            if(manualRadioVan.isSelected())
                manual = true;
            //if available radio button is selected set as true
            if(availableRadioVan.isSelected())
                available = true;
            //if wheelchair access radio button is selected set as true
            if(wheelchairRadio.isSelected())
                wheelchair = true;
            //create van object
            Vehicle v = new Van(regoField.getText(), manufacturerFieldVan.getText(), modelFieldVan.getText(), Integer.parseInt(yearFieldVan.getText()), colourFieldVan.getText(), Integer.parseInt(odoFieldVan.getText()), manual, Float.parseFloat(costFieldVan.getText()), available, Integer.parseInt(passengerFieldVan.getText()), wheelchair);
            //updates objecrt in vehicledatahandler
            App.getVehicleDataHandler().updateVehicle(regoField.getText(), v);
            //confirmation alert displaying vehicle details
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle has been updated. Please confirm details :\n" + v.appDisplay());
            alert.show();
            //clear fields in van tab
            clearVanFields();
        }
    }

    @FXML
    private void submitBus(ActionEvent event) {
        //check if fields in bus tab are blank
        if(!busIsBlank())
            blankErrorAlert();
        //checks if fields in bus tab are numeric
        else if(!isNumeric(yearFieldBus.getText()) | !isNumeric(odoFieldBus.getText()) | !isNumeric(costFieldBus.getText()) | !isNumeric(passengerFieldBus.getText()))
            numericErrorAlert();
        //checks if fields in bus tab are positive
        else if(!isPositive(yearFieldBus.getText()) | !isPositive(odoFieldBus.getText()) | !isPositive(costFieldBus.getText()) | !isPositive(passengerFieldBus.getText()))
            positiveErrorAlert();
        //checks if vehicle exists
        else if(!App.getVehicleDataHandler().checkVehicleExists(regoField.getText()))
            vehicleExistsErrorAlert();
        else {
            //set manual and available as false
            boolean manual = false;
            boolean available = false;
            //if manual radio button is selected set as true
            if(manualRadioCar.isSelected())
                manual = true;
            //if available radio button is selected set as true
            if(availableRadioCar.isSelected())
                available = true;
            //creates bus object
            Vehicle v = new Bus(regoField.getText(), manufacturerFieldBus.getText(), modelFieldBus.getText(), Integer.parseInt(yearFieldBus.getText()), colourFieldBus.getText(), Integer.parseInt(odoFieldBus.getText()), manual, Float.parseFloat(costFieldBus.getText()), available, Integer.parseInt(passengerFieldBus.getText()), typeFieldBus.getText());
            //updates object in vehicle datahandler arraylist
            App.getVehicleDataHandler().updateVehicle(regoField.getText(), v);
            //confirmation alert displaying vehicle details
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle has been updated. Please confirm details :\n" + v.appDisplay());
            alert.show();
            //clear fields in bus tab
            clearBusFields();
        }
    }

    @FXML
    private void clearCarAction(ActionEvent event) {
        //clear fields in car tab
        clearCarFields();
    }

    @FXML
    private void clearVanAction(ActionEvent event) {
        //clear fiels in van tab
        clearVanFields();
    }

    @FXML
    private void clearBusAction(ActionEvent event) {
        //clear fields in bus tab
        clearBusFields();
    }

    @FXML
    private void getDetailsAction(ActionEvent event) {
        String rego = regoField.getText();
        //display vehilce details in text area
        textArea.setText(App.getVehicleDataHandler().searchVehicle(rego));
    }
    
    @FXML
    private void backAction(ActionEvent event) {
        //clear all fields
        clearCarFields();
        clearVanFields();
        clearBusFields();
        //change scene to vehicle main
        App.changeScene(7);
    }

}
