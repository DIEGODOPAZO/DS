package e2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aquarium {
    List<Tank> tanks;

    List<Person> personnel;

    Aquarium() {
        this.tanks = new ArrayList<>();
        this.personnel = new ArrayList<>();
    }

    void addTank(Tank tank) {
        this.tanks.add(tank);
    }



    void addPerson(Person person) {
        this.personnel.add(person);
    }


    void writeReports(Tank tank, Sensor sensor, Alert alert) {
        for (Person person : this.personnel) {
            //When an alert is fired, a report is added for the subscribed personnel
            if (person.getSubscribedAlerts().contains(alert)) {
                Report report = new Report(
                        alert.getType(),
                        tank.getName(),
                        tank.getLocation(),
                        alert.getName(),
                        sensor.getParameter(),
                        sensor.getValue(),
                        new Date()
                );
                person.addReport(report);
            }
        }
    }

    void printReports(){
        for(Person person : this.personnel){
            System.out.println("\nAlerts of " + person.getName() + "\n");
            List<Report> reports = person.getReports();
            for(Report report : reports){
                System.out.println(report.toString());
            }
        }
    }




}
