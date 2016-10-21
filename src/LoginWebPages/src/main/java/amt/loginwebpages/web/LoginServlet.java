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
 * @author Antony Ciani
 */
public class LoginServlet extends HttpServlet {
    
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
        response.setContentType("text/html;charset=UTF-8");
        //request.setAttribute("users", lm.findAllUsers());
        //request.getRequestDispatcher("WEB-INF/pages/users.jsp").forward(request, response);
        
        
        request.getRequestDispatcher("WEB-INF/pages/loginform.jsp").forward(request, response);
        request.getSession().setAttribute("message", null);
       
   
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

        
        String username = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        
        // Checking all fields are set
        if(username.isEmpty() || password.isEmpty()){
            errorMessage = "All fields must be provided!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/loginform.jsp").forward(request, response);
            return;
            
        }
        
        // Checking fields lengths to match database fields
        
        if(username.length() >= User.MAX_USERNAME_LENGTH){
            
            errorMessage = "Username is too long, must be at most " + User.MAX_USERNAME_LENGTH + " characters";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/loginform.jsp").forward(request, response);
            return;
        }
        
        if(password.length() >= User.MAX_PASSWORD_LENGTH){
            
            errorMessage = "Password is too long, must be at most " + User.MAX_PASSWORD_LENGTH + " characters";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/loginform.jsp").forward(request, response);
            return;
        }
        
        
        User user = um.findUser(username);
        
        if(user != null && um.isValidCredentials(user, password)){
            
            request.getSession().setAttribute("user", user);
            response.sendRedirect("protected");
            
        }
        else{ 
            
            errorMessage = "Bad login";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/pages/loginform.jsp").forward(request, response);
            
        }    
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
