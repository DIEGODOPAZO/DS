package e1;

public abstract class Artist extends Crew {
    /* Artists include actors, stunt performers and dubbers. They receive a salary. */
    protected float salary;


    public void set(String name, String surname, String id, int telephone, String nationality){
        super.set(name,surname,id,telephone,nationality);
    }

}
