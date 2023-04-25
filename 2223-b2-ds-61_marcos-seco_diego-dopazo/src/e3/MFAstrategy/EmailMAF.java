package e3.MFAstrategy;

public class EmailMAF implements MfaStrategy{
    @Override
    public String generateCode(){
        int ret;
        String retx = "";

        while(retx.length() < 4){
            //A random code of 4 numbers is generated
            ret = (int) (Math.random() * 10);
            retx += String.valueOf(ret);
        }

        return retx;
    }
}
