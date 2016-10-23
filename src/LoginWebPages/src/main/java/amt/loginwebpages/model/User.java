package amt.loginwebpages.model;

/**
 *
 * This class implements the definition of a user
 * 
 * @author Antony Ciani & Thomas Hernandez
 */
public class User {
    
    private final String userName;
    private String password;
    private String firstName;
    private String lastName;
    
    
    // Based on database fields length
    public static final int MAX_USERNAME_LENGTH = 20;
    public static final int MAX_PASSWORD_LENGTH = 20;
    public static final int MAX_FIRSTNAME_LENGTH = 50;
    public static final int MAX_LASTNAME_LENGTH = 50;

    /**
     *
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public User(String username, String password, String firstName, String lastName) {
        this.userName = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *
     * @return username
     */
    public String getUsername() {
        return userName;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return firstname
     */
    public String getFirstname() {
        return firstName;
    }
    
    /**
     *
     * @return lastname
     */
    public String getLastname() {
        return lastName;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + userName + ", password=" + password + '}';
    }
    
    
}
