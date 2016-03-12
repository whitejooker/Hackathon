package az.hackathon.utils;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil{
public final static String PARAM_USERNAME = "username";
public final static String PARAM_PASSWORD = "password";
public final static String PARAM_PASSWORD_CONFIRM = "password_confirm";
public final static String PARAM_PHONE = "phone";
public final static String PARAM_EMAIL = "email";
public final static String PARAM_NAME = "name";

public HttpServletRequest request;

public RequestUtil( HttpServletRequest request ){
	this.request = request;
}

public String getXSSsafeStringFromRequest( String parameterName ){
	String value = request.getParameter( parameterName );
	if( value == null ) value = "";
	else value = StringEscapeUtils.escapeHtml4( value.trim( ) );
	return value;
}
}