package com.Nhan;
import java.lang.String;
public class Fraction {

    public int numerator;
    public int denominator;
    public double n;
    public double d;

    //constructor
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public  Fraction( int numerator, int denominator) {

            this.numerator = numerator;
            this.denominator = denominator;
            if(this.denominator == 0){
                this.denominator =1;
            }
    }

    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return (numerator + "/" + denominator);
    }

   public double toDouble(){
        n = (double)numerator/denominator;
        return n;
    }

    public Fraction multiply(Fraction multiplier) {
        int n=this.numerator * multiplier.numerator;
        int m=this.denominator * multiplier.denominator;
        return new Fraction(n,m);

    }


}





