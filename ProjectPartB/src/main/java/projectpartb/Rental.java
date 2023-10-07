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
    private LocalDate rentalStart;
    private LocalDate rentalEnd;
    private boolean returned;
    private boolean overdue;
    private float totalCost;

    public Rental(int rentalID, LocalDate rentalStart, LocalDate rentalEnd, boolean returned, boolean overdue, float totalCost) {
        this.rentalID = rentalID;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.returned = returned;
        this.overdue = overdue;
        this.totalCost = totalCost;
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
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

    @Override
    public String toString() {
        return String.format(getRentalID() + "," + getRentalStart() + "," + getRentalEnd() + "," + isReturned() + "," + isOverdue() + "," + getTotalCost());
    }
    
    
}
