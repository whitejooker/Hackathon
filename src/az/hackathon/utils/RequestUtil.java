package az.hackathon.utils;

import az.hackathon.models.User;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public final static String PARAM_USERNAME = "username";
    public final static String PARAM_PASSWORD = "password";
    public final static String PARAM_PASSWORD_CONFIRM = "password_confirm";
    public final static String PARAM_PHONE = "phone";
    public final static String PARAM_EMAIL = "email";
    public final static String PARAM_NAME = "name";
    public final static String PARAM_CITY_ID = "city_id";
    public final static String PARAM_ACTION = "action";
    public final static String PARAM_STATE = "state";
    public final static String PARAM_AMOUNT = "state";
    public final static String PARAM_PRICE = "price";
    public final static String PARAM_TYPE_ID = "type_id";
    public final static String PARAM_ADDRESS = "address";
    public static final String PARAM_PICTURE = "picture";
    public static final String PARAM_ID = "id";
    public static final String PARAM_DESCRIPTION = "description";
    public static final String PARAM_SEARCH_STRING = "search";
    public static final String PARAM_REMOVE_ID = "id";

    public HttpServletRequest request;

    public RequestUtil(HttpServletRequest request) {
        this.request = request;
    }

    public String getXSSsafeStringFromRequest(String parameterName) {
        String value = request.getParameter(parameterName);
        if (value == null) value = "";
        else value = StringEscapeUtils.escapeHtml4(value.trim());
        return value;
    }
}