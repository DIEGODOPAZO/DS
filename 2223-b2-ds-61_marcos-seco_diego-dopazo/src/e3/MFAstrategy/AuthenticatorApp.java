package e3.MFAstrategy;

import java.util.Random;

public class AuthenticatorApp implements MfaStrategy {
    @Override
    public String generateCode() {
        String retx = "";
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!$%&@#";
        Random random = new Random();

        while (retx.length() < 8) {
            //An eight character String from random characters is generated
            retx += chars.charAt(random.nextInt(chars.length()));
        }

        return retx;
    }
}