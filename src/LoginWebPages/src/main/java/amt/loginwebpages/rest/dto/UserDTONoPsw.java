package amt.loginwebpages.rest.dto;

/**
 *
 * @author Thomas Hernandez
 */
public class UserDTONoPsw {

    
    private String userName;
    private String firstName;
    private String lastName;

    /**
     *
     */
    public UserDTONoPsw() {
    }

    /**
     *
     * @param userName
     * @param firstName
     * @param lastName
     */
    public UserDTONoPsw(String userName, String firstName, String lastName) {
        this.userName = userName;
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

    
}

