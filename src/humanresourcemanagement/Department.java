/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresourcemanagement;
import java.io.Serializable;
import java.util.*;

public class Department implements Serializable {
    
    private int id;
    private String name;
    private Teacher dean;
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Staff> staff = new ArrayList<Staff>();

    public Department(int id, String name, Teacher dean) {
        this.id = id;
        this.name = name;
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + ", dean=" + dean + ", teachers=" + teachers + ", staff=" + staff + '}';
    }
    
    public String display(){
        String display = "<html>";
        display += "<b>Dean</b><br>";
        display += dean.display() + "<br><br>";
        display += "<b>Teachers</b><br>";
        //display += teachers + "<br><br>";
        for(Teacher i : teachers){
            display += i.display();
            display += "<br><br>";
        }
        display += "<b>Staff</b><br>";
        for(Staff i : staff){
            display += i.display();
            display += "<br><br>";
        }
        display += "</html>";
        return display;
    }
    
    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }
    
    public void addStaff(Staff staff){
        this.staff.add(staff);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Teacher getDean() {
        return dean;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }
    
    
    
}
