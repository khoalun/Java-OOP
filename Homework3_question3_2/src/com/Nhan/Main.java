package com.Nhan;
import java.lang.String;
public class Main {

    public static void main(String[] args) {
        // write your code here
        String[] Stringss = {};
        int result = longestStringLength(Stringss);
        System.out.println(result);
    }

    public static int longestStringLength(String[] strings) {
        int index = 0;
        int elementLength = strings[0].length();
        try {
            if (strings.length == 0) {
                return -1;
            } else {
                for (int i = 1; i < strings.length; i++) {

                    if (strings[i].length() > elementLength) {
                        index = i;
                        elementLength = strings[i].length();
                    }
                }
                return strings[index].length();
            }
            }catch(NullPointerException e) {
                return -1;
            }
        }


    }

