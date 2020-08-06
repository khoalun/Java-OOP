package com.Nhan;

public class Circle implements Measurable {
    private double cx; // centre x
    private double cy; // centre y
    private double r; // radius

    //Constructor
    public Circle(double cx, double cy, double r) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }
    public Circle() {
        this.cx = 0;
        this.cy = 0;
        this.r = 1;
    }

    public Circle(double r){
        this.cx = 0;
        this.cy = 0;
        this.r = Math.abs(r);
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    public double getR() {
        return r;
    }

    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public double perimeter() {
        return r*2*Math.PI;
    }

    @Override
    public void scale(double scaleValue) {
        r=r*scaleValue;
    }
    public String toString(){
        return String.format("Circle Area: %.2f\t Perimeter: %.2f\n",area(),perimeter());
    }
}
