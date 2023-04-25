package e1;

import java.util.Objects;

public class Product {
    private final float price;
    private final String productName;
    private int stock;


    public Product(String product, float price, int stock){
        this.productName = product;
        this.price = price;
        this.stock = stock;
    }

    public int getStock(){
        return stock;
    }

    public String getProductName(){
        return productName;
    }
    public float getPrice(){
        return this.price;
    }
    public void addStock(int units){
        stock += units;
    }

    public void setStock(int  stock){
        this.stock = stock;
    }
    public void reduceStock(int units){

        stock -= units;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, productName);
    }
}
