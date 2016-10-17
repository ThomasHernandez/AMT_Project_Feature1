
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Thomas
 */



@Stateless
@Path("/users")
public class UserResource {
    
    @EJB
    private UsersManagerLocal um;

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTONoPsw> getUsers(@QueryParam(value = "byName") String byName) {
        List<User> users = um.findAllUsers();
        return users.stream()
                .filter(p -> byName == null || p.getLastName().equalsIgnoreCase(byName))
                .map(p -> toUserDTO(p))
                .collect(toList());

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO userDTO) {
        User user = fromUserDTO(userDTO);

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
    
    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateInfoUser(@PathParam(value = "id") String id, UpdateUserDTO dto){
        User user = um.findUser(id);
        if(user != null){
            user.setFirstName(dto.getFirstname());
            user.setLastName(dto.getLastname());
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
    

//    @Path("{id}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public UserDTONoPsw getUser(@PathParam(value = "id") String id) {
//        User user = um.findUser(id);
//        return toUserDTO(user);
//    }
    
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

    public User fromUserDTO(UserDTO dto) {

        return new User(dto.getUsername(), dto.getPassword(), dto.getFirstname(), dto.getLastname());
    }

    public UserDTONoPsw toUserDTO(User user) {
        
        return new UserDTONoPsw(user.getUsername(), user.getFirstName(), user.getLastName());
    }
    

}
