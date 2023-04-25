package e1.Technicians;

public class Director extends e1.Technician {
    private int experience;

    public void setExperience(int experience){
        this.experience = experience;
    }

    public Director(String name, String surname, String id, int telephone, String nationality, int experience, float boxOffice, int hours){
        super.set(name, surname, id, telephone, nationality);
        royalties = (float) (0.05 * boxOffice);
        /* Directors receive 1000 extra dollars per each year of experience. */
        salary = 100 * hours + 1000 * experience + royalties;
        setExperience(experience);

    }

    public int getExperience(){
        return experience;
    }



    @Override
    public String toString(){
        return super.getName() + " " + super.getSurname() + " " + "(" + "Director, " + getExperience() + " years of experience): " +
                salary + " euro";
    }

    @Override
    public String toStringRoyalties(){
        return super.getName() + " " + super.getSurname() + " (Director): " + royalties + " euros";
    }
}