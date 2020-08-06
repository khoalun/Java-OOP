package com.Nhan;

public class Student {
    // Instance variables
    private String name; // student's name
    private double grade1, grade2; // grades of two exams

    //----------------------------------------------------------------------
    //Setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade1() {
        return grade1;
    }

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    //------------------------------------------------------------------------
    //Other methods

    // Instance method calculates and returns the average of the grades.
    public double average() {
        return (grade1 + grade2) / 2;
    }

}
