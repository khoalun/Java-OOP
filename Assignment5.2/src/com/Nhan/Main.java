package com.Nhan;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<Customer>CustomerInfo = new ArrayList<>();
        CustomerInfo.add(new Customer(001, "Nhan", "Vaasa"));
        CustomerInfo.add(new Customer(002, "Quan", "Helsinki"));
        CustomerInfo.add(new preferredCustomer(003, "Khoa", "Tempere", 600));
        CustomerInfo.add(new preferredCustomer(004, "Hau", "Lapland", 1100));

        System.out.println("Data of all customers: ");

        for(int i=0; i < CustomerInfo.size(); i++){
            System.out.println(String.format("%d\t\t%s\t\t%s",CustomerInfo.get(i).getNumber(), CustomerInfo.get(i).getName(), CustomerInfo.get(i).getAddress()));
        }


        System.out.println("\n\n");

        System.out.println("Preferred Customer");
        for(Customer c: CustomerInfo){
            if(c instanceof preferredCustomer )
            System.out.println(c.toString());

        }
    }
}
