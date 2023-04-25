package e3.LoginStrategies;

public class Email implements LoginStrategy{
    @Override
    public boolean validateId(String id){
        if(id == null)
            return false;
        return id.contains("@");
    }

}
