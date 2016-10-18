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
 * @author Antony Ciani
 * @author Thomas Hernandez
 */
public class ProtectedAccessFilter implements Filter {
    
    /**
     *
     * @param filterConfig
     * @throws ServletException
     */
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
        request.setCharacterEncoding("UTF-8");
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String path = hsr.getRequestURI().substring(hsr.getContextPath().length());
        
        if(path.contentEquals("/")) {
            resp.sendRedirect("/amt/home");
        }
        
        if (hsr.getSession().getAttribute("user") != null) {
            if (path.contentEquals("/login")) {
                resp.sendRedirect("/amt/protected");
            }
            else {
                chain.doFilter(request, response);
            }
        }
        else if (path.contentEquals("/protected")) {
            resp.sendRedirect("/amt/login");
        }
        else {
            chain.doFilter(request, response);
        }
    } 

    /**
     *
     */
    @Override
    public void destroy() {
        
    }
    
}
