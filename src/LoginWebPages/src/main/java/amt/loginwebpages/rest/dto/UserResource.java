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
import amt.loginwebpages.services.LoginManagerLocal;
import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Thomas
 */
@Stateless
@Path("/users")
public class UserResource {

    @EJB
    private LoginManagerLocal lm;

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getUsers(@QueryParam(value = "byName") String byName) {
        List<User> users = lm.findAllUsers();
        return users.stream()
                .filter(p -> byName == null || p.getLastName().equalsIgnoreCase(byName))
                .map(p -> toUserDTO(p))
                .collect(toList());

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO userDTO) {
        User user = fromUserDTO(userDTO);

        if (lm.addNewUser(user)) {
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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam(value = "id") String id) {
        User user = lm.loadUser(id);
        return toUserDTO(user);
    }

    public User fromUserDTO(UserDTO dto) {

        return new User(dto.getUsername(), "Toor1234", dto.getFirstname(), dto.getLastname());
    }

    public UserDTO toUserDTO(User user) {
        
        return new UserDTO(user.getUsername(), user.getFirstName(), user.getLastName());
    }
    

}
