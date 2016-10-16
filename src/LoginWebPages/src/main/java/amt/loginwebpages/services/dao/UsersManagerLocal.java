/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.services.dao;

import amt.loginwebpages.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomas
 * @author Antony
 */

@Local
public interface UsersManagerLocal {
    
    /**
     * Returns a User object with the specified username
     *
     * 
     * @param userName
     * @return User object if found null otherwise
     */
    public User findUser(String userName);
 
    /**
     *  Returns all the User in the database
     * 
     * @return List of all users in the database
     */
    public List<User> findAllUsers(); 

    /**
     * Deletes the user with the specified username
     * 
     * @param userName
     */
    public void deleteUser(String userName);

    /**
     * Update the user with specified username's field with the non empty other fields
     * 
     * @param userNameToUpdate
     * @param newPassword
     * @param newFirstName
     * @param newLastName
     */
    public void updateUser(String userNameToUpdate, String newPassword, String newFirstName, String newLastName);
  
  
    
}
