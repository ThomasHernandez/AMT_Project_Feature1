/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.services;

import amt.loginwebpages.model.User;
import amt.loginwebpages.model.UsersDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Antony
 */
@Singleton
public class LoginManager implements LoginManagerLocal {
    
    private HashMap<String,User> users = new HashMap<>();
    
    
    public LoginManager() {
        
    }
    
    public boolean isUsernameRegistered(User user){
        
        return users.containsKey(user.getUsername());
        
    }
    
    public boolean addNewUser(User user){
              
        if(!isUsernameRegistered(user)){
            
            users.put(user.getUsername(), user);
            return true;
        }
        else{
            
            return false;
            
        }
        
    }
    
    public boolean isValidCredentials(User user, String testPassword){
        
        if(isUsernameRegistered(user)){
            
            return user.getPassword().equals(testPassword);
            
        }
        else{
            
            return false;
        }
        
    }
  
    public User loadUser(String userName) {
        return users.get(userName);
  }
    
    public List<User> findAllUsers() {
        return new ArrayList(users.values());
  }
    
    
    
}
