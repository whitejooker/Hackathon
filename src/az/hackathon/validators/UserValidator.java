package az.hackathon.validators;

import az.hackathon.database.helpers.CityHelper;
import az.hackathon.database.helpers.UserHelper;
import az.hackathon.models.City;
import az.hackathon.models.User;
import az.hackathon.utils.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


public class UserValidator{
public static int MAX_USERNAME_LENGTH = 20;
public static int MAX_PASSWORD_LENGTH = 20;
public static int MIN_USERNAME_LENGTH = 5;
public static int MIN_PASSWORD_LENGTH = 5;
public static String USERNAME_PATTERN = String.format( "[a-zA-Z0-9]{%d,%d}$", MIN_USERNAME_LENGTH, MAX_USERNAME_LENGTH );
public static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
public User forSaving = new User( );
RequestUtil util;
private List<String> errorMessages = new ArrayList<>( );

public UserValidator( HttpServletRequest request ){
	util = new RequestUtil( request );
}

private boolean checkUserUniqueness( ){
	return new UserHelper( ).getUser( forSaving.getUsername( ) ).getId( ) == -1;
}

private boolean checkUsername( ){
	forSaving.setUsername( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_USERNAME ).toLowerCase( ) );
	boolean flag = forSaving.getUsername( ).length( ) >= MIN_USERNAME_LENGTH && forSaving.getUsername( ).length( ) <= MAX_USERNAME_LENGTH;
	return forSaving.getUsername( ).matches( USERNAME_PATTERN );
}

private boolean checkPassword( ){
	forSaving.setPassword( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_PASSWORD ) );
	final String confirm = util.getXSSsafeStringFromRequest( RequestUtil.PARAM_PASSWORD_CONFIRM );
	return forSaving.getPassword( ).length( ) <= MAX_PASSWORD_LENGTH && forSaving.getPassword( ).length( ) >= MIN_PASSWORD_LENGTH && forSaving.getPassword( ).equals( confirm );
}

private boolean checkEmail( ){
	forSaving.setEmail( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_EMAIL ) );
	return forSaving.getEmail( ).matches( EMAIL_PATTERN );
}

// getters and setters
private int getCityId( ){
	int id = -1;
	try{
		id = Integer.parseInt( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_CITY_ID ) );
	}catch( NumberFormatException ignored ){ }
	return id;
}

public List<String> getErrorMessages( ){ return errorMessages; }

public boolean isValid( ){
	boolean flag = true;
	if( !checkUsername( ) ){
		errorMessages.add( "Username is wrong." );
		flag = false;
	}
	if( !checkPassword( ) ){
		errorMessages.add( "Password is wrong." );
		flag = false;
	}
	if( !checkEmail( ) ){
		errorMessages.add( "Email is wrong." );
		flag = false;
	}
	if( !checkUserUniqueness( ) ){
		errorMessages.add( MessageFormat.format( "User <b>{0}</b> already exist", forSaving.getUsername( ) ) );
		flag = false;
	}
	forSaving.setName( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_NAME ) );
	forSaving.setPhone( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_PHONE ) );
	forSaving.setAddress( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_ADDRESS ) );
	City city = new CityHelper( ).getCity( getCityId( ) );
	forSaving.setCity( city );
	return flag;
}
}