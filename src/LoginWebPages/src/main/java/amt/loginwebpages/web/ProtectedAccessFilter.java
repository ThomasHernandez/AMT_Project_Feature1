/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amt.loginwebpages.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antony
 */
public class ProtectedAccessFilter implements Filter {
    

    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }    

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        //request.setAttribute("loginManager", lm);
        
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String path = hsr.getRequestURI().substring(hsr.getContextPath().length());
        
        if(path.contentEquals("/")) {
            resp.sendRedirect("/amt/home");
        }
        
        if (hsr.getSession().getAttribute("user") != null) {
            if (path.contentEquals("/login")) {
                //request.getRequestDispatcher("WEB-INF/pages/protectedPage.jsp").forward(request, response);
                resp.sendRedirect("/amt/protected");
            }
            else {
                chain.doFilter(request, response);
            }
        }
        else if (path.contentEquals("/protected")) {
            //path = path + "login";
            //request.getRequestDispatcher("/login").forward(request, response);
            resp.sendRedirect("/amt/login");
        }
        else {
            chain.doFilter(request, response);
        }
    } 

    @Override
    public void destroy() {
        
    }
    
}
