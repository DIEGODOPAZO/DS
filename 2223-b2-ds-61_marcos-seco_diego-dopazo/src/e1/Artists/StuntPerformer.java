package e1.Artists;

public class StuntPerformer extends e1.Artist {

    private boolean dangerousParticipation;
    public void setDangerousParticipation(boolean dangerousParticipation){
        this.dangerousParticipation= dangerousParticipation;
    }

    public StuntPerformer(String name, String surname, String id, int telephone, String nationality, boolean dangerousParticipation, int hours){
        super.set(name, surname, id, telephone, nationality);

        salary = 40 * hours;
        /*Stunt performers who participate in dangerous acts, receive a greater compensation. */
        if(dangerousParticipation){
            salary += 1000;
        }
        setDangerousParticipation(dangerousParticipation);
    }

    public boolean getDangerousParticipation(){
        return dangerousParticipation;
    }

    @Override
    public String toString(){
        if(getDangerousParticipation()) {
            return super.getName() + " " + super.getSurname() + " (Stunt performer with extra for danger): " +
                    salary + " euro";
        }else{
            return super.getName() + " " + super.getSurname() + " (Stunt performer with no extra for danger): " +
                    salary + " euro";
        }
    }

}
