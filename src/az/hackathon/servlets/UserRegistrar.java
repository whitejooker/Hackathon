package az.hackathon.servlets;

import az.hackathon.ApplicationConstants;
import az.hackathon.database.helpers.UserHelper;
import az.hackathon.validators.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegistrar", urlPatterns = { "/register", "/register/" })
public class UserRegistrar extends HttpServlet{
// overridden
protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	request.getRequestDispatcher( ApplicationConstants.JSP_REGISTRATION ).forward( request, response );
}

protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	UserValidator validator = new UserValidator( request );
	if(validator.isValid()){
		UserHelper helper = new UserHelper( );
		System.out.println( "save" );
	}else{
		request.setAttribute( ApplicationConstants.ATTR_MESSAGES, validator.getErrorMessages( ) );
		doGet( request, response );
	}
}
}
