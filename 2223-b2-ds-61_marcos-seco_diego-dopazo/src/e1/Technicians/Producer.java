package e1.Technicians;

public class Producer extends e1.Technician{
    public Producer(String name, String surname, String id, int telephone, String nationality, float boxOffice, int hours){
        super.set(name, surname, id, telephone, nationality);

        royalties = (float)(0.02 * boxOffice);
        salary = 90 * hours + royalties;

    }

    @Override
    public String toString(){
        return super.getName() + " " + super.getSurname() + " " + "(Producer): " +
                salary + " euro";
    }

    @Override
    public String toStringRoyalties(){
        return super.getName() + " " + super.getSurname() + " (Producer): " + royalties + " euros";
    }
}