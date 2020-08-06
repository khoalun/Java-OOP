package com.Nhan;
import java.util.ArrayList;
import java.util.Collections;



public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<date> Date = new ArrayList<>();
        Date.add(new date(29, 5, 2000));
        Date.add(new date(9, 7, 1993));
        Date.add(new date(12, 11, 1994));
        Date.add(new date(10, 10, 1993));


        Collections.sort(Date);
        for(date d: Date){
            System.out.println(d.toString());
        }

    }

}
