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
 * @author Thomas Hernandez
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
        
        //HttpServletResponse resp = (HttpServletResponse)response;
        String message;
        String registered;
        
        String newFirstName = request.getParameter("firstName");
        String newLastName = request.getParameter("lastName");
        String newUserName = request.getParameter("userName");
        String newPassword = request.getParameter("userPassword");
        String newPasswordConfirm = request.getParameter("userPasswordConfirm");

        if (!newPassword.equals(newPasswordConfirm)) {
            message = "Passwords must be the same!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
            return;
        }
            User user = new User(newUserName, newPassword, newFirstName, newLastName);

            if (um.addNewUser(user)) {
                registered = "You have successfully registered";
                request.getSession().setAttribute("message", registered);
                //request.setAttribute("registered", registered);
                response.sendRedirect("login");
            } else {
                message = "Username already exists!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("WEB-INF/pages/registerform.jsp").forward(request, response);
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
    }

}
