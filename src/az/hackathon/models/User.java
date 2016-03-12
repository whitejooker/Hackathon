package az.hackathon.models;

import java.util.HashMap;
import java.util.Map;

public class User{
public static final int NUMBER_OF_ATTRIBUTES = 6;
public static final String ATTR_USERNAME = "username";
public static final String ATTR_NAME = "name";
public static final String ATTR_PHONE = "phone";
public static final String ATTR_EMAIL = "email";
public static final String ATTR_PASSWORD = "password";
public static final String ATTR_ADDRESS = "address";

Map<String, String> attributes=new HashMap<>(  );

public User( ){
}
}