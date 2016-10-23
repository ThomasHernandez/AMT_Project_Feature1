package amt.loginwebpages.rest.dto;

/**
 *
 * This DTO is used when a GET request is needed. It contains
 * every field that defines a user, password not included.
 * 
 * @author Antony Ciani & Thomas Hernandez
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

