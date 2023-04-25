package e1.ShoppingSteps;

import e1.Client;
import e1.Order;
import e1.Product;

import java.util.List;

public class Completed implements ShoppingState{

    private Completed(){}
    private static final Completed completedState = new Completed();

    public static Completed getState(){
        return completedState;
    }

    @Override
    public void removeProduct(String product, int numberOfUnits, Order order){throw new IllegalArgumentException();}
    @Override
    public void goPreviousState(Order order){throw new IllegalArgumentException();}
    @Override
    public void goNextState(Order order){throw new IllegalArgumentException();}
    @Override
    public void screenInfo(Order order){
        System.out.println("Order number: " + order.getOrderNumber());
        System.out.println("Phase: Completed order: -- " + numberCartElements(order) + " products");
    }

}
