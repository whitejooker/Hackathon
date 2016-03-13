package az.hackathon;

import az.hackathon.database.helpers.FoodHelper;
import az.hackathon.database.helpers.UserHelper;
import az.hackathon.models.Selection;
import az.hackathon.models.User;
import az.hackathon.utils.RequestUtil;
import az.hackathon.validators.SelectionValidator;
import az.hackathon.validators.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet(name = "UserRegistrar", urlPatterns = { "" })
public class ServletController extends HttpServlet{
final static String ACTION_REGISTER = "register";
final static String ACTION_LOGIN = "login";
final static String ACTION_ADD_FOOD = "addFood";

public void process( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	final String action = request.getParameter( RequestUtil.PARAM_ACTION );
	RequestUtil util = new RequestUtil( request );
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
	}else if( action.equals( ACTION_LOGIN ) ){
		path = ApplicationConstants.JSP_LOGIN;
		if( request.getParameter( ApplicationConstants.ATTR_SUBMIT ) != null ){
			User user = new UserHelper( ).getUser( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_USERNAME ) );
			if( user.getId( ) != -1 && user.getPassword( ).equals( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_PASSWORD ) ) ){
				request.getSession( ).setAttribute( ApplicationConstants.ATTR_USER, user );
				request.setAttribute( ApplicationConstants.ATTR_IS_LOGGED, true );
				path = "/";
				forward = false;
			}else request.setAttribute( ApplicationConstants.ATTR_MESSAGES, Collections.singletonList( "Password or login is wrong" ) );
		}
	}else if( action.equals( ACTION_ADD_FOOD ) && request.getAttribute( ApplicationConstants.ATTR_IS_LOGGED ).equals( true ) ){
		path = ApplicationConstants.JSP_ADD_FOOD;

	}


	if( path.equals( ApplicationConstants.JSP_HOME_PAGE ) ){
		Selection selection = (Selection) request.getSession( ).getAttribute( ApplicationConstants.ATTR_SELECTION );
		if( request.getParameter( ApplicationConstants.ATTR_SUBMIT ) != null || selection == null ){
			selection = new SelectionValidator( ).PrepareSelection( request );
			request.getSession( ).setAttribute( ApplicationConstants.ATTR_SELECTION, selection );
		}
		request.setAttribute( ApplicationConstants.ATTR_MEALS, new FoodHelper( ).getAllFoodBySelection( selection ) );
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