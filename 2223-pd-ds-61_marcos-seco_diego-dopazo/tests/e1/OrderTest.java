package e1;

import e1.ShoppingSteps.Payment;
import e1.ShoppingSteps.ShoppingCart;
import e1.ShoppingSteps.ShoppingState;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {


    static final List<Product> productList = new ArrayList<>();
    static Product product1 = new Product("111", 10.50F, 20);
    static Product product2 = new Product("222", 0.50F, 20);
    static Product product3 = new Product("333", 999.99F,  10);
    static Product product4 = new Product("444", 40.89F, 100);
    static Product product5 = new Product("555", 1.5F, 15);
    @BeforeAll
    static void setUpList(){
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    Client client1 = new Client("manolo@gmail.com", 500.5F);
    Client client2 = new Client("diego@gmail", 10.10F);
    Client client3 = new Client("victor@gmail", 1000.5F);
    Order order1 = new Order(111, client1, productList);
    Order order2 = new Order(112, client2, productList);
    Order order3 = new Order(113, client3, productList);




    @Test
    void StatesBehaviour() throws InterruptedException {
        //ShoppingState
        assertThrows(IllegalArgumentException.class, ()->order1.addProduct("Not a product", 321));
        assertThrows(IllegalArgumentException.class, ()->order1.removeProduct("Empty cart", 10));

        order1.addProduct("111", 5);
        assertThrows(IllegalArgumentException.class, ()->order1.removeProduct("111", 100000));
        order1.removeProduct("111", 1);
        assertEquals(16, product1.getStock());
        order1.addProduct("333", 1);
        assertThrows(IllegalArgumentException.class, ()->order1.addProduct("333", 5000));
        order2.addProduct("222", 10);
        order2.addProduct("555", 3);
        assertThrows(IllegalArgumentException.class, ()->order3.addProduct("222", 15));
        order3.addProduct("222", 10);
        order3.addProduct("111", 10);
        assertEquals(2, order3.getCartItems().size());

        //CheckOutState
        order1.nextState();
        order2.nextState();
        order3.nextState();

        order1.previousState();
        assertThrows(IllegalArgumentException.class, ()->order1.previousState());
        order1.addProduct("555", 10);
        order1.nextState();
        assertEquals(10, order2.getCartItems().get(0).getStock());
        order2.removeProduct("222", 1);

        assertThrows(IllegalArgumentException.class, ()->order1.addProduct("333", 1));



        //PaymentPhase
        //these nextState are for advance to the Payment state
        order1.nextState();
        order2.nextState();
        order3.nextState();

        assertThrows(IllegalArgumentException.class, ()->order1.previousState());//can not go back
        assertThrows(IllegalArgumentException.class, ()->order1.nextState()); //has no enough money
        order2.nextState();//payment
        order3.nextState();//payment
        assertEquals(9F, order2.getPayment());
        assertEquals(110F, order3.getPayment());





        //cancelled
        order2.previousState();
        assertThrows(IllegalArgumentException.class, ()->order2.nextState());
        assertThrows(IllegalArgumentException.class, ()->order2.previousState());
        assertThrows(IllegalArgumentException.class, ()->order2.addProduct("222", 2));
        assertThrows(IllegalArgumentException.class, ()->order2.removeProduct("222", 2));


        //completed
        //this nextState is that when the order is already paid is considered as a confirmation
        order3.nextState();
        assertThrows(IllegalArgumentException.class, ()->order3.nextState());
        assertThrows(IllegalArgumentException.class, ()->order3.previousState());
        assertThrows(IllegalArgumentException.class, ()->order3.addProduct("222", 2));
        assertThrows(IllegalArgumentException.class, ()->order3.removeProduct("222", 2));
    }

}