package e3;

import e3.LoginStrategies.LoginStrategy;
import e3.MFAstrategy.MfaStrategy;

import java.util.HashMap;

public class LoginScreen {
    private final IdPasswordMap uL = new IdPasswordMap();
    private final HashMap<String, String> userLogin = uL.getUserLogin();
    private final HashMap<String, User> userMfa = uL.getUserMfa();
    private String id, password;

    LoginStrategy loginStrategy;

    LoginScreen(LoginStrategy loginStrategy){
        this.loginStrategy = loginStrategy;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setLoginStrategy(LoginStrategy loginStrategy){
        this.loginStrategy = loginStrategy;

    }

    public boolean authenticatePassword(){
        //The authenticatePassword method calls the validateId method, so it validates both: the id and the password.
        return this.loginStrategy.authenticatePassword(this.id, this.password, this.userLogin);
    }


    public void setMfaStrategy(MfaStrategy mfaStrategy){
        if(authenticatePassword()){//Only the user can change his MFAStrategy
            User user = userMfa.get(this.id);
            if(user != null)
                user.setMfaStrategy(mfaStrategy);
        }

    }

    public String generateCode(){
        if (authenticatePassword()){//if it is the correct password
            User user = userMfa.get(this.id);
            if(user != null) { //If the user exists we generate the code
                return user.getMfaStrategy().generateCode();
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
