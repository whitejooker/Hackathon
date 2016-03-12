package az.hackathon.database.helpers;

import az.hackathon.models.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qalib on 3/12/2016.
 */
public class CityHelper extends Helper{

private static final String ID = "id";
private static final String NAME = "name";

private City createCityFromResultSet( ResultSet resultset ) throws SQLException{
	City city = new City( );
	city.setId( resultset.getInt(ID) );
	city.setName( resultset.getString(NAME) );
	return city;
}

public City getCity( int id ){

	try{
		PreparedStatement statement = database.getConnection( ).prepareStatement( "SELECT * FROM city WHERE id=?" );
		statement.setInt( 1, id );
		ResultSet rs = statement.executeQuery( );
		if( rs.next( ) ) return createCityFromResultSet( rs );
	}catch( SQLException e ){
		System.out.println( "Can't get the city: " + id );
		e.printStackTrace( );
	}finally{
		database.close( );
	}
	return new City( );
}

// getters and setters
public List<City> getAllCities( ){
	List<City> listOfCity = new ArrayList<>( );
	try{
		PreparedStatement statement = database.getConnection( ).prepareStatement( "SELECT * FROM city" );
		ResultSet rs = statement.executeQuery( );
		while( rs.next( ) ){
			listOfCity.add( createCityFromResultSet( rs ) );
		}
	}catch( SQLException e ){
		System.out.println( "Can't get the list of cities: " + e.getMessage( ) );
		e.printStackTrace( );
	}finally{
		database.close( );
	}
	return listOfCity;
}
}
