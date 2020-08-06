package com.Nhan;

public class Orderline2 {
    private String name;
    private double price;
    private int quantity;

    //date
    private int d;
    private int m;
    private int y;
    public String productName;
    public int orderID;



    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected double priceOfOrder() {
        return (price * quantity);
    }

    public Orderline2( String name, int orderID, int d, int m, int y) {
        this.name = name;
        this.orderID = orderID;
        this.d = d;
        this.m = m;
        this.y = y;
    }

    public Orderline2 (String productName, double price, int quantity){
        this.productName= productName;
        this.price= price;
        this.quantity = quantity;
    }
}
