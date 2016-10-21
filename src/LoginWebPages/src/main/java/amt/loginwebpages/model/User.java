package amt.loginwebpages.model;

/**
 *
 * @author Antony Ciani
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
     * @return
     */
    public String getUsername() {
        return userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     *
     * @return
     */
    public String getLastName() {
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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + userName + ", password=" + password + '}';
    }
    
    
}
