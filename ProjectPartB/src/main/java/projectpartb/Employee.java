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
public class Employee extends User {
    
    private boolean staff;

    public Employee(boolean staff, int userID, String name, LocalDate birthDate, int age, String phoneNumber, String email, String password) {
        super(userID, name, birthDate, age, phoneNumber, email, password);
        this.staff = staff;
    }

    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }
    
    @Override
    public String toString() {
        return super.toString() + "," + isStaff();
    }
}
