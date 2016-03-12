package az.hackathon.database.helpers;

import az.hackathon.models.City;
import az.hackathon.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Qalib on 3/12/2016.
 */
public class UserHelper extends Helper{





    private static final String id = "id";
    private static final String username = "username";
    private static final String name = "name";
    private static final String phone = "phone";
    private static final String email = "email";
    private static final String password = "password";
    private static final String cityId = "city_id";
    private static final String isBlocked = "is_blocked";
    private static final String address = "address";
    private static final String numberOfComplains = "number_of_complains";


    private static void setValuesIntoPreparedStatement(PreparedStatement statement, User user) throws SQLException{
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPhone());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassword());
        statement.setInt(6, user.getCity().getId());
        statement.setBoolean(7, user.isBlocked());
        statement.setString(8, user.getAddress());
        statement.setInt(9, user.getNumberOfComplains());
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException{
        User user = new User();
        City city = new City();
        CityHelper ch = new CityHelper();
        user.setId(resultSet.getInt(id));
        user.setUsername(resultSet.getString(username));
        user.setName(resultSet.getString(name));
        user.setPhone(resultSet.getString(phone));
        user.setEmail(resultSet.getString(email));
        user.setPassword(resultSet.getString(password));
        city = ch.getCity(resultSet.getInt(cityId));
        user.setCity(city);
        user.setBlocked(resultSet.getBoolean(isBlocked));
        user.setAddress(resultSet.getString(address));
        user.setNumberOfComplains(resultSet.getInt(numberOfComplains));
        return user;
    }


    public User getUser(int id){
        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement( "SELECT * FROM user WHERE id=? " );
            statement.setInt( 1, id );
            ResultSet rs = statement.executeQuery( );
            if( rs.next( ) ) return createUserFromResultSet( rs );
        }catch( SQLException e ){
            System.out.println( "Can't get the user: " + id );
            e.printStackTrace( );
        }finally{
            database.close( );
        }
        return new User( );
    }

    public User getUser(String username1){
        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement( "SELECT * FROM user WHERE username=? " );
            statement.setString( 1, username1 );
            ResultSet rs = statement.executeQuery( );
            if( rs.next( ) ) return createUserFromResultSet( rs );
        }catch( SQLException e ){
            System.out.println( "Can't get the user: " + username );
            e.printStackTrace( );
        }finally{
            database.close( );
        }
        return new User( );
    }

    public User saveUser( User user ){
        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement( "INSERT INTO user VALUES(NULL,?,?,?,?,?,?,?,?,? )", Statement.RETURN_GENERATED_KEYS );
            setValuesIntoPreparedStatement( statement, user);
            statement.executeUpdate( );
            ResultSet generatedKeys = statement.getGeneratedKeys( );
            generatedKeys.next( );
            user.setId( generatedKeys.getInt( 1 ) );
        }catch( SQLException e ){
            System.out.println( "Can't save user: " + user );
            e.printStackTrace( );
        }finally{
            database.close( );
        }
        
        return user;
    }



}
