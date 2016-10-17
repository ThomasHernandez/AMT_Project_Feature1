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
public class UserDTONoPsw {

    
    private String userName;
    private String firstName;
    private String lastName;

    public UserDTONoPsw() {
    }

    public UserDTONoPsw(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return userName;
    }
    
    public String getFirstname() {
        return firstName;
    }
    
    public String getLastname() {
        return lastName;
    }
   
    public void setUsername(String username) {
        this.userName = username;
    }
    
    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    
}

