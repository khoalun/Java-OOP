package com.Nhan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        date d1 = new date(8, 11, 2018);// integer
        date d2 = new date();
        date d3 = new date(15, 9, 1965);
        date d4 = new date("18.9.2019"); // type of string
        date d5 = new date(18, 9, 2019);
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.getD() + "." + d3.getM() + "." + d3.getY());
        System.out.println(d4.dateSplit());
        d5.equals(d2);
        if (d5.equals(d2) == true) {
            System.out.println("match");
        } else {
            System.out.println("Unmatch");
        }
        //ask from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the day?");
        String s = sc.nextLine();
        System.out.println("You entered string: " + s);
        date user = new date(s);

        //compare
        d3.equals(user);
        // System.out.println(d3.equals(user));
        if (d3.equals(user) == true) {
            System.out.println("Match");
        } else {
            System.out.println("Unmatch");
        }


        System.out.println("enter a month: ");
        String monthh = sc.nextLine();
        System.out.println(date.getMonthNumber(monthh));


        date d7 = new date(11, 2, 2019);
        System.out.println(d7.returnLongForm());


        //Assignment3.1

        ArrayList<date> Date = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("What is the day you want to add?");

        int i;
        boolean empty = true;


        while (input.hasNextLine()) {
            String datee = input.nextLine();
            if (datee.isEmpty()) {
                System.out.println("Stop adding!");
                break;
            } else {
                Date.add(new date(datee));
                System.out.println("What is the day you want to add?");
                empty = false;
            }
            if (empty) {
                System.out.println("No valid date");
            }
        }
        System.out.println("All the dates you have entered: \n ");
        for (i = 0; i < Date.size(); i++) {
            System.out.println(Date.toString());
        }


        while (true) {
            System.out.println("The user give a date: ");
            String DATE = input.nextLine();

            if (DATE.isEmpty()) {
                System.out.println("Stop searching!");
                break;
            }
            date a = new date(DATE);
            boolean check = false;
            for (int j = 0; j < Date.size(); j++) {
                if (a.equals(Date.get(j))) {
                    System.out.println("The index of the date is " + j);
                    check = true;
                    break;
                }
            }
            if (!check) System.out.println("Date not found"); // check == false
        }

        while (true) {
            System.out.println("What year you want to search: (Enter <=0  to stop searching!) ");
            int year = input.nextInt();
            if (year <= 0) {
                System.out.println("Stop searching!");
                boolean check = false;
                break;

            }
            boolean check = true;
            //date YEAR = new date(year);
            for (int j = 0; j < Date.size(); j++) {
                if (year == Date.get(j).getY()) {
                    System.out.println(Date.get(j).toString());
                    check = false;
                }
            }
            if (check) {
                System.out.println("No valid year");
            }
        }

    }

}