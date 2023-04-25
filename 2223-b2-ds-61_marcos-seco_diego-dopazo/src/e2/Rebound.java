package e2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Rebound implements Iterator<String> {
    List <String> list;
    int position = 0;
    private boolean ascending = true;

    public Rebound(List<String> list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        //Check if there are at least 2 elements
        return this.list.size() > 1;
    }

    @Override
    public String next() {
        if(!hasNext()) //Return an empty String if it has no next element
            return "";
        if(ascending){
            if(position < list.size() - 1)
                position += 1;
            else{//If the last element of the list is reached it changes its direction
                position -= 1;
                ascending = false;
            }
        }else{
            if(position > 0)
                position -= 1;
            else{//If the first element is reached it goes the other way
                position += 1;
                ascending = true;
            }
        }
        return list.get(position);
    }

    @Override
    public void remove() {
        list.remove(position);
        if (!ascending && position != 0)
            /*If it is descending through the list then we go to the next element, it is done automatically
            * when going in ascending order*/
            next();
    }
}
