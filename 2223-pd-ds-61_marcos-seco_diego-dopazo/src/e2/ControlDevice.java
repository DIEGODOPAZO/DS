package e2;

public class ControlDevice implements Observer{

    private Sensor sensor;
    private Aquarium aquarium;
    private Tank tank;

    public Aquarium getAquarium() {
        return aquarium;
    }
    public Sensor getSensor() {
        return sensor;
    }


    public ControlDevice(Sensor sensor, Aquarium aquarium, Tank tank){
        this.sensor = sensor;
        this.aquarium = aquarium;
        this.tank = tank;

    }




    @Override
    public void update(Subject s) {
        Alert alert = (Alert) s;

        if ((alert.getType() == AlertType.ORANGE || alert.getType() == AlertType.RED) && getSensor().getAlerts().contains(alert)){
            getAquarium().writeReports(tank, sensor, alert);
            float newValue = (float) (alert.getOrangeRange().min + Math.random() * (alert.getOrangeRange().max - alert.getOrangeRange().min));
            getSensor().setValue(newValue);
        }
    }
}

