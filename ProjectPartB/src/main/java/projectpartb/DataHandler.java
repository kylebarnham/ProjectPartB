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
public class DataHandler {
    
    private String fileName;
    private ArrayList<Customer> customerList;

    public DataHandler(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        //initialise memberList ArrayList
        this.customerList = new ArrayList<Customer>();
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
            
            int userID = 0;
            String name = "";
            LocalDate birthDate = LocalDate.now();
            String phoneNumber = "";
            String email = "";
            int licenseNumber = 0;
            LocalDate licenseExpiry = LocalDate.now();
            boolean manualLicense = false;         

            while (in.hasNextLine()) {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");

                while (st.hasMoreTokens()) {                    
                    userID = Integer.parseInt(st.nextToken());
                    name = st.nextToken();
                    birthDate = LocalDate.parse(st.nextToken());
                    phoneNumber = st.nextToken();                                     
                    email = st.nextToken();
                    licenseNumber = Integer.parseInt(st.nextToken());
                    licenseExpiry = LocalDate.parse(st.nextToken());
                    manualLicense = Boolean.parseBoolean(st.nextToken());
                }

                    //creates student object
                    Customer c = new Customer(userID, name, birthDate, phoneNumber, email, licenseNumber, licenseExpiry, manualLicense);
                    //add student object to arraylist
                    customerList.add(c);  
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
       
            int totalNumbers = customerList.size();
        
               
            for (int i = 0; i < totalNumbers; i++)
            {
                Customer curCustomer = customerList.get(i);
                
                out.format("%s\n", curCustomer.toString());
            }            
            

            out.close();//close file
           } catch(SecurityException ex)  {
                
           }  catch(FileNotFoundException ex)   {
                
           }

   }//end of the SaveData method 
    
  // Method for adding a member to the member ArrayList
    public void addMember(Customer u)
    {
        customerList.add(u); 
    }
}
