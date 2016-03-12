package az.hackathon.servlets;

import az.hackathon.ApplicationConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegistrar", urlPatterns = { "/registration", "/registration/" })
public class UserRegistrar extends HttpServlet{
// overridden
protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	request.getRequestDispatcher( ApplicationConstants.JSP_REGISTRATION ).forward( request, response );
}

protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

}
}
