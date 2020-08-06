package com.Nhan;
import java.util.ArrayList;
import java.util.Scanner;

public class Orderline {
    private double totalPrice = 0;
    public void process() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many order lines the order has?");
        int number = sc.nextInt();
        Items[] items = new Items[number]; //array allocation

        for(int i = 0; i < number; i++){
            sc.nextLine(); //skip the line break

            items[i] = new Items(); //object creation
            System.out.print("Name of the items?");
            items[i].setName(sc.nextLine());
            System.out.print("how many products?");
            items[i].setQuantity(sc.nextDouble());
            System.out.print("how much ?");
            items[i].setPrice(sc.nextDouble());
            totalPrice += items[i].getPrice()* items[i].getQuantity();
        }

        System.out.println("The product");
        System.out.println("Name \t\tTotalPrice");
        for(int i = 0; i < number; i++){
            System.out.println(items[i].getName() + "\t" + "\t" + String.format("%.2f", items[i].priceOfOrder()));
        }

	       /* for(int t = 0; t < number; t++){
	        	totalPrice += items[t].priceOfOrder();
	        }
	        */
        System.out.print("\n");//line break
        System.out.println("Total Price: " +"\t" + totalPrice);

    }
}
