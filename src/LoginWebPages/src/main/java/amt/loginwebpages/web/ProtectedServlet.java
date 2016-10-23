package amt.loginwebpages.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * This Servlet is in charge of the protected page
 * and simply loads it.
 * 
 * @author Antony Ciani & Thomas Hernandez
 */
public class ProtectedServlet extends HttpServlet {

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
        
        request.getRequestDispatcher("WEB-INF/pages/protectedPage.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * It also authenticates a user, creates his session 
     * and display the corresponding error mesage if needed.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("WEB-INF/pages/protectedPage.jsp").forward(request, response);
    }


}
