package com.Nhan;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Items s = new Items();
        s.setName("laptop");
        s.setPrice(500);
        s.setQuantity(10);

        Items s1 = new Items();
        s1.setName("smartphone");
        s1.setPrice(200);
        s1.setQuantity(6);

        System.out.println("Name: "+ s.getName() + ": "+ s.getPrice() +" " +s.getQuantity() +" "+ s. priceOfOrder());
        System.out.println("Name: "+ s1.getName() + ": "+ s1.getPrice() +" " +s1.getQuantity() +" "+ s1. priceOfOrder());



        ArrayList<Orderline2> customerInfo = new ArrayList<>();
        customerInfo.add (new Orderline2("Nhan", 113, 30,9,2019));


        for (Orderline2 o : customerInfo) {
            System.out.println("Name: " + o.getName() + "\n" +"OrderID: "+ o.getOrderID()+ "\n" + "Order date: "+ o.getD()+"."+o.getM()+"."+o.getY() );
        }

        Orderline2[] orderData = new Orderline2[3];
        orderData[0] = new Orderline2("pencil", 2.50, 100);
        orderData[1] = new Orderline2("Notebook", 5.00, 20);
        orderData[2] = new Orderline2("Pencil case", 14.95, 10);

        System.out.println("Product"+ "\t\t\t"+ "Price"+ "\t"+"Quantity"+"\t"+"Sum");

        StringBuilder sb = new StringBuilder();
        // stringbuilder.append(orderData[0].getProductName().trim()).append("\t\t\t");
        //stringbuilder.append(String.format("%.2f",orderData[0].getPrice())).append("\t").append(orderData[0].getQuantity()).append("\t\t\t").append(String.format("%.2f",orderData[0].priceOfOrder())).append("\n") ;

        for(int j =0 ; j < orderData.length; j ++ ){
            sb.append(orderData[j].getProductName().trim()).append("\t\t");
            sb.append(String.format("%.2f",orderData[j].getPrice())).append("\t").append(orderData[j].getQuantity()).append("\t\t\t").append(String.format("%.2f",orderData[j].priceOfOrder())).append("\n") ;

        }
        String result = sb.toString();
        System.out.println(result);

        double TotalPrice = 0;
        for(int k =0; k < orderData.length; k ++){
            TotalPrice += orderData[k].priceOfOrder();
        }
        System.out.println("Total Price: "+String.format ("%.2f", TotalPrice));



        Orderline program = new Orderline();
        program.process();
    }
}
