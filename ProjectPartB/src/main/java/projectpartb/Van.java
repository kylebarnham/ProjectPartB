/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpartb;

/**
 *
 * @author Kyle
 */
public class Van extends Vehicle {
    
    private int passengers;
    private boolean wheelchairAccess;

    public Van(int passengers, boolean wheelchairAccess, String rego, String make, String model, int year, String colour, int odometer, boolean manual, float costPerDay, boolean available) {
        super(rego, make, model, year, colour, odometer, manual, costPerDay, available);
        this.passengers = passengers;
        this.wheelchairAccess = wheelchairAccess;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public boolean isWheelchairAccess() {
        return wheelchairAccess;
    }

    public void setWheelchairAccess(boolean wheelchairAccess) {
        this.wheelchairAccess = wheelchairAccess;
    }

    @Override
    public String toString() {
        return super.toString() + "," + getPassengers() + "," + isWheelchairAccess();
    }
    
    
}
