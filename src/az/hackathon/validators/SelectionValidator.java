package az.hackathon.validators;

import az.hackathon.ApplicationConstants;
import az.hackathon.database.helpers.CityHelper;
import az.hackathon.database.helpers.TypeHelper;
import az.hackathon.models.Selection;
import az.hackathon.models.Type;
import az.hackathon.utils.RequestUtil;

import javax.servlet.http.HttpServletRequest;

public class SelectionValidator{

public Selection PrepareSelection( HttpServletRequest request ){
	Selection selection = new Selection( );
	int cityId = ApplicationConstants.DEFAULT_CITY_ID;
	int typeId = ApplicationConstants.DEFAULT_TYPE_ID;
	Double price;
	int amount;
	int numberOfCities;
	int state;

	CityHelper cityHelper = new CityHelper( );
	try{
		cityId = Integer.parseInt( request.getParameter( RequestUtil.PARAM_CITY_ID ) );
		numberOfCities = cityHelper.getNumberOfCities( );
		if( cityId > numberOfCities - 1 ){
			cityId = ApplicationConstants.DEFAULT_CITY_ID;
		}
	}catch( Exception e ){
		cityId = ApplicationConstants.DEFAULT_CITY_ID;
	}

	typeId = ApplicationConstants.DEFAULT_TYPE_ID;
	try{
		typeId = Integer.parseInt( request.getParameter( RequestUtil.PARAM_TYPE_ID ) );

		if( typeId > Type.allTypes.size( ) - 1 ){
			typeId = ApplicationConstants.DEFAULT_TYPE_ID;
		}
	}catch( Exception e ){
		typeId = ApplicationConstants.DEFAULT_TYPE_ID;
	}

	try{
		price = Double.parseDouble( request.getParameter( RequestUtil.PARAM_PRICE ) );
	}catch( Exception e ){
		price = ApplicationConstants.DEFAULT_PRICE;
	}

	try{
		amount = Integer.parseInt( request.getParameter( RequestUtil.PARAM_AMOUNT ) );
	}catch( Exception e ){
		amount = ApplicationConstants.DEFAULT_AMOUNT;
	}

	try{
		state = Integer.parseInt( request.getParameter( RequestUtil.PARAM_STATE ) );
	}catch( Exception e ){
		state = ApplicationConstants.DEFAULT_STATE;
	}

	selection.setCity( cityHelper.getCity( cityId ) );
	selection.setType( new TypeHelper( ).getType( typeId ) );
	selection.setPrice( price );
	selection.setAmount( amount );
	selection.setState( state );
	selection.setCurrentPage( 1 );
	return selection;
}
}
