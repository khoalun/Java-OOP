package sample;

import java.io.Serializable;
import java.time.LocalDate;

public class date implements Serializable {
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
    // constructor to split the value of date inputted as String by “.” and assign from left to right  to day, month, year
    public date(String Date){
        String[] split = Date.split("\\.");
        d = Integer.parseInt(split [0]);
        m = Integer.parseInt(split [1]);
        y = Integer.parseInt(split [2]);
    }
}
