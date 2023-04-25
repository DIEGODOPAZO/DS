package e1.ShoppingSteps;

import e1.Client;
import e1.Order;
import e1.Product;

import java.util.List;

public class Cancelled implements ShoppingState{


    private Cancelled(){}
    private static final Cancelled cancelledState = new Cancelled();

    public static Cancelled getState(){
        return cancelledState;
    }

    @Override
    public void removeProduct(String product, int numberOfUnits, Order order){throw new IllegalArgumentException();}
    @Override
    public void screenInfo(Order order){
        System.out.println("Order number: " + order.getOrderNumber());
        System.out.println("Phase: Cancelled order" );
    }

}
