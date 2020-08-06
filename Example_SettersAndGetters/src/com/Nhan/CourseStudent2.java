package com.Nhan;

import java.util.Scanner;

public class CourseStudent2 {

    public void process() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many students?");
        int number = sc.nextInt();
        Student[] students = new Student[number]; //array allocation

        for (int i = 0; i < number; i++) {
            sc.nextLine(); //skip the line break

            students[i] = new Student(); //object creation
            System.out.print("Name of the student?");
            students[i].setName(sc.nextLine());
            System.out.print("1st grade?");
            students[i].setGrade1(sc.nextDouble());
            System.out.print("2nd grade?");
            students[i].setGrade2(sc.nextDouble());
        }
        sc.close();
        System.out.println("Results of the students");
        System.out.println("Name \t\tAverage");
        for (int i = 0; i < number; i++) {
            System.out.println(students[i].getName() + "\t" + String.format("%.2f", students[i].average()));
        }
    }
}
