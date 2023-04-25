package e2;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Alert> alerts = new ArrayList<>();
    private List<ControlDevice> controlDevices = new ArrayList<>();

    public void attach(Alert o){
        alerts.add(o);
    }
    public void detach(Alert o){ alerts.remove(o);}

    public void attachCD(ControlDevice o){ controlDevices.add(o); }
    public void detachCD(ControlDevice o){ controlDevices.remove(o); }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void notifyObservers(){
        for(Alert o : alerts)
            o.update(this);
    }
    public void notifyControlDevices(){
        for(ControlDevice o : controlDevices){
            o.update(this);
        }
    }

}
