package org.cursofinalgrado.java.petcare.cfg.uapa.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ecabrerar
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private ServletContext context;
    private FilterConfig filterConfig;

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
         this.filterConfig = filterConfig;
    	this.context = filterConfig.getServletContext();
    	this.context.log("AuthenticationFilter initialized");
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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        this.context.log("Requested Resource::"+uri);

        req.getSession(false);

        if (req.getSession().getAttribute("currentSessionUser") == null
        	&& !(uri.endsWith("index.jsp") || uri.endsWith("LoginServlet") || uri.endsWith("signup.jsp")
        			|| uri.matches(".*(css|jpg|png|gif|js|eot|svg|ttf|woff|woff2)"))) {

        	this.context.log("Unauthorized access request");

            res.sendRedirect("index.jsp");

        }else{

              // pass the request along the filter chain
              chain.doFilter(request, response);
        }
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
        if(null != filterConfig){
            filterConfig.getServletContext().log("Destroying AuthenticationFilter");
        }    	
    }

    /**
     * Return the filter configuration object for this filter.
     * @return
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
