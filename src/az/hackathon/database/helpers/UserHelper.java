package az.hackathon.database.helpers;

import az.hackathon.models.City;
import az.hackathon.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    private User CreateUserFromResultSet(ResultSet resultSet) throws SQLException{
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




}
