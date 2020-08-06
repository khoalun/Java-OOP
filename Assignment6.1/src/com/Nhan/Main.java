package com.Nhan;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("---All objects in ArrayList: ---");
        ArrayList<Measurable> me1 = SampleList();
        for(Measurable m : me1){
            System.out.println(m.toString());
        }

        ArrayList<Measurable> me2 = SampleList();
        System.out.println("---Scale value is 0.5---");
        for(Measurable m: me2){
            m.scale(0.5);

            System.out.println(m.toString());
        }

        ArrayList<Measurable> me3 = SampleList();
        System.out.println("---Scale value is 2---");
        for(Measurable m: me3){
            m.scale(2);

            System.out.println(m.toString());
        }

        ArrayList<Measurable> me4 = SampleList();
        System.out.println("---Scale value is 3---");
        for(Measurable m: me4){
            m.scale(3);

            System.out.println(m.toString());
        }
    }
    public static ArrayList<Measurable> SampleList () {
        ArrayList<Measurable> measure = new ArrayList<>();

        measure.add(new rectangle());
        measure.add(new rectangle(1, 2, 2, 4));
        measure.add(new Circle());
        measure.add(new Circle(3));
        return measure;
    }

}
