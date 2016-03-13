package az.hackathon.validators;

import az.hackathon.utils.RequestUtil;

import javax.servlet.http.HttpServletRequest;

public class MealValidator{
RequestUtil util;
MealValidator( HttpServletRequest request){
	util = new RequestUtil( request );
}
boolean isValid(){
	return false;
}
}
