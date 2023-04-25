package e3.LoginStrategies;

public class TelephoneNumber implements LoginStrategy{

    @Override
    public boolean validateId(String id){
        try {
            if (id == null || id.length() != 9)//Check that it is not null and has the correct length
                return false;
            else { //If it is a positive number it returns true, false if it is negative
                int phone = Integer.parseInt(id);

                return phone >= 0;
            }
        }catch(NumberFormatException e){//If it is not a number we return false
            return false;
        }
    }

}
