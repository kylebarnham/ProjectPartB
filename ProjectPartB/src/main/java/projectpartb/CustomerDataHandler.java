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
public class CustomerDataHandler {
    
        private String fileName;
    private ArrayList<Customer> customerList;

    public CustomerDataHandler(String fileName) throws FileNotFoundException {
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
    public void addCustomer(Customer u)
    {
        customerList.add(u); 
    }
    //method to update existing customer in arraylist
    public void updateCustomer(int userID, Customer u)
    {
        int index = -1;
        
        int size = customerList.size();
        
        for(int i = 0; i < size; i++) {
            Customer findCustomer = customerList.get(i);
            if(findCustomer.getUserID() == userID)
                index = i;
        }
        customerList.set(index, u);             
    }
    //method to delete existing customer in arraylist
    public void deleteCustomer(int userID)
    {
        int index = -1;
        
        int size = customerList.size();
        
        for(int i = 0; i < size; i++) {
            Customer findCustomer = customerList.get(i);
            if(findCustomer.getUserID() == userID)
                index = i;
        }
        customerList.remove(index);             
    }
    //method to find customer
    public int findCustomerRecord(int userID) {
        int index = -1;
        
        int size = customerList.size();
        
        for(int i = 0; i < size; i++) {
            Customer findCustomer = customerList.get(i);
            if(findCustomer.getUserID() == userID)
                index = i;
        }
        return index;
    }
    //method to display customer record if found
    public String searchCustomer(int userID) {
        String searchCustomer = "";
        int index = -1;
        int size = customerList.size();
        for(int i = 0; i < size; i++) {
            Customer findCustomer = customerList.get(i);
            if(findCustomer.getUserID() == userID)
                index = i;
        }
        if(index > -1) {
            customerList.get(index);
            return searchCustomer + customerList.get(index).appDisplay();
        }
        else {
            return searchCustomer + "No Customer record found";
        }
    }
    //method to check if customer exists
    public boolean checkCustomerExists(int userID) {
        int index = -1;
        int size = customerList.size();
        for(int i = 0; i < size; i++) {
            Customer findCustomer = customerList.get(i);
            if(findCustomer.getUserID() == userID)
                index = i;
        }
        //if index is greater than -1
        if(index > -1)
            //customer exists return true
            return true;
        else
            return false;
    }
    //method to display a list of all customers
    public String getDisplayOutput()
    {  
        //string to store final output
        String output = "";
        //to store all members in a single string
        String listOfCustomers = "";
         //get member list size
        int size = customerList.size();
        //if size is greater than 0 members found
        if (size > 0)  { 
            System.out.println("Members found!");
            //for loop to get each element from member list
            for (int i = 0; i < size; i++){
                //add member details to string to string
                listOfCustomers += customerList.get(i).appDisplay() + "\n\n";
            }
        //return string with member list and size
        return output + listOfCustomers; 
        }
        else {
            //return string with no members found
            return output + "No Customers found";
        }     
    }     
    //method to check if customer has manual license
    public boolean checkManualLicense(int userID) {
        int index = -1;
        int size = customerList.size();
        for(int i = 0; i < size; i++) {
            Customer findCustomer = customerList.get(i);
            if(findCustomer.getUserID() == userID)
                index = i;
        }
        //check if customer has manual license and return true if true
        if(customerList.get(index).isManualLicense() == true)
            return true;
        else
            return false;
    }
}
