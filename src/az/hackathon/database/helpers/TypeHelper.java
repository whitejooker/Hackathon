package az.hackathon.database.helpers;

import az.hackathon.models.Type;

import java.util.List;

/**
 * Created by Qalib on 3/12/2016.
 */
public class TypeHelper extends Helper {
    public Type getType(int id){
        Type type = new Type();
        for(Type t : Type.allTypes){
            if(t.getId() == id){
                type = t;
                break;
            }
        }
        return type;
    }
    public List<Type> getAllTypes(){
        return Type.allTypes;
    }
}
