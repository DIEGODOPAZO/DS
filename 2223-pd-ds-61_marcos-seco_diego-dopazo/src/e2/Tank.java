package e2;

import java.util.ArrayList;
import java.util.List;

public class Tank {
    String name;
    String location;

    //Each Tank contains several sensors
    private List<Sensor> sensors;
    public String getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }



    Tank(String name, String location) {
        this.name = name;
        this.location = location;
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }


}
