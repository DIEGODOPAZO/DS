package e3;

import e3.MFAstrategy.MfaStrategy;

public class User{

    private MfaStrategy mfaStrategy;
    private String phone;
    private String username;
    private  String email;

    User(MfaStrategy mfaStrategy, String username, String email, String phone){
        this.mfaStrategy = mfaStrategy;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public void setMfaStrategy(MfaStrategy mfaStrategy){
        this.mfaStrategy = mfaStrategy;
    }
    public MfaStrategy getMfaStrategy(){
        return this.mfaStrategy;
    }



}
