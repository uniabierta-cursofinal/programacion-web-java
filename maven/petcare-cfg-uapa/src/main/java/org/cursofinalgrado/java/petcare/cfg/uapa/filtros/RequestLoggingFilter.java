package org.cursofinalgrado.java.petcare.cfg.uapa.filtros;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ecabrerar
 */
/**
 * Servlet Filter implementation class RequestLoggingFilter
 */
@WebFilter("/RequestLoggingFilter")
public class RequestLoggingFilter implements Filter {

    private FilterConfig filterConfig;
    private ServletContext context;

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    	this.context = filterConfig.getServletContext();
    	this.context.log("RequestLoggingFilter initialized");

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
         Enumeration<String> params = req.getParameterNames();

         while(params.hasMoreElements()){
             String name = params.nextElement();
             String value = request.getParameter(name);
             this.context.log(req.getRemoteAddr() + "::Request Params::{"+name+"="+value+"}");
         }

         Cookie[] cookies = req.getCookies();

         if(cookies != null){
             for(Cookie cookie : cookies){
                 this.context.log(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
             }
         }

         // pass the request along the filter chain
         chain.doFilter(request, response);

    }

	@Override
	public void destroy() {
            if(null != filterConfig){
		filterConfig.getServletContext().log("Destroying RequestLoggingFilter");
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
