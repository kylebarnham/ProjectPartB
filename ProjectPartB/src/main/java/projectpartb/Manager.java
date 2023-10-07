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
public class Manager extends Employee {
    
    private boolean manager;

    public Manager(boolean manager, boolean staff, int userID, String name, LocalDate birthDate, int age, String phoneNumber, String email, String password) {
        super(staff, userID, name, birthDate, age, phoneNumber, email, password);
        this.manager = manager;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }
    
    @Override
    public String toString() {
        return super.toString() + "," + isManager();
    }
}
