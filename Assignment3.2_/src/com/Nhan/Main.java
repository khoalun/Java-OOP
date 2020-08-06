package com.Nhan;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        HashMap<Integer, Double > product = new HashMap<>();
        int productNumber;
        double Price;
        //Store Object to HashMap
        product.put(1, 200.0);
        product.put(2,300.0);
        product.put(3,400.0);
        product.put(4,500.0);

        Scanner sc = new Scanner(System.in);
        System.out.println("What is the product number are you looking for?(Insert 0 to stop): ");
        int search = sc.nextInt();
        if(search == 0 ){
            System.out.println("Stop searching!");
        }
        else {
            while (search != 0) {
                if (product.containsKey(search)) {
                    Price = product.get(search);
                    System.out.println("The price of product number " + search + " is " + Price);
                } else {
                    System.out.println("Item not found");
                }
                System.out.println("What is the product number are you looking for?(Insert 0 to stop): ");
                search = sc.nextInt();
                if (search == 0) {
                    System.out.println("Stop searching!");
                }
            }
        }
    }
}
