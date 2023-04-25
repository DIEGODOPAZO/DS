package e1.Technicians;

public class Screenwriter extends e1.Technician{
    private boolean original;

    public void setOriginal(boolean original){
        this.original = original;
    }
    public Screenwriter(String name, String surname, String id, int telephone, String nationality, boolean original, float boxOffice, int hours){
        super.set(name, surname, id, telephone, nationality);
        royalties = (float)(0.05 * boxOffice);
        salary = 70 * hours + royalties;
        /*Screenwriters will receive an extra of e4000 if the script is an original screenplay. */
        if(original){
            salary += 4000;
        }
        setOriginal(original);

    }

    public boolean getOriginal(){
        return original;
    }

    //Mirar como meter si es original o no, puede que esto funcione
    @Override
    public String toString(){
        if(getOriginal()) {
            return super.getName() + " " + super.getSurname() + " " + "(Screenwriter, original screenplay): " +
                    salary + " euro";
        }else{
            return super.getName() + " " + super.getSurname() + " (Screenwriter) " +
                    salary + " euro";
        }
    }

    @Override
    public String toStringRoyalties(){
        return super.getName() + " " + super.getSurname() + " (Screenwriter): " + royalties + " euros";
    }
}