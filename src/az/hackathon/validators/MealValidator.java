package az.hackathon.validators;

import az.hackathon.ApplicationConstants;
import az.hackathon.models.Food;
import az.hackathon.utils.RequestUtil;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MealValidator{
static final int MAX_NAME_LENGTH = 30;
static final int MAX_DESC_LENGTH = 50;
static final int MAX_STATE = 50;

RequestUtil util;
HttpServletRequest request;
public Food forSaving;
List<String> messages = new ArrayList<>( );

public MealValidator( HttpServletRequest request ){
	util = new RequestUtil( request );
	this.request = request;
}

boolean checkPicture( ) throws IOException, ServletException{
	Part picturePart = request.getPart( RequestUtil.PARAM_PICTURE );
	final boolean isCorrectPicture = picturePart.getContentType( ).substring( 0, 5 ).equals( "image" );
	if( isCorrectPicture ) forSaving.setPictureExtension( FilenameUtils.getExtension( picturePart.getSubmittedFileName( ) ) );
	return isCorrectPicture;
}

boolean checkName( ){
	forSaving.setName( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_NAME ) );
	return forSaving.getName( ).length( ) <= MAX_NAME_LENGTH;
}

boolean checkDesc( ){
	forSaving.setDescription( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_DESCRIPTION ) );
	return forSaving.getDescription( ).length( ) <= MAX_DESC_LENGTH;
}

boolean checkState( ){
	int h = ApplicationConstants.DEFAULT_STATE;
	try{
		h = Integer.parseInt( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_STATE ) );
	}catch( NumberFormatException ignored ){ }
	forSaving.setState( h );
	return h < ApplicationConstants.DEFAULT_STATE;
}

boolean checkType( ){
	int type = ApplicationConstants.DEFAULT_TYPE_ID;
	try{
		type = Integer.parseInt( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_TYPE_ID ) );
	}catch( NumberFormatException ignored ){ }
	return type > ApplicationConstants.DEFAULT_TYPE_ID;
}

boolean checkPrice( ){
	double price = ApplicationConstants.DEFAULT_PRICE;
	try{
		price = Double.parseDouble( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_PRICE ) );
	}catch( NumberFormatException ignored ){ }
	return price < ApplicationConstants.DEFAULT_PRICE;
}

boolean checkAmount( ){
	int kg = ApplicationConstants.DEFAULT_AMOUNT;
	try{
		kg = Integer.parseInt( util.getXSSsafeStringFromRequest( RequestUtil.PARAM_AMOUNT ) );
	}catch( NumberFormatException ignored ){ }
	return kg > ApplicationConstants.DEFAULT_AMOUNT;
}

// getters and setters
public List<String> getMessages( ){ return messages; }

public boolean isValid( ) throws IOException, ServletException{
	boolean flag = true;
	if( !checkPicture( ) ){
		messages.add( "File is not a picture" );
		flag = false;
	}
	if( !checkDesc( ) ){
		messages.add( "Description is too long" );
		flag = false;
	}
	if( !checkName( ) ){
		messages.add( "Name is too long" );
		flag = false;
	}
	if( !checkState( ) ){
		messages.add( "Meal is too old" );
		flag = false;
	}
	if( !checkType( ) ){
		messages.add( "Incorrect meal type" );
		flag = false;
	}
	if( !checkAmount( ) ){
		messages.add( "Incorrect amount" );
		flag = false;
	}
	if( !checkPrice( ) ){
		messages.add( "Incorrect price" );
		flag = false;
	}
	return flag;
}

}
