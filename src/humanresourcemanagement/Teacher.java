/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresourcemanagement;

import java.io.Serializable;
import java.util.Objects;

public class Teacher extends Person implements PayRoll, Serializable {
    
    private int id;
    private String specialty;
    private int degree;
    private boolean dean;
    private boolean fullTime;
    private int hoursWorked;
    
    public Teacher(){
        super();
        specialty = "";
        degree = 0;
        dean = false;
        fullTime = false;
        hoursWorked = 0;
    }
    
    public Teacher(String name, int age, String gender, String address, String phone, int id, String specialty, int degree, boolean dean, boolean fullTime, int hoursWorked){
        super(name, age, gender, address, phone);
        this.id = id;
        this.specialty = specialty;
        this.degree = degree;
        this.dean = dean;
        this.fullTime = fullTime;
        if(fullTime == true){
            this.hoursWorked = 32;
        } else {
            this.hoursWorked = hoursWorked;
        }
    }
    
    public int getDegreeRate(){
        return switch (degree) {
            case 1 -> 42;
            case 2 -> 82;
            case 3 -> 112;
            default -> 0;
        };
    }
    
    @Override
    public String defineCategory(){
        return this.fullTime ? "Full-Time Teacher" : "Part-Time Teacher";
    }
    
    @Override
    public double ComputePayRoll(){
        return this.fullTime ? (32 * this.getDegreeRate() * 2) * 0.85 : (hoursWorked * this.getDegreeRate() * 2) * 0.76;
    }
    
    public String display(){
        String display = super.display();
        String degree_name = "";
        if(degree == 1){
            degree_name = "Bachelors";
        } else if (degree == 2){
            degree_name = "Masters";
        } else if (degree == 3){
            degree_name = "Doctorate (PhD)";
        }
        display += "ID: " + id + "<br>";
        display += "Specialty: " + specialty + "<br>";
        display += "Degree: " + degree_name + "<br>";
        if(!dean){
            display += "Employment: " + (fullTime ? "Full Time" : "Part Time") + "<br>";
            display += fullTime ? "Hours Worked: 32 <br>" : ("Hours Worked: " + hoursWorked) + "<br>";
        }
        display += "PayRoll: " + String.format("$%.2f", this.ComputePayRoll());
        
        return display;
    }
    

    @Override
    public String toString() {
        return super.toString() +  ", type=teacher, id=" + id + ", specialty=" + specialty + ", degree=" + degree + ", dean=" + dean + ", fullTime=" + fullTime + ", hoursWorked=" + hoursWorked + '}';
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
        final Teacher other = (Teacher) obj;
        if (this.degree != other.degree) {
            return false;
        }
        if (this.dean != other.dean) {
            return false;
        }
        return Objects.equals(this.specialty, other.specialty);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public boolean isDean() {
        return dean;
    }

    public void setDean(boolean dean) {
        this.dean = dean;
    }

}
