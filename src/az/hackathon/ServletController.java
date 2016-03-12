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

@WebServlet(name = "UserRegistrar", urlPatterns = { "/register", "/register/" })
public class ServletController extends HttpServlet{
final static String ACTION_REGISTER = "register";

public void process( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	final String action = request.getParameter( RequestUtil.PARAM_ACTION );
	String path = ApplicationConstants.JSP_HOME_PAGE;
	boolean forward = true;
	if( action.equals( ACTION_REGISTER ) ){
		UserValidator validator = new UserValidator( request );
		if( validator.isValid( ) ){
			UserHelper helper = new UserHelper( );
			helper.saveUser( validator.forSaving );
			request.getSession( ).setAttribute( ApplicationConstants.ATTR_USER, validator.forSaving );
			request.setAttribute( ApplicationConstants.ATTR_USER, true );
		}else{
			request.setAttribute( ApplicationConstants.ATTR_MESSAGES, validator.getErrorMessages( ) );
			doGet( request, response );
		}
	}

	if( forward ) request.getRequestDispatcher( ApplicationConstants.JSP_REGISTRATION ).forward( request, response );

}

// overridden
protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	process( request, response );
}

protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	process( request, response );
}
}