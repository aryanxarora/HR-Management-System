/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresourcemanagement;

import java.io.Serializable;
import java.util.Objects;

public class Staff extends Person implements PayRoll, Serializable {
    
    private String duty;
    private int workload;
    
    public Staff(){
        super();
        duty = "";
        workload = 0;
    }
    
    public Staff(String name, int age, String gender, String address, String phone, String duty, int workload) {
        super(name, age, gender, address, phone);
        this.duty = duty;
        this.workload = workload;
    }
    
    @Override
    public String defineCategory(){
        return "Staff";
    }
    
    @Override
    public double ComputePayRoll(){
        return (workload * 32 * 2) * 0.75;
    }
    
    public String display(){
        String display = super.display();
        display += "Duty: " + duty + "<br>";
        display += "Workload: " + workload + "<br>";
        display += "PayRoll: " + String.format("$%.2f", this.ComputePayRoll());
        return display;
    }

    @Override
    public String toString() {
        return super.toString() + " Staff{" + "duty=" + duty + ", workload=" + workload + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if(!super.equals(obj)){
            return false;
        }
        final Staff other = (Staff) obj;
        if (this.workload != other.workload) {
            return false;
        }
        return Objects.equals(this.duty, other.duty);
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    
}
