package e2;

public class Alert extends Subject implements Observer {
    private String name;
    private Range redRange;
    private Range orangeRange;
    private AlertType type;

    //Alerts can be of type orange or red
    public String getName() {
        return name;
    }

    public Range getRedRange() {
        return redRange;
    }

    public Range getOrangeRange() {
        return orangeRange;
    }

    public AlertType getType() {
        return type;
    }

    Alert(String name, AlertType type, Range orangeRange, Range redRange) {
        this.name = name;
        this.type = type;
        this.redRange = redRange;
        this.orangeRange = orangeRange;
    }

    public void setType(AlertType type) {
        this.type = type;
    }



    @Override
    public void update(Subject s) {
        Sensor sensor = (Sensor) s;

        for (Alert o : sensor.getAlerts()) {
            if (getOrangeRange().contains(sensor.getValue())) {
                //NO PROBLEM
            } else if (!getOrangeRange().contains(sensor.getValue()) && getRedRange().contains(sensor.getValue())) {
                //ORANGE ALERT
                o.setType(AlertType.ORANGE);
                notifyControlDevices();
            } else {
                //RED ALERT
                o.setType(AlertType.RED);
                notifyControlDevices();
            }
        }

    }
}



