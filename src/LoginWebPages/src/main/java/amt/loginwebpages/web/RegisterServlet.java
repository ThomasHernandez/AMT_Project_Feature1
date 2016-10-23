package amt.loginwebpages.web;

import amt.loginwebpages.model.User;
import amt.loginwebpages.services.dao.UsersManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * This servlet is in charge of the register page.
 * It performs multiples tests on the user inputs
 * and display the corresponding error message if needed.
 * If all the fields pass the tests, it creates a new user
 * and adds him in the database.
 * 
 * @author Thomas Hernandez
 * @author Antony Ciani
 */
public class RegisterServlet extends HttpServlet {
    
    @EJB
    private UsersManagerLocal um;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
   
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String errorMessage;
        String registered;
                
        String newFirstName = request.getParameter("firstName");
        String newLastName = request.getParameter("lastName");
        String newUserName = request.getParameter("userName");
        String newPassword = request.getParameter("userPassword");
        String newPasswordConfirm = request.getParameter("userPasswordConfirm");

        // Checking all fields are set
        if(newUserName.isEmpty() || newPassword.isEmpty() || newFirstName.isEmpty() || newLastName.isEmpty()){
            errorMessage = "All fields must be provided!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
            return;
            
        }
        
        // Checking fields lengths to match database fields
        
        if(newUserName.length() >= User.MAX_USERNAME_LENGTH){
            
            errorMessage = "Username is too long, must be at most " + User.MAX_USERNAME_LENGTH + " characters";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
            return;
        }
        
        if(newPassword.length() >= User.MAX_PASSWORD_LENGTH){
            
            errorMessage = "Password is too long, must be at most " + User.MAX_PASSWORD_LENGTH + " characters";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
            return;
        }
        
        if(newFirstName.length() >= User.MAX_FIRSTNAME_LENGTH){
            
            errorMessage = "First name is too long, must be at most " + User.MAX_FIRSTNAME_LENGTH + " characters";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
            return;
        }
        
        if(newLastName.length() >= User.MAX_LASTNAME_LENGTH){
            
            errorMessage = "Last name is too long, must be at most " + User.MAX_LASTNAME_LENGTH + " characters";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
            return;
        }
        
        
        // Checking confirmation password is identical to first one
        if (!newPassword.equals(newPasswordConfirm)) {
            errorMessage = "Passwords must be the same!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
            return;
        }
        
        // Creating user object from provided fields        
        User user = new User(newUserName, newPassword, newFirstName, newLastName);

        // Trying to add a user if the username doesnt exist, returning error if exists
        if (um.addNewUser(user)) {
            //registered = "You have successfully registered";
            request.getSession().setAttribute("message", "yop");
            response.sendRedirect("login");
            
        } else {
            errorMessage = "Username already exists!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
        }
        
        
    }


}
