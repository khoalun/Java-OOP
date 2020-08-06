package com.Nhan;

public class date implements Comparable<date> {
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

    public date(int d, int m, int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }

    public boolean equals(date obj) {
        if (this.d == obj.d && this.m == obj.m && this.y == obj.y)
            return true;
        else
            return false;
    }



    public String toString() {
        return d + "." + m + "." + y;
    }

    @Override
    public int compareTo(date o) {
        if (this.equals(o))
            return 0;
         else if (this.y < o.y)
            return -1;
         else if (this.m < o.m && this.y == o.y)
            return -1;
         else if (this.d < o.d && this.m == o.m)
            return -1;
         else
             return 1;
    }
}

