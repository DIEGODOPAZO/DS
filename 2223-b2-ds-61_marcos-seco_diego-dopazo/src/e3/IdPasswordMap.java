package e3;

import e3.MFAstrategy.AuthenticatorApp;
import e3.MFAstrategy.EmailMAF;
import e3.MFAstrategy.Sms;

import java.util.HashMap;

public class IdPasswordMap {

    /*These HashMaps are used as a database the first one for the logins and the passwords
    and the second one to relate the users with their MFAStrategy*/

    private HashMap<String,String> userlogin = new HashMap<>();
    private HashMap<String, User> userMfa = new HashMap<>();

    IdPasswordMap(){
        userlogin.put("marcos.seco.anderson@udc.es", "perro512");
        EmailMAF email = new EmailMAF();
        User u0 = new User(email, "marcSEco", "marcos.seco.anderson@udc.es", "657456745" );
        userMfa.put("marcos.seco.anderson@udc.es", u0);

        userlogin.put("diegoDopa", "gato52");
        AuthenticatorApp app = new AuthenticatorApp();
        User u1 = new User(app, "diego@gmail", "diegoDopa", "768567656");
        userMfa.put("diegoDopa", u1);

        userlogin.put("665123987", "perro512");
        Sms sms = new Sms();
        User u2 = new User(sms, "correo@gmail.com", "manolito", "665123987");
        userMfa.put("665123987", u2);

        userlogin.put("DDG", "1234");

    }
    public HashMap <String, String> getUserLogin(){
        return userlogin;
    }
    public HashMap <String, User> getUserMfa(){
        return userMfa;
    }
}
