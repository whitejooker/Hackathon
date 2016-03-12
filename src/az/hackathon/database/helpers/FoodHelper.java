package az.hackathon.database.helpers;

import az.hackathon.models.Food;

import java.sql.*;
import java.util.Date;

/**
 * Created by Qalib on 3/12/2016.
 */
public class FoodHelper extends Helper{







    private static void setValuesIntoPreparedStatement(PreparedStatement statement, Food food) throws SQLException {
        statement.setString(1, food.getName());
        statement.setString(2, food.getDescription());
        statement.setDouble(3, food.getPrice());
        statement.setInt(4, food.getState());
        statement.setInt(5, food.getType().getId());
        statement.setInt(6, food.getAmount());
        statement.setBoolean(7, food.isActive());
        statement.setInt(8, food.getUser().getId());
        statement.setString(9, food.getPictureExtension());
    }

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String DATE = "date";
    private static final String STATE = "state";
    private static final String TYPE_ID = "type_id";
    private static final String AMOUNT = "amount";
    private static final String ISACTIVE = "is_active";
    private static final String USER_ID = "user_id";
    private static final String PICTURE_EXCEPTION = "picture_extension";

    private static Food createMealFromResultSet(ResultSet resultset) throws SQLException{
        Food food = new Food();
        TypeHelper typeHelper = new TypeHelper();
        UserHelper userHelper = new UserHelper();
        food.setId(resultset.getInt(ID));
        food.setName(resultset.getString(NAME));
        food.setDescription(resultset.getString(DESCRIPTION));
        food.setPrice(resultset.getDouble(PRICE));
        food.setDate(new Date(resultset.getTimestamp(DATE).getTime()));
        food.setState(resultset.getInt(STATE));
        food.setType(typeHelper.getType(resultset.getInt(TYPE_ID)));
        food.setAmount(resultset.getInt(AMOUNT));
        food.setActive(resultset.getBoolean(ISACTIVE));
        food.setUser(userHelper.getUser(resultset.getInt(USER_ID)));
        food.setPictureExtension(resultset.getString(PICTURE_EXCEPTION));
        return food;
    }

    public Food SaveFood(Food food){


        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement( "INSERT INTO meal VALUES(NULL,?,?,?,now(),?,?,?,?,?,? )", Statement.RETURN_GENERATED_KEYS );
            setValuesIntoPreparedStatement( statement, food);
            statement.executeUpdate( );
            ResultSet generatedKeys = statement.getGeneratedKeys( );
            generatedKeys.next( );
            food.setId( generatedKeys.getInt( 1 ) );
            }catch( SQLException e ){
                System.out.println( "Can't save food: " + food);
                e.printStackTrace( );
            }finally{
                database.close( );
            }
        return food;
    }


}
