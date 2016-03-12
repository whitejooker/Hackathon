package az.hackathon.database.helpers;

import az.hackathon.database.Database;

/**
 * Created by Qalib on 3/12/2016.
 */
public class Helper {

        protected Database database;

        public Helper( ){
            this( new Database( ) );
        }

        public Helper( Database db ){
            database = db;
        }

}
