package e1.ShoppingSteps;

import e1.Client;
import e1.Order;
import e1.Product;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Payment implements ShoppingState{

    private Payment(){}
    private static final Payment paymentState = new Payment();

    public static Payment getState(){
        return paymentState;
    }


    private float getTotalShopPrice(Order order){
        float totalPrice = 0;
        for(Product p: order.getCartItems()){
            totalPrice += p.getPrice() * p.getStock();
        }
        return totalPrice;
    }

    private boolean lessThanADay(Date paymentDate, Date currentDate){
        long milliseconds = currentDate.getTime() - paymentDate.getTime();
        long hours = TimeUnit.HOURS.convert(milliseconds, TimeUnit.MILLISECONDS);
        return (hours < 24);
    }
    @Override
    public void removeProduct(String product, int numberOfUnits, Order order){}

    @Override
    public void goPreviousState(Order order) {
        if(order.isPaid()){
            Date currentDate = new Date();
            if(lessThanADay(order.getPaymentDate(), currentDate)){
                float totalPrice = getTotalShopPrice(order);
                order.getCartItems().clear();
                order.getClient().getReturnMoney(totalPrice);
                order.setPayment(0);
                order.setIsPaid(false);
                order.getLog().add("Order " + order.getOrderNumber() + ": Cancelled");
                order.setShoppingState(Cancelled.getState());
            }else{
                order.getLog().add("Order " + order.getOrderNumber() + ": Completed");
                order.setShoppingState(Completed.getState());
            }
        }else{
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void goNextState(Order order) {
        if(!order.isPaid()){
            float totalPrice = getTotalShopPrice(order);
            float payment;
            if((payment = order.getClient().payment(totalPrice)) != -1){
                order.setPayment(payment);
                order.getLog().add("- Payment done: " + payment + " for " + numberCartElements(order) + " items");
                order.setIsPaid(true);
                order.setPaymentDate(new Date());
            }else{
                throw new IllegalArgumentException();
            }
        }else{

            order.getLog().add("Order " + order.getOrderNumber() + ": Completed");
            order.setShoppingState(Completed.getState());

        }

    }

    @Override
    public void screenInfo(Order order){
        System.out.println("Order number: " + order.getOrderNumber());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        if(order.isPaid()){
            System.out.println("Phase: Paid order: " + numberCartElements(order) + " products" + formatter.format(order.getPaymentDate()));
        }else{
            System.out.println("Phase: Payment (not paid yet)");
        }
    }

}
