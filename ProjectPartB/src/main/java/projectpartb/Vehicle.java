/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpartb;

/**
 *
 * @author Kyle
 */
public class Vehicle {
    
    private String rego;
    private String make;
    private String model;
    private int year;
    private String colour;
    private int odometer;
    private boolean manual;
    private float costPerDay;
    private boolean available;

    public Vehicle(String rego, String make, String model, int year, String colour, int odometer, boolean manual, float costPerDay, boolean available) {
        this.rego = rego;
        this.make = make;
        this.model = model;
        this.year = year;
        this.colour = colour;
        this.odometer = odometer;
        this.manual = manual;
        this.costPerDay = costPerDay;
        this.available = available;
    }

    public String getRego() {
        return rego;
    }

    public void setRego(String rego) {
        this.rego = rego;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public float getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(float costPerDay) {
        this.costPerDay = costPerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format(getRego() + "," + getMake() + "," + getModel() + "," + getYear()  + "," + getOdometer() + "," + isManual()  + "," + getCostPerDay() + "," + isAvailable());
    }
    
    public String appDisplay() {
        String result1 = manual ? "Yes" : "No";
        String result2 = available ? "Yes" : "No";
        return String.format("Registration: " + getRego() + "\nMake: " + getMake() + "\nModel: " + getModel() + "\nYear: " + getYear() + "\nOdometer: " + getOdometer() + "\nManual: " + result1 + "\nCost per Day: " + getCostPerDay() + "\nAvailable: " + result2);
    }
}
