/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package humanresourcemanagement;

import java.io.*;
import java.util.*;

/**
 *
 * @author aryanarora
 */
public class Driver {

    /**
     */
    
    public static void initialize(){
        ArrayList<Department> departments = new ArrayList<Department>();
        Teacher eng_dean = new Teacher("John Smith", 35, "Male", "123 Main St, Anytown USA", "(624) 555-1212", 12345, "Computer Science", 3, true, true, 32);
        Teacher arts_dean = new Teacher("Sarah Johnson", 42, "Female", "456 Elm St, Anytown USA", "(438) 555-2323", 67890, "International Law", 3, true, true, 32);
        Teacher biz_dean = new Teacher("David Lee", 28, "Male", "789 Oak St, Anytown USA", "(514) 555-3434", 24680, "Accounting", 3, true, true, 32);
        
        Department one = new Department(1, "Engineering", eng_dean);
        Department two = new Department(2, "Liberal Arts", arts_dean);
        Department three = new Department(3, "Business", biz_dean);
        
        departments.add(one);
        departments.add(two);
        departments.add(three);
        saveProgress(departments);
    }
    
    /**
     *
     * @param departments
     */
    public static void saveProgress(ArrayList<Department> departments){
        try {
            FileOutputStream fileOut = new FileOutputStream("data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(int i = 0; i < departments.size(); i++){
                out.writeObject(departments.get(i));
            }
            out.close();
            fileOut.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
        
    /**
     *
     * @return
     */
    public static ArrayList<Department> readProgress(){
        ArrayList<Department> departments = new ArrayList<Department>();
        try {
            FileInputStream fileIn = new FileInputStream("data.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0) {
                departments.add(((Department)in.readObject()));
            }
            in.close();
            fileIn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return departments;
    }
    
    /**
     *
     * @return
     */
    public static Teacher newTeacher(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Gender (Male/Female): ");
            sc.nextLine();
            String gender = sc.nextLine();
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();
            System.out.print("Assign ID Number: ");
            int id = sc.nextInt();
            System.out.print("Enter Specialty: ");
            sc.nextLine();
            String specialty = sc.nextLine();
            System.out.println("(1 - Bachelors, 2 - Masters, 3 - PhD");
            System.out.print("Enter Degree: ");
            int degree = sc.nextInt();
            System.out.print("Is Dean? (true/false): ");
            boolean dean = sc.nextBoolean();
            System.out.print("Is Full-Time? (true/false): ");
            boolean fullTime = sc.nextBoolean();
            int hoursWorked = 0;
            if(!fullTime){
                System.out.print("Enter Hours Worked: ");
                hoursWorked = sc.nextInt();
            } else {
                hoursWorked = 32;
            }
            
            return new Teacher(name, age, gender, address, phone, id, specialty, degree, dean, fullTime, hoursWorked);
            
        } catch (InputMismatchException e){
            return null;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public static Staff newStaff(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Gender (Male/Female): ");
            sc.nextLine();
            String gender = sc.nextLine();
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();
            System.out.print("Enter Duty: ");
            String duty = sc.nextLine();
            int workload = 41;
            while(workload > 40){
                System.out.print("Enter Workload: ");
                workload = sc.nextInt();
                if(workload > 40){
                    System.out.println("Staff Workload cannot exceed 40 hrs");
                }
            }

            return new Staff(name, age, gender, address, phone, duty, workload);
            
        } 
        catch (InputMismatchException e){
            return null;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        return new Staff();
    }
    
    /**
     *
     * @param args
     * @throws MemberExistsException
     * @throws InvalidRegistrationException
     */
    public static void main(String[] args) throws MemberExistsException, InvalidRegistrationException {

//        initialize();
//        
//        Scanner sc = new Scanner(System.in);
//        
        MainFrame myFrame = new MainFrame();
        myFrame.setVisible(true);
//        
//
//        ArrayList<Department> departments = readProgress();
//        //System.out.println(departments);
//        
//        System.out.println("\t\tHUMAN RESOURCE MANAGEMENT SYSTEM");
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("");
//        System.out.println("[1] Add New Teacher");
//        System.out.println("[2] Add New Staff");
//        System.out.print("\nChoice: ");
//        int choice = sc.nextInt();
//        
//        if(choice == 1){
//            try 
//            {
//                Teacher teacher = newTeacher();
//                if(teacher == null){
//                    throw new InvalidRegistrationException();
//                }
//                System.out.println("Choose Department for Teacher");
//                for(int i = 0; i < departments.size(); i++){
//                    System.out.printf("[%d] %s\n", i+1, departments.get(i).getName());
//                }
//                System.out.print("Choice: ");
//                choice = sc.nextInt();
//                for(int i = 0; i < departments.size(); i++){
//                    if(departments.get(choice).getTeachers().get(i).equals(teacher)){
//                        throw new MemberExistsException();
//                    }
//                }
//                departments.get(choice).addTeacher(teacher);
//                System.out.println(departments.get(choice).toString());
//            }
//            catch (InvalidRegistrationException e)
//            {
//                System.out.println(e);
//            }
//            catch (MemberExistsException e)
//            {
//                System.out.println(e);
//            }
//            catch (Exception e) 
//            {
//                System.out.println(e);
//            }
//            
//        } else if (choice == 2){
//            try {
//                Staff staff = newStaff();
//                if(staff == null){
//                    throw new InvalidRegistrationException();
//                }
//                System.out.println("Choose Department for Staff");
//                for(int i = 0; i < departments.size(); i++){
//                    System.out.printf("[%d] %s\n", i+1, departments.get(i).getName());
//                }
//                System.out.print("Choice: ");
//                choice = sc.nextInt();
//                for(int i = 0; i < departments.size(); i++){
//                    if(departments.get(choice).getStaff().get(i).equals(staff)){
//                        throw new MemberExistsException();
//                    }
//                }
//                departments.get(choice).addStaff(staff);
//                System.out.println(departments.get(choice).toString());
//            }
//            catch (InvalidRegistrationException e)
//            {
//                System.out.println(e);
//            }
//            catch (MemberExistsException e)
//            {
//                System.out.println(e);
//            }
//            catch (Exception e){
//                System.out.println(e);
//            }
//        }
//        
//        saveProgress(departments);
//        
    }
    
}
