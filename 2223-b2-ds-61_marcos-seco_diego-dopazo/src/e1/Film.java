package e1;

import java.util.ArrayList;
import java.util.List;

public class Film {
    /* Two lists are created to store the artists in one and the technicians in the other one */
    private final List <Technician> listTechnicians = new ArrayList<>();
    private final List <Artist> listArtists = new ArrayList<>();


    private float boxOffice;
    private String title;

    public void setboxOffice(float boxOffice){
        this.boxOffice = boxOffice;
    }
    public Film(String title, float boxOffice){
        if(boxOffice < 0 || title == null){
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.boxOffice = boxOffice;
        setboxOffice(boxOffice);

    }

    public float getBoxOffice(){
        return boxOffice;
    }

    /* Invalid arguments are checked so that the user does not insert an incorrect argument */

    private void nullInvalidArguments(String name, String surname, String id, int telephone, String nationality, int hours){
        if(name == null || surname == null || id == null || telephone < 0 || nationality == null || hours < 0){
            throw new IllegalArgumentException();
        }
    }

    /* A method is created to add each different individual to the lists */

    public void addActor(String name, String surname, String id, int telephone, String nationality, boolean protagonist, int hours){
        nullInvalidArguments(name,surname,id,telephone,nationality, hours);
        e1.Artists.Actor artist = new e1.Artists.Actor(name,surname,id,telephone,nationality,protagonist,hours);
        listArtists.add(artist);
    }
    public void addDubber(String name, String surname, String id, int telephone, String nationality, int hours){
        nullInvalidArguments(name,surname,id,telephone,nationality, hours);
        e1.Artists.Dubber artist = new e1.Artists.Dubber(name,surname,id,telephone,nationality,hours);
        listArtists.add(artist);
    }

    public void addStuntPerformer(String name, String surname, String id, int telephone, String nationality, boolean dangerousParticipation, int hours){
        nullInvalidArguments(name,surname,id,telephone,nationality, hours);
        e1.Artists.StuntPerformer artist = new e1.Artists.StuntPerformer(name,surname,id,telephone,nationality,dangerousParticipation,hours);
        listArtists.add(artist);
    }
    public void addDirector(String name, String surname, String id, int telephone, String nationality, int experience, float boxOffice, int hours){
        nullInvalidArguments(name,surname,id,telephone,nationality, hours);
        if(experience < 0){
            throw new IllegalArgumentException();
        }
        e1.Technicians.Director technician = new e1.Technicians.Director(name, surname, id, telephone, nationality, experience, getBoxOffice(), hours);
        listTechnicians.add(technician);
    }
    public void addMusician(String name, String surname, String id, int telephone, String nationality, float boxOffice, int hours){
        nullInvalidArguments(name,surname,id,telephone,nationality, hours);
        e1.Technicians.Musician technician = new e1.Technicians.Musician(name, surname, id, telephone, nationality, getBoxOffice(), hours);
        listTechnicians.add(technician);
    }
    public void addProducer(String name, String surname, String id, int telephone, String nationality,  float boxOffice, int hours){
        nullInvalidArguments(name,surname,id,telephone,nationality, hours);
        e1.Technicians.Producer technician = new e1.Technicians.Producer(name, surname, id, telephone, nationality, getBoxOffice(), hours);
        listTechnicians.add(technician);
    }
    public void addScreenwriter(String name, String surname, String id, int telephone, String nationality, boolean original, float boxOffice, int hours){
        nullInvalidArguments(name,surname,id,telephone,nationality, hours);
        e1.Technicians.Screenwriter technician = new e1.Technicians.Screenwriter(name, surname, id, telephone, nationality, original, getBoxOffice(), hours);
        listTechnicians.add(technician);
    }


    public String printSalaries(){
        StringBuilder salariesString = new StringBuilder();
        for(Technician i: listTechnicians){
            salariesString.append(i.toString()).append("\n");
        }
        for(Artist i: listArtists){
            salariesString.append(i.toString()).append("\n");
        }
        return salariesString.toString();
    }


    public String printRoyalties(){
        StringBuilder royaltiesString = new StringBuilder();
        for(Technician i: listTechnicians){
            royaltiesString.append(i.toStringRoyalties()).append("\n");
        }
        return royaltiesString.toString();
    }
}
