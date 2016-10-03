/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.services;

import amt.loginwebpages.model.UsersDatabase;

/**
 *
 * @author Antony
 */
public class LoginManager {
    
    
    public LoginManager() {
        
    }
    
    public boolean registerNewUser(String username, String password){
        
        return UsersDatabase.addNewUser(username, password);
        
    }

    public boolean isUsernameRegistered(String username){
        
        return UsersDatabase.isUsernameRegistered(username);
        
    }
    
    
    public boolean isUserValid(String username, String password){
        
        return UsersDatabase.isValidCredentials(username, password);   
        
    }
    
    
    
}
