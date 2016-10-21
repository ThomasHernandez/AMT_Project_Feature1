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
 * Implementation of UsersManagerLocal interface
 *
 * @author Thomas Hernandez
 * @author Antony Ciani
 */
@Stateless
public class UsersManager implements UsersManagerLocal {
    
    @Resource(lookup = "java:/jdbc/amt")
    private DataSource dataSource;


    @Override
    public User findUser(String userName) {
        User user = null;
        try {
            
            Connection connection = dataSource.getConnection();
            
            // Retrieve User information into database
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM user WHERE user_username = \"" + userName + "\"");
            ResultSet rs = pstmt.executeQuery();
            
            // If there is a result from the database, the user exists
            if(rs.next()) {
                
                String firstName = rs.getString("user_first_name");
                String lastName = rs.getString("user_last_name");
                String password = rs.getString("user_password");
                user = new User(userName, password, firstName, lastName);
                
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println("ERROR in package DAO - UsersManager " +  ex);
            //Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        
        List<User> users = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            
            // Retrieve all the users from database
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM user");
            ResultSet rs = pstmt.executeQuery();
            
            // Add users to the list 
            while(rs.next()) {
                String userName = rs.getString("user_username");
                String firstName = rs.getString("user_first_name");
                String lastName = rs.getString("user_last_name");
                String password = rs.getString("user_password");
                users.add(new User(userName, password, firstName, lastName));
                
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println("ERROR in package DAO - UsersManager " +  ex);
            //Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public void deleteUser(String userName){

        try {
            Connection connection = dataSource.getConnection();
            
            // Deleting user with provided username from database
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM user WHERE user_username = \"" + userName + "\"");
            pstmt.executeUpdate();
            
            connection.close();
        } catch (SQLException ex) {
            System.err.println("ERROR in package DAO - UsersManager " +  ex);
            //Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateUser(User userToUpdate){
        
        try {
            Connection connection = dataSource.getConnection();
            
            // Updating if change in password
            if(!userToUpdate.getPassword().isEmpty()){
                PreparedStatement pstmt = connection.prepareStatement("UPDATE user SET user_password = \""+ userToUpdate.getPassword()  +"\" WHERE user_username = \"" + userToUpdate.getUsername()+ "\"");
                pstmt.executeUpdate();
            }
            // Updating if change in first name
            if(!userToUpdate.getFirstname().isEmpty()){
                PreparedStatement pstmt = connection.prepareStatement("UPDATE user SET user_first_name = \""+ userToUpdate.getFirstname() +"\" WHERE user_username = \"" + userToUpdate.getUsername() + "\"");
                pstmt.executeUpdate();
            }
            // Updating if change in last name
            if(!userToUpdate.getLastname().isEmpty()){
                PreparedStatement pstmt = connection.prepareStatement("UPDATE user SET user_last_name = \""+ userToUpdate.getLastname() +"\" WHERE user_username = \"" + userToUpdate.getUsername() + "\"");
                pstmt.executeUpdate();
                
            }
           
            connection.close();
        } catch (SQLException ex) {
            System.err.println("ERROR in package DAO - UsersManager " +  ex);
            //Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public boolean addNewUser(User user){
        
        // Check if user doesnt already exist in databse
        if(findUser(user.getUsername()) == null) {
            
                try {
                Connection connection = dataSource.getConnection();
                System.out.println("INSERT INTO user VALUES (NULL, \"" + user.getUsername() + "\", \"" + user.getPassword() + "\", "
                        + "\"" + user.getFirstname() + "\", \"" + user.getLastname() + "\") ");
                
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO user VALUES (NULL, \"" + user.getUsername() + "\", \"" + user.getPassword() + "\", "
                        + "\"" + user.getFirstname() + "\", \"" + user.getLastname() + "\")");
                
                pstmt.executeUpdate();
                connection.close();
                return true;

            } catch (SQLException ex) {
                System.err.println("ERROR in package DAO - UsersManager " + ex);
                return false;
                //Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
        
    }

    
    public boolean isValidCredentials(User user, String testPassword){
        try {
            Connection connection = dataSource.getConnection();
            
            // Checking is pair username, password exist in a row of table user
            PreparedStatement pstmt = connection.prepareStatement("SELECT user_password FROM user WHERE user_username = \""+user.getUsername()+"\" ");
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                
                if(rs.getString("user_password").equals(testPassword)){
                    connection.close();
                    return true;
                    
                }             
                
            }
            connection.close();
            return false;
            
        } catch (SQLException ex) {
            System.err.println("ERROR in package DAO - UsersManager " +  ex);
            return false;
            //Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
