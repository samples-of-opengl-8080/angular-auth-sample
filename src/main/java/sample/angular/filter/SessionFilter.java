package sample.angular.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.angular.rest.session.UserSession;

@WebFilter("/rest/*")
public class SessionFilter implements Filter {
    
    @Inject
    private UserSession userSession;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        
        if (this.needsSessionCheck(req) && !this.userSession.isLogged()) {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            chain.doFilter(request, response);
        }
    }
    
    private boolean needsSessionCheck(HttpServletRequest req) {
        return !req.getRequestURI().endsWith("/session");
    }

    @Override public void destroy() {/*no use*/}
    @Override public void init(FilterConfig filterConfig) throws ServletException {/*no use*/}
}
