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

    public Manager(int userID, String name, LocalDate birthDate, String phoneNumber, String email, String password, boolean staff, boolean boss) {
        super(userID, name, birthDate, phoneNumber, email, password, staff);
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
