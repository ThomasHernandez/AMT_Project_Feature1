package amt.loginwebpages.services.dao;

import amt.loginwebpages.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface to interact with a data source storing users
 * 
 * @author Thomas Hernandez
 * @author Antony Ciani
 * @see User
 */

@Local
public interface UsersManagerLocal {
    
    /**
     * Returns a User object with the specified username
     *
     * @param userName
     * @return User object if found, null otherwise
     */
    public User findUser(String userName);
 
    /**
     *  Returns all the Users in the database
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
     * Store a new User in the database if the username doesnt exist already
     * 
     * @param user
     * @return true if User added, false otherwise
     */
    public boolean addNewUser(User user);

    /**
     * Check the validity of pair username-password to allow simple authentication
     * 
     * @param user
     * @param testPassword
     * @return true if valid pair of credentials, false otherwise
     */
    public boolean isValidCredentials(User user, String testPassword);


    
}
