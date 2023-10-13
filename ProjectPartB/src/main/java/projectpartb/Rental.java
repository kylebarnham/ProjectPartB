/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpartb;

import java.time.LocalDate;

/**
 *
 * @author Kyle
 */
public class Rental {
        
    private int rentalID;
    private int customerID;
    private String rego;
    private LocalDate rentalStart;
    private LocalDate rentalEnd;
    private boolean returned;
    private boolean overdue;
    private float totalCost;

    //constructor
    public Rental(int rentalID, int customerID, String rego, LocalDate rentalStart, LocalDate rentalEnd, boolean returned, boolean overdue, float totalCost) {
        this.rentalID = rentalID;
        this.customerID = customerID;
        this.rego = rego;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.returned = returned;
        this.overdue = overdue;
        this.totalCost = totalCost;
    }

    //getters and setters
    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getRego() {
        return rego;
    }

    public void setRego(String rego) {
        this.rego = rego;
    }

    public LocalDate getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(LocalDate rentalStart) {
        this.rentalStart = rentalStart;
    }

    public LocalDate getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(LocalDate rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    //toString used to format data for rentals.txt
    @Override
    public String toString() {
        return String.format(getRentalID() + "," + getCustomerID() + "," + getRego() + "," + getRentalStart() + "," + getRentalEnd() + "," + isReturned() + "," + isOverdue() + "," + getTotalCost());
    }
    
    //appdisplay used to format data for app
    public String appDisplay() {
        String result1 = returned ? "Yes" : "No";
        String result2 = overdue ? "Yes" : "No";
        return String.format("Rental ID: " + getRentalID() + "\nCustomer ID" + getCustomerID() + "\nRegistration Number: " + getRego() + "\nRental Start: " + getRentalStart() + "\nRental End: " + getRentalEnd() + "\nReturned: " + isReturned() + "\nOverdue: " + isOverdue() + "Total Cost: $" + getTotalCost());
    }
}
