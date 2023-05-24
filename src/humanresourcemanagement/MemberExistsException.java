/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humanresourcemanagement;

public class MemberExistsException extends Exception {
    
    public MemberExistsException(){
        super("ERR: Member already exists in the department!");
    }
    
    public MemberExistsException(String err){
        super(err);
    }
    
}
