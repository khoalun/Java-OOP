package com.Nhan;
import java.time.LocalDate;
import java.lang.String;
import java.util.ArrayList;


public class date {
    private static int month;
    public static int getMonth() {
        return month;
    }

    public static void setMonth(int month) {
        date.month = month;
    }



    //exercise 2a
    private int d;
    private int m;
    private int y;



    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public date (int d,int m,int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }
    public String toString() {
        return d+ "."+ m+ "."+ y;
    }


    //exercise 2b
    public date() {
        LocalDate today = java.time.LocalDate.now();
        d = today.getDayOfMonth();
        m = today.getMonthValue();
        y = today.getYear();
    }
    //take year
    public date (int y){
        this.d = 0;
        this.d = 0;
        this.y =y;
    }
    //exercise 2c
    //exercise 2e
    public date(String Date){
        String[] split = Date.split("\\.");
        d = Integer.parseInt(split [0]);
        m = Integer.parseInt(split [1]);
        y = Integer.parseInt(split [2]);
    }

    public String dateSplit (){
        return d + "\n" +m + "\n" + y;
    }// \n: xuong hang

    public boolean equals(date another) {
        if(this.d == another.d && this.m == another.m && this.y == another.y  ){
            return true;
        }
        else {
            return false;
        }
    }



    //exercise 2d
    //exercise 2e
    public static final  String[] MONTHNAMES = {"January", "February",
            "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};

    public static int getMonthNumber (String months){
        for(int n =0; n < 11; n++){
            if(months.toLowerCase().equals( MONTHNAMES[n].toLowerCase())) {
                return n + 1;
            }
        }
        return 0;
    }


    public String returnLongForm(){
        if( d== 1 || d== 11|| d== 21|| d==31){
            return "The " + d + "st of "+ MONTHNAMES[m-1] +", "+ y;
        }
        else if(d == 2|| d== 12 || d== 22 ){
            return "The " + d + "nd of "+ MONTHNAMES[m-1] +", "+ y;
        }
        else if(d == 3|| d== 13 || d== 23){
            return "The " + d + "rd of "+ MONTHNAMES[m-1] +", "+ y;

        }
        else{
            return "The " + d + "th of "+ MONTHNAMES[m-1] +", "+ y;
        }


    }

    //ASSIGNMENT3



}


