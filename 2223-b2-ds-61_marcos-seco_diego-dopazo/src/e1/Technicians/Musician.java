package e1.Technicians;

public class Musician extends e1.Technician{
    public Musician(String name, String surname, String id, int telephone, String nationality, float boxOffice, int hours){
        super.set(name, surname, id, telephone, nationality);

        royalties = (float)(0.04 * boxOffice);
        salary = 60 * hours  + royalties;

    }

    @Override
    public String toString(){
        return super.getName() + " " + super.getSurname() + " " + "(Musician): " +
                salary + " euro";
    }

    @Override
    public String toStringRoyalties(){
        return super.getName() + " " + super.getSurname() + " (Musician): " + royalties + " euros";
    }
}