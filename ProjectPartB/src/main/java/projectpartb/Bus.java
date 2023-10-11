/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpartb;

/**
 *
 * @author Kyle
 */
public class Bus extends Vehicle {
    
    private int seats;
    private String busType;

    public Bus(String rego, String make, String model, int year, String colour, int odometer, boolean manual, float costPerDay, boolean available, int seats, String busType) {
        super(rego, make, model, year, colour, odometer, manual, costPerDay, available);
        this.seats = seats;
        this.busType = busType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    @Override
    public String toString() {
        return super.toString() + "," + getSeats() + "," + getBusType();
    }
    
}
