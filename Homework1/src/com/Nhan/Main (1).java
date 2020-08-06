package com.Nhan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Dice d1 = new Dice();
        Dice d2 = new Dice();

        int dice1 = d1.randomDice();
        int dice2 = d2.randomDice();
        while (dice1 != dice2) {
            System.out.println("Dice1: " + dice1);
            System.out.println("Dice2: " + dice2 + "\n");
            dice1 = d1.randomDice();
            dice2 = d2.randomDice();
            if (dice1 == dice2) {
                System.out.println("haha");
                System.out.println("Dice1: " + dice1);
                System.out.println("Dice2: " + dice2 + "\n");
            }

        }
        System.out.println("Both dice 1 and dice 2 have the same score: " + dice1);

        //ASSIGNMENT 4
        Distribution d = new Distribution(1,6);
        Scanner sc= new Scanner(System.in);
        boolean check= true;
        System.out.println("Want to roll the dice hah?(0 for No and 1 for Yes)? ");
        int number ;
        int numberRolled;
        while (check) {
            Dice d3 = new Dice();

            numberRolled = d3.randomDice();

            number = sc.nextInt();
            if(number == 0){
                System.out.println("Stop doing!!");
                check = false;

            }
            else if(number ==1){
                d.insertValue(numberRolled);
                System.out.println("Number Rolled: "+numberRolled);
                System.out.println("Want to roll the dice hah?(0 for No and 1 for Yes)? ");

            }

        }
        //create an object to use print class
        print p = new print(d);
        p.displayDistribution(2);
    }

}

