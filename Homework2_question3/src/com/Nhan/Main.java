package com.Nhan;
import java.lang.String;
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(longestStringLength(new String[] { "bread", "butter", "milk",  "banana", "juice"}));
        System.out.println(longestStringLength(new String[] { "hat", "", "scarf", null, "coat"}));
        System.out.println(longestStringLength(new String[] { }));
        System.out.println(longestStringLength(null));
        System.out.println(longestStringLength(new String[] { null, null }));
        System.out.println(longestStringLength(new String[] {""}));
    }

    public static int longestStringLength(String[] strings) {
        try {
            boolean empty = true;
            for (String string : strings) {
                if (string != null) { // giá trị ban đầu của empty là true, nếu trong string mà k có null, thì empty thành false, and break immediately và k xuất ra giá trị empty được
                    empty = false;      //đây đùng để xet điều kiện
                    break;
                }
            }
            //xét điều kiện array is empty
            if (strings.length == 0 || empty) { //khi empty thành false, thì string đã k có null, thì k xuất return -1
                return -1;
            }

            int index = 0;
            int elementLength = strings[0].length();
            int i= 0;

            for (index = 0; index < strings.length; index++) {
                if (strings[index] != null && strings[index].length() >= elementLength) {
                    elementLength = strings[index].length();
                }
            }
            return elementLength;

        }catch(NullPointerException e) {
            return -1;
        }
    }
}


