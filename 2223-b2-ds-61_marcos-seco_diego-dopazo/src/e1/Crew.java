package e1;

public abstract class Crew {
    /* The Crew consists of members that are identified by name, surname, id,
    * telephone and nationality. */
    private String name;
    private String surname;
    private String id;
    private int telephone;
    private String nationality;

    public void set(String name, String surname, String id, int telephone, String nationality) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.telephone = telephone;
        this.nationality = nationality;
    }

   public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

}