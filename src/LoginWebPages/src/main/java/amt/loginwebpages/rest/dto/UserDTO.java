package amt.loginwebpages.rest.dto;

/**
 *
 * This DTO is used when a POST request is needed. It contains
 * every field that defines a user, password included.
 * 
 * @author Antony Ciani & Thomas Hernandez
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
     * @return username
     */
    public String getUsername() {
        return userName;
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
     * @return password
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
