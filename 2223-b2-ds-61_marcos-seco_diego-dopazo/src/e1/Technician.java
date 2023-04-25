package e1;

public abstract class Technician extends Crew {
    /* Technicians include screenwriters, musiciands, producers and the director.
    *  Technicians like Artists receive a salary, however they also receive royalties. */
    protected float salary;
    protected float royalties;


    public void set(String name, String surname, String id, int telephone, String nationality){
        super.set(name,surname,id,telephone,nationality);
    }

    public String toStringRoyalties(){return "";}
}


