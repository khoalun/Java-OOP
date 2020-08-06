package com.Nhan;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CustomerList {
    public static void main(String[] args)  throws FileNotFoundException{
         String fileName = "test.txt";

            File f = new File(fileName);
            Scanner sc1 = new Scanner(f);
            ArrayList<Customer> customerInfo = new ArrayList<Customer>();

            while (sc1.hasNext()) {
                String input = sc1.nextLine();
                if(input.toLowerCase().equals("customer")) {
                    //sc1.nextLine();
                    int num = sc1.nextInt();
                    sc1.nextLine();
                    String name = sc1.nextLine();
                    String address = sc1.nextLine();
                    customerInfo.add(new Customer(num, name, address));
                }
                else if(input.toLowerCase().equals("preferred customer")){
                    //sc1.nextLine();
                    int num = sc1.nextInt();
                    sc1.nextLine();
                    String name = sc1.nextLine();
                    String address = sc1.nextLine();
                    double purchase = sc1.nextDouble();
                    customerInfo.add(new preferredCustomer(num, name, address, purchase));
                }
            }
            for (Customer s : customerInfo) {
                if(s instanceof preferredCustomer) {
                    System.out.println("Preferred customer: "+ s.toString());
                }
                else
                    System.out.println("Customer: "+ s.toString());

                System.out.println("---------");
            }
        }
    }

