package az.hackathon.utils;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil{
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
