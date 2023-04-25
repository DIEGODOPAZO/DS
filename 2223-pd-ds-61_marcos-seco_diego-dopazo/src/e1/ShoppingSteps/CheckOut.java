package e1.ShoppingSteps;

import e1.Client;
import e1.Order;
import e1.Product;

import java.util.List;

public class CheckOut implements ShoppingState{

    private CheckOut(){}
    private static final CheckOut checkOutState = new CheckOut();

    public static CheckOut getState(){
        return checkOutState;
    }

    @Override
    public void goPreviousState(Order order){
        order.getLog().add("Order " + order.getOrderNumber() + ": Shopping phase");
        order.setShoppingState(ShoppingCart.getState());
    }

    @Override
    public void goNextState(Order order){
        order.getLog().add("Order " + order.getOrderNumber() + ": Payment phase");
        order.setShoppingState(Payment.getState());
    }

    @Override
    public void screenInfo(Order order){
        System.out.println("Order number: " + order.getOrderNumber());
        System.out.println("Phase: Check out: -- " + numberCartElements(order) + " products");

    }

}
