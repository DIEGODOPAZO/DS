package e2;

public class Sensor extends Subject{

    private float value;
    private String parameter;

    public String getParameter() {
        return parameter;
    }
    public float getValue(){
        return value;
    }


    public Sensor(String parameter){
        this.parameter = parameter;
        this.value = 0;
    }

    public void setValue(float value) {
        this.value = value;
        notifyObservers();
    }

}
