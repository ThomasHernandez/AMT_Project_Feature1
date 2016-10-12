/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.services.dao;

import amt.loginwebpages.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Thomas
 */
@Stateless
public class UsersManager implements UsersManagerLocal {
    
    @Resource(lookup = "java:/jdbc/amt")
    private DataSource dataSource;


    @Override
    public User loadUser(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<User> users = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                String userName = rs.getString("user_name");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String password = rs.getString("password");
                users.add(new User(userName, password, firstName, lastName));
                
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println("ERROR in package DAO - UsersManager " +  ex);
            //Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    
    
}
