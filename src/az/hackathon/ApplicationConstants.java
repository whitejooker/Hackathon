package az.hackathon;

public interface ApplicationConstants{
String JDBC_URI = "java:comp/env/jdbc/hackathon";

String JSP_REGISTRATION = "register.jsp";
String JSP_HOME_PAGE="home_page.jsp";

String ATTR_MESSAGES = "messages";
String ATTR_ALL_CITIES = "allCities";
String ATTR_IS_LOGGED = "isLogged";
String ATTR_USER = "userLogged";


int DEFAULT_CITY_ID = 1;
int DEFAULT_TYPE_ID = 1;
Double DEFAULT_PRICE = 999.9;
int DEFAULT_AMOUNT = 0;
int DEFAULT_STATE = 999;
}
