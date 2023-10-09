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

    private static Scene login;
    private static Scene custMain;
    private static Scene empMain;
    private static Scene managerMain;      
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
    private static Scene empMenu; 
    private static Scene empAdd;     
    private static Scene empView;
    private static Scene empFind;
    private static Scene empDelete;
    private static Stage stage;
    private static DataHandler data;

    @Override
    public void start(Stage stage) throws IOException {
        //Instatiates the DataHandler object
        data = new DataHandler("customers.txt");  
        
        //Creates the Main and AddNumber scene 
        Parent rootLogin = FXMLLoader.load(getClass().getResource("login.fxml"));
        Parent rootCustMain = FXMLLoader.load(getClass().getResource("customerMain.fxml"));
        Parent rootEmpMain = FXMLLoader.load(getClass().getResource("employeeMain.fxml"));
        Parent rootManagerMain = FXMLLoader.load(getClass().getResource("managerMain.fxml"));
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
        Parent rootEmpMenu = FXMLLoader.load(getClass().getResource("employeeMenu.fxml"));
        Parent rootEmpAdd = FXMLLoader.load(getClass().getResource("employeeAdd.fxml"));
        Parent rootEmpView = FXMLLoader.load(getClass().getResource("employeeView.fxml"));
        Parent rootEmpFind = FXMLLoader.load(getClass().getResource("employeeFind.fxml"));
        Parent rootEmpDelete = FXMLLoader.load(getClass().getResource("employeeDelete.fxml"));
        
        login = new Scene(rootLogin);
        custMain = new Scene(rootCustMain);
        empMain = new Scene(rootEmpMain);
        managerMain = new Scene(rootManagerMain);
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
        empMenu = new Scene(rootEmpMenu);
        empAdd = new Scene(rootEmpAdd);
        empView = new Scene(rootEmpView);
        empFind = new Scene(rootEmpFind);
        empDelete = new Scene(rootEmpDelete);     
        
        this.stage = stage;
        //set the current scene to the main scenen
        
        //scene = new Scene(loadFXML("mainMenu"), 640, 480);
        stage.setScene(login);
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
            case 0: stage.setScene(login); break;
            case 1: stage.setScene(custMain); break;
            case 2: stage.setScene(empMain); break;
            case 3: stage.setScene(managerMain); break;
            case 4: stage.setScene(custMenu); break;
            case 5: stage.setScene(custAdd); break;
            case 6: stage.setScene(custView); break;
            case 7: stage.setScene(custFind); break;
            case 8: stage.setScene(custDelete); break;
            case 9: stage.setScene(vehicleMenu); break;
            case 10: stage.setScene(vehicleAdd); break;
            case 11: stage.setScene(vehicleView); break;
            case 12: stage.setScene(vehicleFind); break;
            case 13: stage.setScene(vehicleDelete); break;
            case 14: stage.setScene(rentMenu); break;
            case 15: stage.setScene(rentAdd); break;
            case 16: stage.setScene(rentView); break;
            case 17: stage.setScene(rentFind); break;
            case 18: stage.setScene(rentDelete); break;
            case 19: stage.setScene(empMenu); break;
            case 20: stage.setScene(empAdd); break;
            case 21: stage.setScene(empView); break;
            case 22: stage.setScene(empFind); break;
            case 23: stage.setScene(empDelete); break;
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