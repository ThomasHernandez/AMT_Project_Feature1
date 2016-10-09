/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.web;

import amt.loginwebpages.model.User;
import amt.loginwebpages.services.LoginManager;
import amt.loginwebpages.services.LoginManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antony
 */
public class LoginServlet extends HttpServlet {
    
    @EJB
    private LoginManagerLocal lm;


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
        /*if(request.getSession().getAttribute("username") != null){
            if(lm.isUsernameRegistered(request.getSession().getAttribute("username").toString())){
                
                request.getSession();
                request.getRequestDispatcher("WEB-INF/pages/authorizedonly.html").forward(request, response);
                
            }
            else{
                request.getRequestDispatcher("WEB-INF/pages/loginform.jsp").forward(request, response);
                
            }
            
        }
        else{
             request.getRequestDispatcher("WEB-INF/pages/loginform.jsp").forward(request, response);
            
        }*/
        
        request.getRequestDispatcher("WEB-INF/pages/loginform.jsp").forward(request, response);
       
   
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

        
        String username = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        User user = lm.loadUser(username);
        
        if(user != null && lm.isValidCredentials(user, password)){
            
            request.getSession().setAttribute("user", user);
            //response.sendRedirect(request.getServletContext().getContextPath() + "/");
            request.getRequestDispatcher("/protected").forward(request, response);
        }
        else{ 
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
