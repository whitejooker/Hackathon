package az.hackathon.database;

import az.hackathon.ApplicationConstants;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Qalib on 3/12/2016.
 */
public class Database{

    private Connection connection;

    public Database( ){
        try{
            getConnection( );
        }catch( SQLException e ){
            System.out.println( "Can't create a Database object" + e.getMessage());
            e.printStackTrace( );
        }
    }

    public void close( ){
        try{
            if( connection != null && !connection.isClosed( ) ){
                connection.commit( );
                connection.close( );
            }
        }catch( SQLException e ){
            System.out.println( "Can't close connection" );
            e.printStackTrace( );
        }
    }

    // getters and setters
    public synchronized Connection getConnection( ) throws SQLException{
        if(connection!=null){
            connection.close();
        }
        if( connection == null || connection.isClosed( ) ){
            try{
                Context context = new InitialContext( );
                DataSource dataSource = (DataSource) context.lookup( ApplicationConstants.JDBC_URI );
                connection = dataSource.getConnection( );
                connection.setAutoCommit( false );
            }catch( NamingException e ){
                System.out.println( "Can't get a connection" );
                e.printStackTrace( );
            }
        }
        return connection;
    }
}