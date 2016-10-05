/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.services;

import amt.loginwebpages.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomas
 */
@Local
public interface LoginManagerLocal {
    
  public long saveUser(User user);
  public User loadUser(long id);

  public List<User> findAllUser();
    
}
