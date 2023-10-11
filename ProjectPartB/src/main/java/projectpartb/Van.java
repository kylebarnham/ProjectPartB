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
    
    private int passengersVan;
    private boolean wheelchairAccess;

    public Van(String rego, String make, String model, int year, String colour, int odometer, boolean manual, float costPerDay, boolean available, int passengersVan, boolean wheelchairAccess) {
        super(rego, make, model, year, colour, odometer, manual, costPerDay, available);
        this.passengersVan = passengersVan;
        this.wheelchairAccess = wheelchairAccess;
    }

    public int getPassengersVan() {
        return passengersVan;
    }

    public void setPassengers(int passengers) {
        this.passengersVan = passengers;
    }

    public boolean isWheelchairAccess() {
        return wheelchairAccess;
    }

    public void setWheelchairAccess(boolean wheelchairAccess) {
        this.wheelchairAccess = wheelchairAccess;
    }

    @Override
    public String toString() {
        return super.toString() + "," + getPassengersVan() + "," + isWheelchairAccess();
    }
    
    
}
