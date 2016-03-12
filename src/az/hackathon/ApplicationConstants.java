package az.hackathon;

public interface ApplicationConstants{
String JDBC_URI = "java:comp/env/jdbc/hackathon";

String JSP_LOGIN = "login.jsp";
String JSP_REGISTRATION = "register.jsp";
String JSP_HOME_PAGE="homepage.jsp";

String ATTR_MESSAGES = "messages";
String ATTR_ALL_CITIES = "allCities";
String ATTR_IS_LOGGED = "isLogged";
String ATTR_USER = "userLogged";
String ATTR_SUBMIT = "submit";
String ATTR_SELECTION = "selection";
String ATTR_MEALS = "foods";

int DEFAULT_TYPE_ID = 1;
int DEFAULT_CITY_ID = 1;
double DEFAULT_PRICE = 9999;
int DEFAULT_AMOUNT = 0;
int DEFAULT_STATE = 99999;
}
