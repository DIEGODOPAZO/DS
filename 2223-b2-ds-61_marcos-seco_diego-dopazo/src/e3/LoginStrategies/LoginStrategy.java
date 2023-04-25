package e3.LoginStrategies;

import java.util.HashMap;

public interface LoginStrategy{
    boolean validateId(String id);

    default boolean authenticatePassword(String id, String password, HashMap<String, String> userLogin){
        if(!validateId(id)) //Check if it is a valid id
            return false;
        else{
            String mappedPassword = userLogin.get(id);
            /*Checks if it is a not null value and if it is equal to the one passed by the user, then it returns
             true or false in the other case*/
            return mappedPassword != null && mappedPassword.equals(password);
        }
    }
}
