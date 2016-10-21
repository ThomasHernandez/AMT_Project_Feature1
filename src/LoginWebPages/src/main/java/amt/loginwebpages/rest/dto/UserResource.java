package amt.loginwebpages.rest.dto;

import amt.loginwebpages.model.User;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import amt.loginwebpages.services.dao.UsersManagerLocal;
import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


/**
 *
 * @author Thomas Hernandez
 * @author Antony Ciani
 */



@Stateless
@Path("/users")
public class UserResource {
    
    @EJB
    private UsersManagerLocal um;

    @Context
    UriInfo uriInfo;

    /**
     *
     * @param byName
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTONoPsw> getUsers(@QueryParam(value = "byName") String byName) {
        List<User> users = um.findAllUsers();
        return users.stream()
                .filter(p -> byName == null || p.getLastName().equalsIgnoreCase(byName))
                .map(p -> toUserDTO(p))
                .collect(toList());

    }

    /**
     *
     * @param userDTO
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO userDTO) {
        User user = fromUserDTO(userDTO);

        // Checking if all fields are provided
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getFirstName().isEmpty() || user.getLastName().isEmpty()){
            
            return Response
                .notModified("All fields must be non empty!")
                .build();
  
        }
        
        // Checking fields lengths to match database fields
        
        if(user.getUsername().length() >= User.MAX_USERNAME_LENGTH){

            return Response
                 .notModified("Username is too long, must be at most " + User.MAX_USERNAME_LENGTH + " characters")
                 .build();
        }
        
        if(user.getPassword().length() >= User.MAX_PASSWORD_LENGTH){
            
            return Response
                .notModified("Password is too long, must be at most " + User.MAX_PASSWORD_LENGTH + " characters")
                .build();
        }
        
        if(user.getFirstName().length() >= User.MAX_FIRSTNAME_LENGTH){
            
            return Response
                .notModified("First name is too long, must be at most " + User.MAX_FIRSTNAME_LENGTH + " characters")
                .build();
        }
        
        if(user.getLastName().length() >= User.MAX_LASTNAME_LENGTH){
            
            
            return Response
                .notModified("Last name is too long, must be at most " + User.MAX_LASTNAME_LENGTH + " characters")
                .build();
        }
        
        
        if (um.addNewUser(user)) {
            String userName = userDTO.getUsername();
            URI href = uriInfo
                    .getBaseUriBuilder()
                    .path(UserResource.class)
                    .path(UserResource.class, "getUser")
                    .build(userName);

            return Response
                    .created(href)
                    .build();
        }

        return Response
                .notModified("User already exists!!!")
                .build();

    }
    
    /**
     *
     * @param id
     * @param dto
     * @return
     */
    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateInfoUser(@PathParam(value = "id") String id, UpdateUserDTO dto){
        
       // Checking fields lengths to match database fields

       if(dto.getPassword().length() >= User.MAX_PASSWORD_LENGTH){

           return Response
               .notModified("Password is too long, must be at most " + User.MAX_PASSWORD_LENGTH + " characters")
               .build();
       }

       if(dto.getFirstName().length() >= User.MAX_FIRSTNAME_LENGTH){

           return Response
               .notModified("First name is too long, must be at most " + User.MAX_FIRSTNAME_LENGTH + " characters")
               .build();
       }

       if(dto.getLastName().length() >= User.MAX_LASTNAME_LENGTH){


           return Response
               .notModified("Last name is too long, must be at most " + User.MAX_LASTNAME_LENGTH + " characters")
               .build();
       }


       User user = um.findUser(id);

       if(user != null){
           user.setFirstName(dto.getFirstName());
           user.setLastName(dto.getLastName());
           user.setPassword(dto.getPassword());
           um.updateUser(user);
           return Response
               .accepted("User updated").build();

       }
       else{
           return Response
               .notModified("User doesn't exist").build();

       }

   }
    

    /**
     *
     * @param id
     * @return
     */
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam(value = "id") String id) {
        User user = um.findUser(id);
        if(user != null){
            
            return Response.ok(toUserDTO(user)).build();
        }
        else{
            
            return Response.status(Status.NOT_FOUND).build();
        }
        
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Path("{id}")
    @DELETE
    //@Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam(value = "id") String id) {
        User user = um.findUser(id);
        if(user != null){
            
            um.deleteUser(user.getUsername());
            return Response
                    .accepted("User deleted").build();
            
        }
        else{
            return Response
                    .notModified("User doesn't exist").build();
        }
        
    }

    /**
     *
     * @param dto
     * @return
     */
    public User fromUserDTO(UserDTO dto) {

        return new User(dto.getUsername(), dto.getPassword(), dto.getFirstname(), dto.getLastname());
    }

    /**
     *
     * @param user
     * @return
     */
    public UserDTONoPsw toUserDTO(User user) {
        
        return new UserDTONoPsw(user.getUsername(), user.getFirstName(), user.getLastName());
    }
    

}
