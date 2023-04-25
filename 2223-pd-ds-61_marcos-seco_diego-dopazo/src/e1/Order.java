package e1;

import e1.ShoppingSteps.Payment;
import e1.ShoppingSteps.ShoppingCart;
import e1.ShoppingSteps.ShoppingState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private ShoppingState orderState = ShoppingCart.getState();
    private final int orderNumber;
    private boolean isPaid = false;
    private Date paymentDate = null;
    private float payment;
    private Client client;
    private List<Product> productList;
    private List<String> log = new ArrayList<>();

    private List<Product> cartItems = new ArrayList<>();

    Order(int orderNumber, Client client, List<Product> productList){
        this.orderNumber = orderNumber;
        this.client = client;
        this.productList = productList;
    }


    //getters y setters

    public List<Product> getProductList(){
        return productList;
    }

    public List<String> getLog(){
        return log;
    }

    public boolean isPaid(){
        return isPaid;
    }

    public void setIsPaid(boolean isPaid){
        this.isPaid = isPaid;
    }
    public void setPaymentDate(Date paymentDate){
        this.paymentDate = paymentDate;
    }
    public Date getPaymentDate(){
        return paymentDate;
    }
    public List<Product> getCartItems(){
        return cartItems;
    }
    public float getPayment(){
        return payment;
    }
    public Client getClient(){
        return client;
    }

    public int getOrderNumber(){
        return orderNumber;
    }
    public void setPayment(float payment){
        this.payment = payment;
    }

    public void printLog(){
        for(String s: log){
            System.out.println(s);
        }
    }



    //states functions
    public void addProduct(String product, int numberOfUnits){
            orderState.addProduct(product, numberOfUnits, this);
    }

    public void removeProduct(String product, int numberOfUnits){
        orderState.removeProduct(product, numberOfUnits, this);
    }

    public void nextState(){
        orderState.goNextState(this);
    }

    public void previousState(){
        orderState.goPreviousState(this);
    }

    public void screenInfo(){
        orderState.screenInfo(this);
    }
    public void setShoppingState(ShoppingState state){
        orderState = state;
    }


}
