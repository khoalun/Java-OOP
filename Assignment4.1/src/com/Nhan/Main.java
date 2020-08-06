package com.Nhan;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Orderline3 order = new Orderline3(1056, "Charlie Brown", new date());
        order.addNewOrderline(new Orderline("meat", 10, 5 ));
        order.addNewOrderline(new Orderline("bread", 2, 3 ));
        order.addNewOrderline(new Orderline("salad", 5, 2 ));


        System.out.println(order);
    }
}
