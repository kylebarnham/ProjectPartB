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
    
    private boolean boss;

    public Manager(boolean boss, boolean staff, int userID, String name, LocalDate birthDate, int age, String phoneNumber, String email, String password) {
        super(staff, userID, name, birthDate, age, phoneNumber, email, password);
        this.boss = boss;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }
    
    @Override
    public String toString() {
        return super.toString() + "," + isBoss();
    }
}
