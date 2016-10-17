/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.rest.dto;

/**
 *
 * @author Thomas
 */
public class UpdateUserDTO {
    
    private String firstName;
    private String lastName;
    private String password;

    public UpdateUserDTO(){

    } 

    public String getFirstname() { 
        return firstName; 
    }

    public String getLastname() { 
        return lastName; 
    }

    public String getPassword() {
        return password;
    }
    
    
    public void setFirstname(String firstname) { 
        this.firstName = firstname; 
    }

    public void setLastname(String lastname) { 
        this.lastName = lastname; 
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
