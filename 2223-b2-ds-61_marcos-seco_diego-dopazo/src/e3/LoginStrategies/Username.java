package e3.LoginStrategies;

public class Username implements LoginStrategy{
    public boolean validateId(String id){
        return id != null && id.length() < 24 && !id.contains(" ");
    }
}
