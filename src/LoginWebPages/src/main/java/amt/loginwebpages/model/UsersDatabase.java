/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.model;

import java.util.HashMap;

/**
 *
 * @author Antony
 */
public class UsersDatabase {
    
    private HashMap<String,String> users;

    public UsersDatabase() {
        this.users = new HashMap<>();
    }
    
    public boolean isUsernameRegistered(String username){
        
        return users.containsKey(username);
        
    }
    
    public boolean addNewUser(String username, String password){
        
        if(username.isEmpty() || password.isEmpty()){
            
            return false;
            
        }
        
        if(!isUsernameRegistered(username)){
            
            users.put(username, password);
            return true;
        }
        else{
            
            return false;
            
        }
        
    }
    
    public boolean isValidCredentials(String username, String password){
        
        if(isUsernameRegistered(username)){
            
            return users.get(username).equals(password);
            
        }
        else{
            
            return false;
        }
        
        
    }
    
    
}
