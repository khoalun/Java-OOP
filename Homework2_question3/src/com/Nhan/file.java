package com.Nhan;

public class file {
    public static int longestStringLength(String[] strings) {
        try {

            if (strings.length == 0) {
                return -1;
            }
            int j = 0;
            int longest = 0;
            do {
                if (strings[j] != null) {
                    longest = strings[j].length();
                    break;
                } else
                    j++;
            } while (j < strings.length);
            int i = 0;
            do {
                if (strings[i] != null && strings[i].length() >= longest) {
                    longest = strings[i].length();
                }
                i++;
            } while (i < strings.length);
            return longest;
        }catch (NullPointerException e){
            return -1;
        }
    }
}
