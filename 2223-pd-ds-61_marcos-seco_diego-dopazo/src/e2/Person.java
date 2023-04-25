package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Person {
    private String name;
    private List<Alert> subscribedAlerts;

    //The reports are stored in a priority queue (depending on the type of alert).
    PriorityQueue<Report> reports;

    public Person(String name){
        this.name = name;
        this.subscribedAlerts = new ArrayList<>();
        this.reports = new PriorityQueue<>(
                (r1, r2) -> r1.getType().compareTo(r2.getType()));
    }

    public String getName() {
        return name;
    }

    public List<Alert> getSubscribedAlerts() {
        return subscribedAlerts;
    }
    public void subscribeToAlert(Alert alert){
        this.subscribedAlerts.add(alert);
    }

    void addReport(Report report) {
        this.reports.add(report);
    }
    public List<Report> getReports() {
        return new ArrayList<>(this.reports);
    }


}
