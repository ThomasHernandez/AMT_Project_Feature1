package amt.loginwebpages.rest.dto;

/**
 * 
 * This DTO allows an update on a user. Therefore,
 * it does not contains the username since this one
 * is what defines the user and thus cannot be updated.
 * 
 * @author Antony Ciani & Thomas Hernandez
 */
public class UpdateUserDTO {
    
    private String firstName;
    private String lastName;
    private String password;


    public UpdateUserDTO(){

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
