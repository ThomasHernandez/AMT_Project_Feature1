package amt.loginwebpages.rest.dto;

/**
 *
 * @author Thomas Hernandez
 */
public class UserDTO {
    
    private String userName;
    private String firstName;
    private String lastName;
    private String password;

    /**
     *
     */
    public UserDTO() {
    }

    /**
     *
     * @param userName
     * @param password
     * @param firstName
     * @param lastName
     */
    public UserDTO(String userName, String password, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
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
    public String getFirstname() {
        return firstName;
    }
    
    /**
     *
     * @return
     */
    public String getLastname() {
        return lastName;
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
     * @param username
     */
    public void setUsername(String username) {
        this.userName = username;
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
    
    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
}
