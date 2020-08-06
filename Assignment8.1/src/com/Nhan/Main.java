package com.Nhan;
import java.io.File ;
import java.nio.file.Path;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public void readFromFile(String filename){
        Scanner input = null;
        Scanner ask = new Scanner(System.in);
        System.out.println("Which word you want to search? ");
        String word = ask.next();
        String val, val1;

        try {
            boolean check = false;
            input = new Scanner(new FileInputStream(filename));
            System.out.println("- File opened -");
            input.useLocale(Locale.ENGLISH); //decimal separator .
            while(input.hasNext()){
                val = input.next().replaceAll(",", ""); //read from file
                if(word.equals(val)) {
                    val += input.nextLine();
                    System.out.println(val);
                    check = true;
                }
            }
            if(!(check)){
                System.out.println("No words match!");
            }
        }
        catch(IOException ex2){
            System.out.println("Reading from file failed: " + ex2.getMessage());
        }
        finally {
            if (input != null) {
                input.close();
                System.out.println("- File closed -");
            }

        }
    }

    public static void main(String[] args) {
        // write your code here

        Scanner scan = new Scanner(System.in);
        System.out.println("Which file you want to access?");
        String path = scan.nextLine();
        if(new java.io.File(path).exists()){
            Main measurements = new Main();
            measurements.readFromFile(path);
        }
        else{
            System.out.println("Your path file is wrong!");
        }



    }
}