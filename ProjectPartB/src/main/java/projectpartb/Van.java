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

    //constructor
    public Van(String rego, String make, String model, int year, String colour, int odometer, boolean manual, float costPerDay, boolean available, int passengersVan, boolean wheelchairAccess) {
        super(rego, make, model, year, colour, odometer, manual, costPerDay, available);
        this.passengersVan = passengersVan;
        this.wheelchairAccess = wheelchairAccess;
    }

    //getters and setters
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

    //toString used to format data for vehicle.txt
    @Override
    public String toString() {
        return super.toString() + "," + 0 + "," + 0 + "," + getPassengersVan() + "," + isWheelchairAccess() + "," + 0 + "," + 0;
    }
    
    //appdisplay used to format data for app
    @Override
    public String appDisplay() {
        String result = wheelchairAccess ? "Yes" : "No";
        return super.appDisplay() + "\nPassengers: " + getPassengersVan() + "\nWheelchair Access: " + result;
    }
    
}
