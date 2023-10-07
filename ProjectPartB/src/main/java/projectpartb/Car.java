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
    private int passengers;

    public Car(String bodyType, int passengers, String rego, String make, String model, int year, String colour, int odometer, boolean manual, float costPerDay, boolean available) {
        super(rego, make, model, year, colour, odometer, manual, costPerDay, available);
        this.bodyType = bodyType;
        this.passengers = passengers;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return super.toString() + "," + getBodyType() + "," + getPassengers();
    }
    
    
}
