package com.Nhan;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<machineParts> parts = new ArrayList<>();
        parts.add(new partsFromSameFactory("part1", 3, 3, 4.5));
        parts.add(new partsFromSameFactory("part2", 5, 2, 6));
        parts.add(new partsArePurchased("part3", 1, 7, "company1"));
        parts.add(new partsArePurchased("part4", 4, 9, "company2"));

        for (machineParts m : parts) {
            if (m instanceof partsFromSameFactory)
                System.out.println(m.toString());
            else if(m instanceof partsArePurchased)
                System.out.println(m.toString());
        }
        System.out.println("\n\n Part Names And Inventory Value:");

       // for(int i =0; i < parts.size(); i++){
           // System.out.println(parts.get(i).getName() +"\t\t" + parts.get(i).inventoryValue());
        //}

        for(machineParts l: parts){
            System.out.println(l.nameAndValue());
        }
    }
}


