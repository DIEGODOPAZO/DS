package e2;

import java.util.Date;

public class Report {
    AlertType type;
    String tankName;
    String tankLocation;
    String alertName;
    String parameter;
    double level;
    Date timestamp;

    Report(AlertType type, String tankName, String tankLocation, String alertName,
           String parameter, double level, Date timestamp) {
        this.type = type;
        this.tankName = tankName;
        this.tankLocation = tankLocation;
        this.alertName = alertName;
        this.parameter = parameter;
        this.level = level;
        this.timestamp = timestamp;
    }

    AlertType getType() {
        return this.type;
    }

    String getTankName() {
        return this.tankName;
    }

    String getTankLocation() {
        return this.tankLocation;
    }

    String getAlertName() {
        return this.alertName;
    }

    String getParameter() {
        return this.parameter;
    }

    double getLevel() {
        return this.level;
    }

    Date getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString(){
        if(getType() == AlertType.RED){
            return "* RED Alert:\n" + getTankName() + ", "+ getTankLocation() + "\n"+ getAlertName() +": parameter " + getParameter() + ", level " +getLevel() + "\n" + getTimestamp();
        }else{
            return "* ORANGE Alert:\n" + getTankName() + ", "+ getTankLocation() + "\n"+ getAlertName() +": parameter " + getParameter() + ", level " +getLevel() + "\n" + getTimestamp();
        }
    }
}
