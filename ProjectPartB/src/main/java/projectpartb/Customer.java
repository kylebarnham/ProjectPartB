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
public class Customer extends User {
    
    private int licenseNumber;
    private LocalDate licenseExpiry;
    private boolean manualLicense;

    public Customer(int licenseNumber, LocalDate licenseExpiry, boolean manualLicense, int userID, String name, LocalDate birthDate, int age, String phoneNumber, String email, String password) {
        super(userID, name, birthDate, age, phoneNumber, email, password);
        this.licenseNumber = licenseNumber;
        this.licenseExpiry = licenseExpiry;
        this.manualLicense = manualLicense;
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
    
    @Override
    public String toString() {
        return super.toString() + "," + getLicenseNumber() + "," + getLicenseExpiry() + "," + isManualLicense();
    }
    
}
