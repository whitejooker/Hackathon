package az.hackathon.servlets;

import az.hackathon.ApplicationConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloSpeaker", urlPatterns = { "" })
public class HelloSpeaker extends HttpServlet{

// overridden
protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	request.setAttribute( ApplicationConstants.ATTR_TEST, "I'm here! :)" );
	request.getRequestDispatcher( ApplicationConstants.JSP_ROOT ).forward( request, response );
}
}