package com.Nhan;

public class Main {

    public static void main(String[] args) {
	Fraction f1 = new Fraction();
    Fraction f2 = new Fraction(2,3 );
    Fraction f3 = new Fraction(2,0 );
    Fraction f4 = new Fraction(9, 2);
    Fraction f5 = new Fraction(3,4);

    System.out.println(f1.toString());
    System.out.println(f2.toString());
    System.out.println(f3.toString());
    System.out.println(f4.toDouble());
    System.out.println(f5.multiply(f4));


    }
}
