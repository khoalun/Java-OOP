package com.Nhan;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
       Distribution d1 = new Distribution(0,5);
       Scanner sc =  new Scanner(System.in);
       int num;
       System.out.println("Ask from the user, a letter ends input:  ");

       while(sc.hasNextInt()){
           num = sc.nextInt();
           if(num >= 0 && num <=5) d1.insertValue(num);

           else {
               System.out.println("Not valid number");

           }

           System.out.println("Ask from the user (from 0 to 5): ");
       }

        //create an object to use print class
        print p = new print(d1);
        p.displayDistribution(2);


    }
}
