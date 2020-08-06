package sample;

import java.io.Serializable;

public class Orderline implements Serializable {
    private String name;
    private double price;
    private int quantity;
    private double sum;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    protected double priceOfOrder() {
        return (price * quantity);
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orderline(String name, double price, int quantity ){
        this.name = name;
        this.price = price;
        this.quantity= quantity;

    }
    public String toString(){
        return String.format("%s\t\t%.2f\t%s\t\t\t%.2f", name ,price ,quantity ,priceOfOrder() );
    }
}
