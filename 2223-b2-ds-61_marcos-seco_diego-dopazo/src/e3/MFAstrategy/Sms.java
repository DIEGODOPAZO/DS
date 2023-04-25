package e3.MFAstrategy;

import java.util.Random;

public class Sms implements MfaStrategy{
   @Override
    public String generateCode(){
        int ret;
        String retx = "";
        int len = 6;

        Random random = new Random();
        //The code has a variable length between six and eight characters
        len += random.nextInt(2);

        while(retx.length() < len){
            //A random code is generated
            ret = (int) (Math.random() * 10);
            retx += String.valueOf(ret);
        }

        return retx;
    }
}
