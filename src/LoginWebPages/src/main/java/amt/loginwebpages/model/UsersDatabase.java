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
    
    private static HashMap<String,String> USERS_INSTANCE = new HashMap<>();

    private UsersDatabase() {
        
    }
    
    public static boolean isUsernameRegistered(String username){
        
        return USERS_INSTANCE.containsKey(username);
        
    }
    
    public static boolean addNewUser(String username, String password){
        
        if(username.isEmpty() || password.isEmpty()){
            
            return false;
            
        }
        
        if(!isUsernameRegistered(username)){
            
            USERS_INSTANCE.put(username, password);
            return true;
        }
        else{
            
            return false;
            
        }
        
    }
    
    public static boolean isValidCredentials(String username, String password){
        
        if(isUsernameRegistered(username)){
            
            return USERS_INSTANCE.get(username).equals(password);
            
        }
        else{
            
            return false;
        }
        
    }

    
    
}
