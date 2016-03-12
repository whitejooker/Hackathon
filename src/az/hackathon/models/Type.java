package az.hackathon.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qalib on 3/12/2016.
 */
public class Type{
public static int NUMBER_OF_TYPES = 4;
public static final List<Type> allTypes = new ArrayList<>( NUMBER_OF_TYPES );

static{
	allTypes.add( new Type( 0, "curial", 999 ) );
	allTypes.add( new Type( 1, "milky", 999 ) );
	allTypes.add( new Type( 2, "fruit", 999 ) );
	allTypes.add( new Type( 3, "plastic", 999 ) );
}

private int id;
private String name;
private int maxState;

public Type( ){
}

public Type( int id, String name, int maxState ){
	this.id = id;
	this.name = name;
	this.maxState = maxState;
}

// getters and setters
public int getId( ){
	return id;
}

public void setId( int id ){
	this.id = id;
}

public int getMaxState( ){
	return maxState;
}

public void setMaxState( int maxState ){
	this.maxState = maxState;
}

public String getName( ){
	return name;
}

public void setName( String name ){
	this.name = name;
}

// overridden
@Override
public String toString( ){
	return "Type{" +
			"id=" + id +
			", name='" + name + '\'' +
			", maxState=" + maxState +
			'}';
}

}
