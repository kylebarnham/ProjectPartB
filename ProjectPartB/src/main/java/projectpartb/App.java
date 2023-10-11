package projectpartb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene mainMenu;     
    private static Scene custMenu;     
    private static Scene custAdd;     
    private static Scene custView;
    private static Scene custFind;
    private static Scene custDelete; 
    private static Scene vehicleMenu; 
    private static Scene vehicleAdd;     
    private static Scene vehicleView;
    private static Scene vehicleFind;
    private static Scene vehicleDelete; 
    private static Scene rentMenu; 
    private static Scene rentAdd;     
    private static Scene rentView;
    private static Scene rentFind;
    private static Scene rentDelete; 
    private static Stage stage;
    private static CustomerDataHandler customerData;
    private static VehicleDataHandler vehicleData;
    private static RentalDataHandler rentalData;

    @Override
    public void start(Stage stage) throws IOException {
        //Instatiates the DataHandler object
        customerData = new CustomerDataHandler("customers.txt");  
        vehicleData = new VehicleDataHandler("vehicle.txt");
        rentalData = new RentalDataHandler("rental.txt");
        
        //Creates the Main and AddNumber scene 
        Parent rootMainMenu = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Parent rootCustMenu = FXMLLoader.load(getClass().getResource("customerMenu.fxml"));
        Parent rootCustAdd = FXMLLoader.load(getClass().getResource("customerAdd.fxml"));
        Parent rootCustView = FXMLLoader.load(getClass().getResource("customerView.fxml"));
        Parent rootCustFind = FXMLLoader.load(getClass().getResource("customerFind.fxml"));
        Parent rootCustDelete = FXMLLoader.load(getClass().getResource("customerDelete.fxml"));
        Parent rootVehicleMenu = FXMLLoader.load(getClass().getResource("vehicleMenu.fxml"));
        Parent rootVehicleAdd = FXMLLoader.load(getClass().getResource("vehicleAdd.fxml"));
        Parent rootVehicleView = FXMLLoader.load(getClass().getResource("vehicleView.fxml"));
        Parent rootVehicleFind = FXMLLoader.load(getClass().getResource("vehicleFind.fxml"));
        Parent rootVehicleDelete = FXMLLoader.load(getClass().getResource("vehicleDelete.fxml"));
        Parent rootRentMenu = FXMLLoader.load(getClass().getResource("rentalMenu.fxml"));
        Parent rootRentAdd = FXMLLoader.load(getClass().getResource("rentalAdd.fxml"));
        Parent rootRentView = FXMLLoader.load(getClass().getResource("rentalView.fxml"));
        Parent rootRentFind = FXMLLoader.load(getClass().getResource("rentalFind.fxml"));
        Parent rootRentDelete = FXMLLoader.load(getClass().getResource("rentalDelete.fxml"));
        
        mainMenu = new Scene(rootMainMenu);
        custMenu = new Scene(rootCustMenu);
        custAdd = new Scene(rootCustAdd);
        custView = new Scene(rootCustView);
        custFind = new Scene(rootCustFind);
        custDelete = new Scene(rootCustDelete);
        vehicleMenu = new Scene(rootVehicleMenu);
        vehicleAdd = new Scene(rootVehicleAdd);
        vehicleView = new Scene(rootVehicleView);
        vehicleFind = new Scene(rootVehicleFind);
        vehicleDelete = new Scene(rootVehicleDelete);
        rentMenu = new Scene(rootRentMenu);
        rentAdd = new Scene(rootRentAdd);
        rentView = new Scene(rootRentView);
        rentFind = new Scene(rootRentFind);
        rentDelete = new Scene(rootRentDelete);    
        
        this.stage = stage;
        //set the current scene to the main scenen
        
        //scene = new Scene(loadFXML("mainMenu"), 640, 480);
        stage.setScene(mainMenu);
        stage.show();
    }

    //Method for passing a reference to the data object
    public static DataHandler getDataHandler()
    {
        return data;
    }  
    
    //Method for switching scenes
    public static void changeScene(int sc)
    {
        switch(sc) { 
            case 1: stage.setScene(mainMenu); break;
            case 2: stage.setScene(custMenu); break;
            case 3: stage.setScene(custAdd); break;
            case 4: stage.setScene(custView); break;
            case 5: stage.setScene(custFind); break;
            case 6: stage.setScene(custDelete); break;
            case 7: stage.setScene(vehicleMenu); break;
            case 8: stage.setScene(vehicleAdd); break;
            case 9: stage.setScene(vehicleView); break;
            case 10: stage.setScene(vehicleFind); break;
            case 11: stage.setScene(vehicleDelete); break;
            case 12: stage.setScene(rentMenu); break;
            case 13: stage.setScene(rentAdd); break;
            case 14: stage.setScene(rentView); break;
            case 15: stage.setScene(rentFind); break;
            case 16: stage.setScene(rentDelete); break;
            default:
        } 
    }
    
   //Method for exiting the application
    public static void exit()
    { 
        stage.close();
    }


    public static void main(String[] args) {
        launch();
    }
   
}