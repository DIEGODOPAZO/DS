package e3;

import e3.LoginStrategies.Email;
import e3.LoginStrategies.TelephoneNumber;
import e3.LoginStrategies.Username;
import e3.MFAstrategy.AuthenticatorApp;
import e3.MFAstrategy.EmailMAF;
import e3.MFAstrategy.Sms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginScreenTest {
    Email email = new Email();
    TelephoneNumber phone = new TelephoneNumber();
    Username username = new Username();


    AuthenticatorApp app = new AuthenticatorApp();
    EmailMAF emailMfa = new EmailMAF();
    Sms sms = new Sms();
    LoginScreen login = new LoginScreen(email);



    @Test
    void login(){
        assertFalse(login.authenticatePassword());
        login.setId("marcos.seco.anderson@udc.es");
        login.setPassword("perro512");
        assertTrue(login.authenticatePassword());
        assertEquals(4, login.generateCode().length());
        login.setPassword("incorectPasswor");
        assertFalse(login.authenticatePassword());
        assertNull(login.generateCode());
        login.setId(null);
        login.setPassword(null);
        assertFalse(login.authenticatePassword());

        login.setId("665123987");
        login.setPassword("perro512");
        assertFalse(login.authenticatePassword());
        assertFalse(login.loginStrategy.validateId("665123987"));
        login.setLoginStrategy(phone);
        assertTrue(login.authenticatePassword());
        assertTrue(6 <= login.generateCode().length() &&  8 >= login.generateCode().length());
        login.setId(null);
        login.setPassword(null);
        assertFalse(login.authenticatePassword());
        assertFalse(login.loginStrategy.validateId("66512W987"));
        assertFalse(login.authenticatePassword());

        login.setLoginStrategy(username);
        login.setId(null);
        login.setPassword(null);
        assertFalse(login.authenticatePassword());

        login.setId("diegoDopa");
        login.setPassword("gato52");
        assertTrue(login.authenticatePassword());
        login.setMfaStrategy(app);
        login.setMfaStrategy(emailMfa);
        assertEquals(4, login.generateCode().length());
        login.setMfaStrategy(sms);
        assertTrue(6 <= login.generateCode().length() && 8 >= login.generateCode().length() );
        login.setMfaStrategy(app);
        assertEquals(8, login.generateCode().length());

        //this user is not at the userMFA HashMap
        login.setId("DDG");
        login.setPassword("1234");
        login.setLoginStrategy(username);
        assertTrue(login.authenticatePassword());
        assertNull(login.generateCode());

    }

}