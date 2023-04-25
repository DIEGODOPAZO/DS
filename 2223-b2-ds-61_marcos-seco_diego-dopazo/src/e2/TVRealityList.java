package e2;

import java.util.Iterator;
import java.util.List;


public class TVRealityList implements Iterable<List <String>>{

    List<String> candidatesNames;
    boolean isCircular;

    public TVRealityList(List<String> candidatesNames, boolean isCircular){
        this.candidatesNames = candidatesNames;
        this.isCircular = isCircular;
    }
    @Override
    public Iterator iterator() {
        //It returns an iterator based on how the TVRealityList object is initialized
        if(isCircular)
            return new Circular(candidatesNames);
        else
            return new Rebound(candidatesNames);
    }

}
