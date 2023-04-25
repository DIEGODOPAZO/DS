package e1.Artists;

public class Dubber extends e1.Artist {

    public Dubber(String name, String surname, String id, int telephone, String nationality, int hours){
        super.set(name, surname, id, telephone, nationality);

        salary = 20 * hours;

    }

    @Override
    public String toString(){
        return super.getName() + " " + super.getSurname() + " " + "(Dubber): " +
                salary + " euro";
    }

}
