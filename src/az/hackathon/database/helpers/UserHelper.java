package az.hackathon.database.helpers;

import az.hackathon.models.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Qalib on 3/12/2016.
 */
public class UserHelper extends Helper{



    private static void setValuesIntoPreparedStatement(PreparedStatement statement, User user) throws SQLException{
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPhone());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassword());
        statement.setInt(6, user.getCity().getId());
        statement.setBoolean(7, user.isBlocked());
        //statement.set

    }
}
