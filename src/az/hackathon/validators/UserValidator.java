package az.hackathon.validators;

import az.hackathon.utils.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class UserValidator{
public static int MAX_USERNAME_LENGTH = 20;
public static int MAX_PASSWORD_LENGTH = 20;
public static int MIN_USERNAME_LENGTH = 5;
public static int MIN_PASSWORD_LENGTH = 5;
RequestUtil util;
private List<String> errorMessages = new ArrayList<>( );

private UserValidator( HttpServletRequest request ){
	util = new RequestUtil( request );
}

private boolean checkUsername( ){
	final String username = util.getXSSsafeStringFromRequest( RequestUtil.PARAM_USERNAME ).toLowerCase( );
	return !( username.length( ) < MIN_USERNAME_LENGTH || username.length( ) > MAX_USERNAME_LENGTH );
}

private boolean checkPassword( ){
	final String passwd = util.getXSSsafeStringFromRequest( RequestUtil.PARAM_PASSWORD );
	final String confirm = util.getXSSsafeStringFromRequest( RequestUtil.PARAM_PASSWORD_CONFIRM );
	return passwd.length( ) <= MAX_PASSWORD_LENGTH && passwd.length( ) >= MIN_PASSWORD_LENGTH && passwd.equals( confirm );
}

// getters and setters
public boolean isValid( ){
	boolean flag = true;
	if( checkUsername( ) ) errorMessages.add( "Username must be from 5-20 A-z0-9 symbols." );
	return flag;
}
}