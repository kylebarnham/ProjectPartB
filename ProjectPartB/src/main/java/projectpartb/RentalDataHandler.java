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
        //initialise memberList ArrayList
        this.rentalList = new ArrayList<Rental>();
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
            
            int rentalID = 0;
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
                    rentalStart = LocalDate.parse(st.nextToken());
                    rentalEnd = LocalDate.parse(st.nextToken());
                    returned = Boolean.parseBoolean(st.nextToken());
                    overdue = Boolean.parseBoolean(st.nextToken());
                    totalCost = Float.parseFloat(st.nextToken());
                }

                    //creates student object
                    Rental r = new Rental(rentalID, rentalStart, rentalEnd, returned, overdue, totalCost);
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
    
  // Method for adding a member to the member ArrayList
    public void addRental(Rental r)
    {
        rentalList.add(r); 
    }
}
