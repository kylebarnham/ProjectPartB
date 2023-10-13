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
public class RentalDataHandler {
            private String fileName;
    private ArrayList<Rental> rentalList;

    public RentalDataHandler(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        //initialise rentalList ArrayList
        this.rentalList = new ArrayList<Rental>();
        //reading all saved rentals
        readDataFile();
    }
    //Private method for reading all saved members from the text file 
    //and uploading to the rentalList ArrayList
    //Not accessible to the external classes
    private void readDataFile() throws FileNotFoundException
    {
	try {
            Scanner in = new Scanner(new FileReader(fileName)); //open file
            String myEntry = "";  //hold whole line text
            
            int rentalID = 0;
            int customerID = 0;
            String rego = "";
            LocalDate rentalStart = LocalDate.now();
            LocalDate rentalEnd = LocalDate.now();
            boolean returned = false;
            boolean overdue = false;
            float totalCost = 0;     

            while (in.hasNextLine()) {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");

                while (st.hasMoreTokens()) {                    
                    rentalID = Integer.parseInt(st.nextToken());
                    customerID = Integer.parseInt(st.nextToken());
                    rego = st.nextToken();
                    rentalStart = LocalDate.parse(st.nextToken());
                    rentalEnd = LocalDate.parse(st.nextToken());
                    returned = Boolean.parseBoolean(st.nextToken());
                    overdue = Boolean.parseBoolean(st.nextToken());
                    totalCost = Float.parseFloat(st.nextToken());
                }

                    //creates student object
                    Rental r = new Rental(rentalID, customerID, rego, rentalStart, rentalEnd, returned, overdue, totalCost);
                    //add student object to arraylist
                    rentalList.add(r);  
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
       
            int totalNumbers = rentalList.size();
        
               
            for (int i = 0; i < totalNumbers; i++)
            {
                Rental curRental = rentalList.get(i);
                
                out.format("%s\n", curRental.toString());
            }            
            

            out.close();//close file
           } catch(SecurityException ex)  {
                
           }  catch(FileNotFoundException ex)   {
                
           }

   }//end of the SaveData method 
    
  // Method for adding a rental to the rental ArrayList
    public void addRental(Rental r)
    {
        rentalList.add(r); 
    }
    //method for updating a rental in the arraylist
    public void updateRental(int rentalID, Rental r)
    {
        int index = -1;
        
        int size = rentalList.size();
        
        for(int i = 0; i < size; i++) {
            Rental findRental = rentalList.get(i);
            if(findRental.getRentalID() == rentalID)
                index = i;
        }
        rentalList.set(index, r);             
    }
    //method for deleting a rental from the arraylist
    public void deleteRental(int rentalID)
    {
        int index = -1;
        
        int size = rentalList.size();
        
        for(int i = 0; i < size; i++) {
            Rental findRental = rentalList.get(i);
            if(findRental.getRentalID() == rentalID)
                index = i;
        }
        rentalList.remove(index);             
    }
    //int to find rental record
    public int findRentalRecord(int rentalID) {
        int index = -1;
        
        int size = rentalList.size();
        
        for(int i = 0; i < size; i++) {
            Rental findRental = rentalList.get(i);
            if(findRental.getRentalID() == rentalID)
                index = i;
        }
        return index;
    }
    //string to display searched rental details
    public String searchRental(int rentalID) {
        String searchRental = "";
        int index = -1;
        int size = rentalList.size();
        for(int i = 0; i < size; i++) {
            Rental findRental = rentalList.get(i);
            if(findRental.getRentalID() == rentalID)
                index = i;
        }
        if(index > -1) {
            rentalList.get(index);
            return searchRental + rentalList.get(index).appDisplay();
        }
        else {
            return searchRental + "No Rental record Found";
        }
    }
    //boolean to check if rental ID exists
    public boolean checkRentalExists(int rentalID) {
        int index = -1;
        int size = rentalList.size();
        for(int i = 0; i < size; i++) {
            Rental findRental = rentalList.get(i);
            if(findRental.getRentalID() == rentalID)
                index = i;
        }
        if(index > -1)
            return true;
        else
            return false;
    }
    //string to display all rental 
    public String getDisplayOutput()
    {  
        //string to store final output
        String output = "";
        //to store all rentals in a single string
        String listOfRentals = "";
         //get rental list size
        int size = rentalList.size();
        //if size is greater than 0 rentals found
        if (size > 0)  { 
            //for loop to get each element from rental list
            for (int i = 0; i < size; i++){
                //add rental details to string to string
                listOfRentals += rentalList.get(i).appDisplay() + "\n\n";
            }
        //return string with rental list and size
        return output + listOfRentals; 
        }
        else {
            //return string with no rental found
            return output + "No Customers found";
        }     
    }
}
