/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpartb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Kyle
 */
public class VehicleDataHandler {
            private String fileName;
    private ArrayList<Vehicle> vehicleList;

    public VehicleDataHandler(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        //initialise memberList ArrayList
        this.vehicleList = new ArrayList<Vehicle>();
        //reading all saved members
        readDataFile();
    }
    //Private method for reading all saved members from the text file 
    //and uploading to the memberList ArrayList
    //Not accessible to the external classes
    private void readDataFile() throws FileNotFoundException
    {
	try {
            Scanner in = new Scanner(new FileReader(fileName)); //open file
            String myEntry = "";  //hold whole line text
            
            String rego = "";
            String make = "";
            String model = "";
            int year = 0;
            String colour = "";
            int odometer = 0;
            boolean manual = false;
            float costPerDay = 0;
            boolean available = false;  
            String bodyType = "";
            int passengersCar = 0;
            int passengersVan = 0;
            boolean wheelchairAccess = false;
            int seats = 0;
            String busType = "";
            

            while (in.hasNextLine()) {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");

                while (st.hasMoreTokens()) {                    
                    rego = st.nextToken();
                    make = st.nextToken();
                    model = st.nextToken();
                    year = Integer.parseInt(st.nextToken());                                     
                    colour = st.nextToken();
                    odometer = Integer.parseInt(st.nextToken());
                    manual = Boolean.parseBoolean(st.nextToken());
                    costPerDay = Float.parseFloat(st.nextToken());
                    available = Boolean.parseBoolean(st.nextToken());
                    bodyType = st.nextToken();
                    passengersCar = Integer.parseInt(st.nextToken());
                    passengersVan = Integer.parseInt(st.nextToken());
                    wheelchairAccess = Boolean.parseBoolean(st.nextToken());
                    seats = Integer.parseInt(st.nextToken());
                    busType = st.nextToken();
                }
                    if(passengersCar > 0) {
                        Vehicle v = new Car(rego, make, model, year, colour, odometer, manual, costPerDay, available, bodyType, passengersCar);
                        vehicleList.add(v);
                    }
                    else if(passengersVan > 0) {
                        Vehicle v = new Van(rego, make, model, year, colour, odometer, manual, costPerDay, available, passengersVan, wheelchairAccess);
                        vehicleList.add(v);
                    }
                    else {
                        Vehicle v = new Bus(rego, make, model, year, colour, odometer, manual, costPerDay, available, seats, busType);
                        vehicleList.add(v);
                    }
            }// end of while loop

            in.close();//close file
        } catch (ArrayIndexOutOfBoundsException ex) {
              
        } catch (FileNotFoundException ex) {
             
        }
     }//end of the readDataFile method
    
    
    //Method for saving all members from the memberList ArrayList to the text file
   public void saveData()
   {
        try
        {
            Formatter out = new Formatter(fileName);    //open file
       
            int totalNumbers = vehicleList.size();
        
               
            for (int i = 0; i < totalNumbers; i++)
            {
                Vehicle curVehicle = vehicleList.get(i);
                
                out.format("%s\n", curVehicle.toString());
            }            
            

            out.close();//close file
           } catch(SecurityException ex)  {
                
           }  catch(FileNotFoundException ex)   {
                
           }

   }//end of the SaveData method 
    
  // Method for adding a member to the member ArrayList
    public void addVehicle(Vehicle v)
    {
        vehicleList.add(v); 
    }
    //method to update vehicle in arraylist
    public void updateVehicle(String rego, Vehicle v)
    {
        int index = -1;
        
        int size = vehicleList.size();
        
        for(int i = 0; i < size; i++) {
            Vehicle findVehicle = vehicleList.get(i);
            if(findVehicle.getRego().equals(rego))
                index = i;
        }
        vehicleList.set(index, v);             
    }
    //method to delete vehicle in arraylist
    public void deleteVehicle(String rego)
    {
        int index = -1;
        
        int size = vehicleList.size();
        
        for(int i = 0; i < size; i++) {
            Vehicle findVehicle = vehicleList.get(i);
            if(findVehicle.getRego().equals(rego))
                index = i;
        }
        vehicleList.remove(index);             
    }
    //method to find vehicle
    public int findVehicleRecord(String rego) {
        int index = -1;
        
        int size = vehicleList.size();
        
        for(int i = 0; i < size; i++) {
            Vehicle findVehicle = vehicleList.get(i);
            if(findVehicle.getRego().equals(rego))
                index = i;
        }
        return index;
    }
    //method to display vehicle details
    public String searchVehicle(String rego) {
        String searchVehicle = "";
        int index = -1;
        int size = vehicleList.size();
        for(int i = 0; i < size; i++) {
            Vehicle findVehicle = vehicleList.get(i);
            if(findVehicle.getRego().equals(rego))
                index = i;
        }
        if(index > -1) {
            vehicleList.get(index);
            return searchVehicle + vehicleList.get(index).appDisplay();
        }
        else {
            return searchVehicle + "No Vehicle record Found";
        }
    }
    //boolean method to check if vehicle exists
    public boolean checkVehicleExists(String rego) {
        int index = -1;
        int size = vehicleList.size();
        for(int i = 0; i < size; i++) {
            Vehicle findVehicle = vehicleList.get(i);
            if(findVehicle.getRego().equals(rego))
                index = i;
        }
        if(index > -1)
            return true;
        else
            return false;
    }
    //method to display all vehicle details
    public String getDisplayOutput() {  
        //string to store final output
        String output = "";
        //to store all members in a single string
        String listOfVehicles = "";
         //get member list size
        int size = vehicleList.size();
        //if size is greater than 0 members found
        if (size > 0)  { 
            //for loop to get each element from member list
            for (int i = 0; i < size; i++){
                //add member details to string to string
                listOfVehicles += vehicleList.get(i).appDisplay() + "\n\n";
            }
        //return string with member list and size
        return output + listOfVehicles; 
        }
        else {
            //return string with no members found
            return output + "No Vehicles found";
        }     
    }  
    //method to get total cost of rental
    public float totalCost(String rego, int days) {
        int index = -1;
        float costOfVehicle = 0;
        float totalCost = 0;
        int size = vehicleList.size();
        for(int i = 0; i < size; i++) {
            Vehicle findVehicle = vehicleList.get(i);
            if(findVehicle.getRego().equals(rego))
                index = i;
        }
        if(index > -1) {
            //add vehicle cost
            costOfVehicle += vehicleList.get(index).getCostPerDay() * days;
        } 
        return totalCost + costOfVehicle;
    }
    //method to check if car is available
    public boolean isVehicleAvailable(String rego) {
        int index = -1;
        
        int size = vehicleList.size();
        
        for(int i = 0; i < size; i++) {
            Vehicle findVehicle = vehicleList.get(i);
            if(findVehicle.getRego().equals(rego))
                index = i;
        }
        if(vehicleList.get(index).isAvailable() == true)
            return true;
        else
            return false;
    }
    //method to check if vehicle is manual
    public boolean isVehicleManual(String rego) {
        int index = -1;
        
        int size = vehicleList.size();
        
        for(int i = 0; i < size; i++) {
            Vehicle findVehicle = vehicleList.get(i);
            if(findVehicle.getRego().equals(rego))
                index = i;
        }
        if(vehicleList.get(index).isManual() == true)
            return true;
        else
            return false;
    }
}
