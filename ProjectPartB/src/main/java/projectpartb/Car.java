/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpartb;

/**
 *
 * @author Kyle
 */
public class Car extends Vehicle {
    
    private String bodyType;
    private int passengersCar;

    //constructor
    public Car(String rego, String make, String model, int year, String colour, int odometer, boolean manual, float costPerDay, boolean available, String bodyType, int passengersCar) {
        super(rego, make, model, year, colour, odometer, manual, costPerDay, available);
        this.bodyType = bodyType;
        this.passengersCar = passengersCar;
    }
    
    //getters and setters
    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getPassengersCar() {
        return passengersCar;
    }

    public void setPassengers(int passengersCar) {
        this.passengersCar = passengersCar;
    }
    
    //toString used to format data for vehicle.txt
    @Override
    public String toString() {
        return super.toString() + "," + getBodyType() + "," + getPassengersCar() + "," + 0 + "," + 0 + "," + 0 + "," + 0;
    }
    
    //appdisplay used to format data for app
    @Override
    public String appDisplay() {
        return super.appDisplay() + "\nBody Type: " + getBodyType() + "\nPassengers: " + getPassengersCar();
    }
}
