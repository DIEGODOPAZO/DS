package e2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Circular implements Iterator<String> {

    List<String> list;
    int position = 0;

    public Circular(List<String> list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        //Check if there are at least 2 elements
        return list.size() > 1;
    }

    @Override
    public String next() {

        if(!hasNext()) //Return an empty String if it has no next element
            return "";

        if(position < list.size() - 1) {
            position += 1;
        }else{ //If the end of the list is reached it goes back to the first element
            position = 0;
        }
        return list.get(position);
    }

    @Override
    public void remove() {
        list.remove(position);
        if(position == list.size())
            //If the removed element is at the end, it goes back to the first element of the list
            next();
    }
}
