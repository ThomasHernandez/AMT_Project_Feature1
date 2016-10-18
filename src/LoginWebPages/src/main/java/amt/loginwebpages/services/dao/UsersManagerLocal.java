package amt.loginwebpages.services.dao;

import amt.loginwebpages.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomas Hernandez
 * @author Antony Ciani
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
     * @param user
     */
    public void updateUser(User user);
  
    /**
     *
     * @param user
     * @return
     */
    public boolean addNewUser(User user);

    /**
     *
     * @param user
     * @param testPassword
     * @return
     */
    public boolean isValidCredentials(User user, String testPassword);


    
}