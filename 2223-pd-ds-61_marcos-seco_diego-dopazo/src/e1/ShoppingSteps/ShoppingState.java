package e1.ShoppingSteps;

import e1.Client;
import e1.Order;
import e1.Product;

import java.util.ArrayList;
import java.util.List;

public interface ShoppingState {


    default void addProduct(String product, int numberOfUnits, Order order){
        throw new IllegalArgumentException();
    }

    default void removeProduct(String product, int numberOfUnits, Order order){
        if(numberOfUnits < 0){
            throw new IllegalArgumentException();
        }
        for(Product p: order.getCartItems()){
           if(product.equals(p.getProductName())){
               if(order.getProductList().contains(p)){
                   if(p.getStock() == numberOfUnits) {
                       order.getProductList().get(order.getProductList().indexOf(p)).addStock(p.getStock());
                       order.getLog().add("- Remove: Item: " + product + "-> Shopping cart -- Products : " + numberCartElements(order));
                       order.getCartItems().remove(p);
                       return;
                   }else if (p.getStock() > numberOfUnits) {
                       order.getProductList().get(order.getProductList().indexOf(p)).addStock(numberOfUnits);
                       p.reduceStock(numberOfUnits);
                       order.getLog().add("- Modify : Item : " + product + " - Quantity : " + numberOfUnits + "-> CheckOut Order -- Products : " + numberCartElements(order));
                       return;
                   }else{
                       throw new IllegalArgumentException();
                   }
               }

           }
       }
        throw new IllegalArgumentException();
    }

    default void goPreviousState(Order order){
        throw new IllegalArgumentException();
    }
    default void goNextState(Order order){
        throw new IllegalArgumentException();
    }

    void screenInfo(Order order);

    default int numberCartElements(Order order){
        int i = 0;
        for(Product p : order.getCartItems()){
            i++;
        }
        return i;
    }
}




