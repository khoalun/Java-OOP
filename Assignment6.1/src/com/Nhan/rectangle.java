package com.Nhan;

public class rectangle implements Measurable {

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public double width () {
        return Math.abs(x2-x1);
    }

    public double height () {
        return Math.abs(y2-y1);
    }
    public double area () {
        return Math.abs((x2-x1)*(y2-y1));
    }

    @Override
    public double perimeter() {
        return width()*2+ height()*2;
    }

    @Override
    public void scale(double scaleValue) {
        x2= x1+scaleValue*width();
        y2= y1+scaleValue*height();
    }

    //Constructor
    public rectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public rectangle () {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 1;
        this.y2 = 1;
    }

    public rectangle (double x2, double y2) {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = x2;
        this.y2 = y2;
    }


    //setter and getter



    public String toString(){
        return String.format("Rectangle Area: %.2f\t Perimeter: %.2f\n",area(),perimeter());
    }
}
