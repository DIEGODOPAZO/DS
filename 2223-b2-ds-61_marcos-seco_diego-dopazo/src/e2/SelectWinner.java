package e2;

import java.util.Iterator;

public class SelectWinner {

    public static String selectCandidates(TVRealityList list, int k){
        Iterator t = list.iterator();
        if(k <= 0 || list.candidatesNames.size() == 0)
            throw new IllegalArgumentException("Invalid parameters");

        k -= 1;
        int w = k;

        while(t.hasNext()){//This continues until there is only one element left
            if(w == 0){//If has counted k number of iterations it removes the element that it has just iterated through
                t.remove();
                w = k;
            }else{//Else it goes to the next element and the counter is decreased
                t.next();
                w -= 1;
            }

        }
        return list.candidatesNames.get(0);
    }
}
