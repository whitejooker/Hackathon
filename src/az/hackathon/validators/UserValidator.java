package az.hackathon.validators;

import az.hackathon.models.User;
import az.hackathon.utils.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserValidator{
static final Map<String, Integer> MAX_LENGTH_OF_ATTRIBUTE = new HashMap<>( User.NUMBER_OF_ATTRIBUTES );
static final Map<String, Integer> MIN_LENGTH_OF_ATTRIBUTE = new HashMap<>( User.NUMBER_OF_ATTRIBUTES );
RequestUtil util;
static {
	MAX_LENGTH_OF_ATTRIBUTE.put( User.ATTR_USERNAME, 15 );
	MIN_LENGTH_OF_ATTRIBUTE.put( User.ATTR_USERNAME, 5 );
}
UserValidator( HttpServletRequest request ){
	util = new RequestUtil( request );
}

public boolean checkAllFields( ){
	return true;
}

public boolean checkSingleField( String fieldName ){
	final String value = util.getXSSsafeStringFromRequest( fieldName );
	return true;
}
}