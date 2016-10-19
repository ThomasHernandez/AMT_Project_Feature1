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
        
        //LoginManager lm = (LoginManager) request.getAttribute("loginManager");
        HttpServletResponse resp = (HttpServletResponse)response;
        String message;

        
        String username = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        User user = um.findUser(username);
        if(user != null && um.isValidCredentials(user, password)){
            
            request.getSession().setAttribute("user", user);
            //response.sendRedirect(request.getServletContext().getContextPath() + "/");
            //request.getRequestDispatcher("/protected").forward(request, response);
            //request.getRequestDispatcher("WEB-INF/pages/protectedPage.jsp").forward(request, response);
            resp.sendRedirect("/amt/protected");
        }
        else{ 
            message = "Bad login";
            request.setAttribute("message", message);
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
