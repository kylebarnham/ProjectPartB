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
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class VehicleAddController implements Initializable {


    @FXML
    private TextField odoFieldCar;
    @FXML
    private TextField colourFieldCar;
    @FXML
    private TextField modelFieldCar;
    @FXML
    private TextField regoFieldCar;
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
    private TextField regoFieldVan;
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
    private TextField regoFieldBus;
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
    private RadioButton availableRadioCar;
    @FXML
    private Button clearButtonCar;
    @FXML
    private RadioButton wheelchairRadio;
    @FXML
    private RadioButton availableRadioVan;
    @FXML
    private Button clearButtonVan;
    @FXML
    private RadioButton availableRadioBus;
    @FXML
    private Button clearButtonBus;
    @FXML
    private RadioButton manualRadioCar;
    @FXML
    private RadioButton manualRadioVan;
    @FXML
    private RadioButton manualRadioBus;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void clearCarFields() {
        regoFieldCar.setText("");
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
    
    public void clearVanFields() {
        regoFieldVan.setText("");
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
    
    public void clearBusFields() {
        regoFieldBus.setText("");
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
    
    public boolean carIsBlank() {
        if(regoFieldCar.getText().equals("") | manufacturerFieldCar.getText().equals("") | modelFieldCar.getText().equals("") | yearFieldCar.getText().equals("") | colourFieldCar.getText().equals("") | odoFieldCar.getText().equals("") | costFieldCar.getText().equals("") | typeFieldCar.getText().equals("") | passengerFieldCar.getText().equals(""))
            return false;
        else
            return true; 
    }
    
    public boolean vanIsBlank() {
        if(regoFieldVan.getText().equals("") | manufacturerFieldVan.getText().equals("") | modelFieldVan.getText().equals("") | yearFieldVan.getText().equals("") | colourFieldVan.getText().equals("") | odoFieldVan.getText().equals("") | costFieldVan.getText().equals("") | passengerFieldVan.getText().equals(""))
            return false;
        else
            return true; 
    }
    
    public boolean busIsBlank() {
        if(regoFieldBus.getText().equals("") | manufacturerFieldBus.getText().equals("") | modelFieldBus.getText().equals("") | yearFieldBus.getText().equals("") | colourFieldBus.getText().equals("") | odoFieldBus.getText().equals("") | costFieldBus.getText().equals("") | typeFieldBus.getText().equals("") | passengerFieldBus.getText().equals(""))
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
        Alert alert = new Alert(Alert.AlertType.ERROR, "Vehicle with that rego already exists");
        alert.show();
    }
    
    @FXML
    private void submitCar(ActionEvent event) {
        if(!carIsBlank())
            blankErrorAlert();
        else if(!isNumeric(yearFieldCar.getText()) | !isNumeric(odoFieldCar.getText()) | !isNumeric(costFieldCar.getText()) | !isNumeric(passengerFieldCar.getText()))
            numericErrorAlert();
        else if(!isPositive(yearFieldCar.getText()) | !isPositive(odoFieldCar.getText()) | !isPositive(costFieldCar.getText()) | !isPositive(passengerFieldCar.getText()))
            positiveErrorAlert();
        else if(App.getVehicleDataHandler().checkVehicleExists(regoFieldCar.getText()))
            vehicleExistsErrorAlert();
        else {
            boolean manual = false;
            boolean available = false;
            if(manualRadioCar.isSelected())
                manual = true;
            if(availableRadioCar.isSelected())
                available = true;
            Vehicle v = new Car(regoFieldCar.getText(), manufacturerFieldCar.getText(), modelFieldCar.getText(), Integer.parseInt(yearFieldCar.getText()), colourFieldCar.getText(), Integer.parseInt(odoFieldCar.getText()), manual, Float.parseFloat(costFieldCar.getText()), available, typeFieldCar.getText(), Integer.parseInt(passengerFieldCar.getText()));
            App.getVehicleDataHandler().addVehicle(v);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle has been added. Please confirm details :\n" + v.appDisplay());
            alert.show();
            clearCarFields();
        }
    }

    @FXML
    private void submitVan(ActionEvent event) {
        if(!vanIsBlank())
            blankErrorAlert();
        else if(!isNumeric(yearFieldVan.getText()) | !isNumeric(odoFieldVan.getText()) | !isNumeric(costFieldVan.getText()) | !isNumeric(passengerFieldVan.getText()))
            numericErrorAlert();
        else if(!isPositive(yearFieldVan.getText()) | !isPositive(odoFieldVan.getText()) | !isPositive(costFieldVan.getText()) | !isPositive(passengerFieldVan.getText()))
            positiveErrorAlert();
        else if(App.getVehicleDataHandler().checkVehicleExists(regoFieldVan.getText()))
            vehicleExistsErrorAlert();
        else {
            boolean manual = false;
            boolean available = false;
            boolean wheelchair = false;
            if(manualRadioVan.isSelected())
                manual = true;
            if(availableRadioVan.isSelected())
                available = true;
            if(wheelchairRadio.isSelected())
                wheelchair = true;
            Vehicle v = new Van(regoFieldVan.getText(), manufacturerFieldVan.getText(), modelFieldVan.getText(), Integer.parseInt(yearFieldVan.getText()), colourFieldVan.getText(), Integer.parseInt(odoFieldVan.getText()), manual, Float.parseFloat(costFieldVan.getText()), available, Integer.parseInt(passengerFieldVan.getText()), wheelchair);
            App.getVehicleDataHandler().addVehicle(v);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle has been added. Please confirm details :\n" + v.appDisplay());
            alert.show();
            clearVanFields();
        }
    }

    @FXML
    private void submitBus(ActionEvent event) {
        if(!busIsBlank())
            blankErrorAlert();
        else if(!isNumeric(yearFieldBus.getText()) | !isNumeric(odoFieldBus.getText()) | !isNumeric(costFieldBus.getText()) | !isNumeric(passengerFieldBus.getText()))
            numericErrorAlert();
        else if(!isPositive(yearFieldBus.getText()) | !isPositive(odoFieldBus.getText()) | !isPositive(costFieldBus.getText()) | !isPositive(passengerFieldBus.getText()))
            positiveErrorAlert();
        else if(App.getVehicleDataHandler().checkVehicleExists(regoFieldBus.getText()))
            vehicleExistsErrorAlert();
        else {
            boolean manual = false;
            boolean available = false;
            if(manualRadioCar.isSelected())
                manual = true;
            if(availableRadioCar.isSelected())
                available = true;
            Vehicle v = new Bus(regoFieldBus.getText(), manufacturerFieldBus.getText(), modelFieldBus.getText(), Integer.parseInt(yearFieldBus.getText()), colourFieldBus.getText(), Integer.parseInt(odoFieldBus.getText()), manual, Float.parseFloat(costFieldBus.getText()), available,  Integer.parseInt(passengerFieldBus.getText()), typeFieldBus.getText());
            App.getVehicleDataHandler().addVehicle(v);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle has been added. Please confirm details :\n" + v.appDisplay());
            alert.show();
            clearBusFields();
        }
    }
    
    @FXML
    private void backAction(ActionEvent event) {
        App.changeScene(7);
    }

    @FXML
    private void clearCarAction(ActionEvent event) {
        clearCarFields();
    }

    @FXML
    private void clearVanAction(ActionEvent event) {
        clearVanFields();
    }

    @FXML
    private void clearBusAction(ActionEvent event) {
        clearBusFields();
    }

}
