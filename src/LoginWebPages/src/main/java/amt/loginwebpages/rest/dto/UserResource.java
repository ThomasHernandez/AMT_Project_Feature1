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
@Path("/user")
public class UserResource {
    
  @EJB
  private LoginManagerLocal loginManager;

  @Context
  UriInfo uriInfo;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<UserDTO> getUsers(@QueryParam(value = "byName" ) String byName) {
    List<User> user = loginManager.findAllUser();
    return user.stream();
      .filter(p -> byName == null || p.getUsername().equalsIgnoreCase(byName))
      .map(p -> toDTO(p))
      .collect(toList());
      
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(UserDTO userDTO) {
    User user = fromDTO(userDTO);
    long userId = loginManager.saveUser(user);

    URI href = uriInfo
      .getBaseUriBuilder()
      .path(UserResource.class)
      .path(UserResource.class, "getPerson")
      .build(userId);

    return Response
      .created(href)
      .build();
  }

  @Path("{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public UserDTO getUser(@PathParam(value = "id") long id) {
    User user = loginManager.loadUser(id);
    return toDTO(user);
  }
  
  public User fromDTO(UserDTO dto) {
    return new User(dto.getUsername(), dto.getPassword());
  }
  
  // A adapter pour notre projet
  public UserDTO toDTO(User user) {
    UserDTO dto = new UserDTO(user.getUsername(), user.getPassword());
    for (Contract c : person.getContracts()) {
      if (c.isActive()) {
        dto.addEmployer(c.getCompany().getName());
      }
    }
    return dto;
  }
  
  
}
