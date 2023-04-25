package e1.ShoppingSteps;

import e1.Client;
import e1.Order;
import e1.Product;

import java.util.List;

public class ShoppingCart implements ShoppingState{
    private ShoppingCart(){}
    private static final ShoppingCart shoppingCartState = new ShoppingCart();

    public static ShoppingCart getState(){
        return shoppingCartState;
    }

    @Override
    public void addProduct(String product, int numberOfUnits, Order order){
        if(numberCartElements(order) == 0) {
            if(order.getLog().size() == 0){
                order.getLog().add("Order " + order.getOrderNumber() + ": Shopping phase");
            }else if (!order.getLog().get(order.getLog().size() - 1).equals("Order " + order.getOrderNumber() + ": Shopping phase")) {
                order.getLog().add("Order " + order.getOrderNumber() + ": Shopping phase");
            }
        }
        for(Product p: order.getProductList()){
            if(product.equals(p.getProductName())){
                if(p.getStock() >= numberOfUnits){
                    p.reduceStock(numberOfUnits);
                }else{
                    throw new IllegalArgumentException();
                }
                for(Product pro: order.getCartItems()){
                    if(product.equals(pro.getProductName())){
                        pro.addStock(numberOfUnits);
                        order.getLog().add("- Add: Item: " + product + " - Quantity: " + numberOfUnits + "-> Shopping cart -- Products : " +numberCartElements(order));
                        return;
                    }
                }
                Product itemToAdd = new Product(product, p.getPrice(), numberOfUnits);
                order.getCartItems().add(itemToAdd);
                order.getLog().add("- Add: Item: " + product + " - Quantity: " + numberOfUnits + "-> Shopping cart -- Products : " +numberCartElements(order));
                return;
            }

        }
        throw new IllegalArgumentException();
    }

    @Override
    public void goPreviousState(Order order){
        throw new IllegalArgumentException();
    }

    @Override
    public void goNextState(Order order){
        order.getLog().add("Order " + order.getOrderNumber() + ": Check out phase");
        order.setShoppingState(CheckOut.getState());
    }

    @Override
    public void screenInfo(Order order){
        int cartElements;
        System.out.println("Order number: " + order.getOrderNumber());

        if((cartElements = this.numberCartElements(order)) == 0){
            System.out.println("Phase Shopping: -- Welcome to online shop");
        }else{
            System.out.println("Phase: Shopping: -- " + cartElements + " products");
        }
    }

}
