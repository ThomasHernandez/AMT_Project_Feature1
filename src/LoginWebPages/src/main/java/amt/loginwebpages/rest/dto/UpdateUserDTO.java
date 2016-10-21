package amt.loginwebpages.rest.dto;

/**
 *
 * @author Thomas Hernandez
 */
public class UpdateUserDTO {
    
    private String firstName;
    private String lastName;
    private String password;

    /**
     *
     */
    public UpdateUserDTO(){

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
     * @return
     */
    public String getPassword() {
        return password;
    }
    
    /**
     *
     * @param firstname
     */
    public void setFirstname(String firstname) { 
        this.firstName = firstname; 
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) { 
        this.lastName = lastname; 
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
