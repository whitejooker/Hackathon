package az.hackathon;

public interface ApplicationConstants{
String PICTURE_UPLOAD_DIR = "S:\\web\\upload";
String JDBC_URI = "java:comp/env/jdbc/hackathon";

String JSP_LOGIN = "login.jsp";
String JSP_ABOUT = "about.jsp";
String JSP_REGISTRATION = "register.jsp";
String JSP_HOME_PAGE="homepage.jsp";
String JSP_ADD_FOOD = "add_food.jsp";
String JSP_VIEW_FOOD = "viewfood.jsp";
String JSP_ADD_FOOD_PAGE = "add_food.jsp";
String JSP_SEARCH = "search.jsp";
String JSP_MYFOODS = "myfoods.jsp";

String ATTR_MESSAGES = "messages";
String ATTR_ALL_CITIES = "allCities";
String ATTR_IS_LOGGED = "isLogged";
String ATTR_ABOUT = "isAboutPage";
String ATTR_IS_HOME_PAGE = "isHomePage";
String ATTR_IS_MY_FOOD_PAGE = "isMyFoodPage";
String ATTR_USER = "userLogged";
String ATTR_SUBMIT = "submit";
String ATTR_SELECTION = "selection";
String ATTR_MEALS = "foods";
String ATTR_FOOD = "food";
String ATTR_NUMBER_OF_FOOD = "numberOfFood";
String ATTR_CURRENT_PAGE_NUMBER = "currentPage";
String ATTR_SEARCH_RESULT = "searchResult";
String ATTR_MYFOODS = "myfoods";

int DEFAULT_TYPE_ID = 0;
int DEFAULT_CITY_ID = 0;
double DEFAULT_PRICE = 9999;
int DEFAULT_AMOUNT = 0;
int DEFAULT_STATE = 99999;
}
