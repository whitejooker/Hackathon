package az.hackathon.filters;

import az.hackathon.ApplicationConstants;
import az.hackathon.database.helpers.CityHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "MainFilter",urlPatterns = {"*"})
public class MainFilter implements Filter{
// overridden
public void init( FilterConfig config ) throws ServletException{

}

public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException{
	HttpServletRequest request = (HttpServletRequest) req;
	request.setAttribute( ApplicationConstants.ATTR_ALL_CITIES, new CityHelper( ).getAllCities( ) );
	request.setAttribute( ApplicationConstants.ATTR_IS_LOGGED, !( request.getSession( ).getAttribute( ApplicationConstants.ATTR_USER ) == null ) );
	chain.doFilter( req, resp );
}

public void destroy( ){
}

}
