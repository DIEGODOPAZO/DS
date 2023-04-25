package e1.Artists;

public class Actor extends e1.Artist {

    private boolean protagonist;
    public void setProtagonist(boolean protagonist){
        this.protagonist = protagonist;
    }

    public Actor(String name, String surname, String id, int telephone, String nationality, boolean protagonist, int hours){
        super.set(name, surname, id, telephone, nationality);

        salary = 200 * hours;
        /*Actors can be protagonist or secondary artists, if they are the protagonists they receive a bigger salary. */
        if(protagonist){
            salary *= 3;
        }
        setProtagonist(protagonist);
    }

    public boolean getProtagonist(){
        return protagonist;
    }

    @Override
    public String toString(){
        if(getProtagonist()){
            return super.getName() + " " + super.getSurname() + " " + "(Actor protagonist): " +
                    salary + " euro";
        }else {
            return super.getName() + " " + super.getSurname() + " " + "(Actor secondary): " +
                    salary + " euro";
        }
    }



}
