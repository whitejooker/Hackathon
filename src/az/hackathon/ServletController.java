package az.hackathon;

import az.hackathon.database.helpers.UserHelper;
import az.hackathon.utils.RequestUtil;
import az.hackathon.validators.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegistrar", urlPatterns = { "" })
public class ServletController extends HttpServlet{
final static String ACTION_REGISTER = "register";

public void process( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	final String action = request.getParameter( RequestUtil.PARAM_ACTION );
	String path = ApplicationConstants.JSP_HOME_PAGE;
	boolean forward = true;
	if( action != null ) if( action.equals( ACTION_REGISTER ) ){
		path = ApplicationConstants.JSP_REGISTRATION;
		if( request.getParameter( ApplicationConstants.ATTR_SUBMIT ) != null ){
			UserValidator validator = new UserValidator( request );
			if( validator.isValid( ) ){
				UserHelper helper = new UserHelper( );
				helper.saveUser( validator.forSaving );
				request.getSession( ).setAttribute( ApplicationConstants.ATTR_USER, validator.forSaving );
				request.setAttribute( ApplicationConstants.ATTR_IS_LOGGED, true );
				path = "/";
				forward = false;
			}else request.setAttribute( ApplicationConstants.ATTR_MESSAGES, validator.getErrorMessages( ) );
		}
	}
	if( forward ) request.getRequestDispatcher( "/WEB-INF/views/" + path ).forward( request, response );
	else response.sendRedirect( path );
}

// overridden
protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	process( request, response );
}

protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	process( request, response );
}
}