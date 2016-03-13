package az.hackathon.database.helpers;

import az.hackathon.ApplicationConstants;
import az.hackathon.models.Food;
import az.hackathon.models.Selection;
import az.hackathon.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Food getFood(int id){
        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement( "SELECT * FROM meal WHERE id=? " );
            statement.setInt( 1, id );
            ResultSet rs = statement.executeQuery( );
            if( rs.next( ) ) return createMealFromResultSet( rs );
        }catch( SQLException e ){
            System.out.println( "Can't get the food: " + id );
            e.printStackTrace( );
        }finally{
            database.close( );
        }
        return new Food();
    }

    public Food saveFood(Food food){


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

    public void updateFood(Food food){

        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement( "UPDATE meal SET" +
                    " name = ?, description=?, price=?, state=?, type_id=?, amount=?, is_active=?, user_id=?, picture_extension=? WHERE id=?" );
            setValuesIntoPreparedStatement(statement, food);
            statement.setInt( 10, food.getId( ) );
            statement.executeUpdate( );
        }catch( SQLException e ){
            System.out.println( "Can't update a user " + food);
            e.printStackTrace( );
        }finally{
            database.close( );
        }

    }

    public List<Food> getAllFoodBySelection(Selection selection, int currentPage){
        List<Food> listOfFood = new ArrayList<>();
        try {
            String query = selection.getSQL();
            int flag_city = -1;
            int flag_type = -1;
            int flag_limit = -1;
            if(selection.getCity().getId()!= ApplicationConstants.DEFAULT_CITY_ID){
                query = query + " and c.id=?";
                flag_city = 4;
            }

            if(selection.getType().getId()!= ApplicationConstants.DEFAULT_TYPE_ID){
                query = query + " and m.type_id=?";
                if(flag_city>0){
                    flag_type = flag_city + 1;
                }
                else{
                    flag_type = 4;
                }
            }

            query = query + " order by m.date limit ?, ?";
            if(flag_city>0 && flag_type>0){
                flag_limit = 6;
            }
            else if(flag_city>0 || flag_type>0){
                flag_limit = 5;
            }
            else{
                flag_limit = 4;
            }


            PreparedStatement statement = database.getConnection().prepareStatement(query);

            selection.setValuesToStatement(statement);
            System.out.println("Here price = " + selection.getPrice());
            if(flag_city>0) { statement.setInt(flag_city, selection.getCity().getId()); }
            if(flag_type>0) { statement.setInt(flag_type, selection.getType().getId()); }
            statement.setInt(flag_limit, (currentPage-1)*9);
            statement.setInt(flag_limit + 1, 9);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                listOfFood.add(createMealFromResultSet(resultSet));
            }


        }catch (Exception e){
            System.out.println("Can't get Food by selection : " + selection);
        }finally{
            database.close();
        }
        return listOfFood;
    }

    public int getNumberOfFood(){
       int numberOfFood = 0;
        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement("select count(id) from meal where is_active=?");
            statement.setBoolean(1, true);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) { numberOfFood = rs.getInt(1);}
        }catch( SQLException e){
            System.out.println( "Can't find number of food " + e.getMessage() );
            e.printStackTrace( );
        }finally{
            database.close( );
        }
        return numberOfFood;
    }

    public List<Food> SeaarchFoodByWord(String searchstring){
        List<Food> listOfFood = new ArrayList<>();
        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement("select * from meal where is_active=? and ( lower(name) like '%" + searchstring.toLowerCase() + "%' or lower(description) like '%" + searchstring.toLowerCase() + "%' )" );
            statement.setBoolean(1, true);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                listOfFood.add(createMealFromResultSet(rs));
            }
        }catch( SQLException e){
            System.out.println( "Can't find number of food " + e.getMessage() );
            e.printStackTrace( );
        }finally{
            database.close( );
        }
        return listOfFood;
    }



    public List<Food> SeaarchFoodByUser(User user){
        List<Food> listOfFood = new ArrayList<>();
        try{
            PreparedStatement statement = database.getConnection( ).prepareStatement("select * from meal where is_active=? and user_id=?" );
            statement.setBoolean(1, true);
            statement.setInt(2, user.getId() );
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                listOfFood.add(createMealFromResultSet(rs));
            }
        }catch( SQLException e){
            System.out.println( "Can't find number of food " + e.getMessage() );
            e.printStackTrace( );
        }finally{
            database.close( );
        }
        return listOfFood;
    }

}
