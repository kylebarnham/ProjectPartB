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
public class Customer {
        
    private int userID;
    private String name;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private int licenseNumber;
    private LocalDate licenseExpiry;
    private boolean manualLicense;

    //constructor
    public Customer(int userID, String name, LocalDate birthDate, String phoneNumber, String email, int licenseNumber, LocalDate licenseExpiry, boolean manualLicense) {
        this.userID = userID;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.licenseNumber = licenseNumber;
        this.licenseExpiry = licenseExpiry;
        this.manualLicense = manualLicense;
    }

    //getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getLicenseExpiry() {
        return licenseExpiry;
    }

    public void setLicenseExpiry(LocalDate licenseExpiry) {
        this.licenseExpiry = licenseExpiry;
    }

    public boolean isManualLicense() {
        return manualLicense;
    }

    public void setManualLicense(boolean manualLicense) {
        this.manualLicense = manualLicense;
    }
    
    //toString method to format data for customers.txt
    @Override
    public String toString() {
        return String.format(getUserID() + "," + getName() + "," + getBirthDate() + "," + getPhoneNumber() + "," + getEmail() + "," + getLicenseNumber() + "," + getLicenseExpiry() + "," + isManualLicense());
    }
    
    //appdisplay string to format data for app
    public String appDisplay() {
        String result = manualLicense ? "Yes" : "No";
        return String.format("Customer ID: " + getUserID() + "\nName: " + getName() + "\nDate of Birth: " + getBirthDate() + "\nPhone Number: " + getPhoneNumber() + "\nEmail: " + getEmail() + "\nLicense Number: " + getLicenseNumber() + "\nLicense Expiry: " + getLicenseExpiry() + "\nManual License: " + result);
    }
}

