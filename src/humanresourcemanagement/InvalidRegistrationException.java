/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresourcemanagement;

public class InvalidRegistrationException extends Exception {
    
    public InvalidRegistrationException(){
        super("ERR: Invalid Registration!");
    }
    
    public InvalidRegistrationException(String err){
        super(err);
    }
    
}
