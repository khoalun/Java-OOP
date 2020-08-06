package com.Nhan;

public class Main {

    public static void main(String[] args) {
	// write your code here
        prism p1 = new prism();
        prism p2 = new prism();
        p1.setValue(3,5,6);
        p2.setValue(6,7,8);
        p1.getValue();
        p2.getValue();

        System.out.println("--------------------------");
        solidPrism p3 = new solidPrism();
        p3.setDensity(0.3);
        p3.setValue(4,7,9);
        p3.getValue();
        System.out.println("The mass is: " + p3.massOfTheSolidPrism());
    }
}
