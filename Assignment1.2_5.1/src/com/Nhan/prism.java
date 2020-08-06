package com.Nhan;

public class prism {
     public double height;
     public double width;
     public double depth;

     public double volume (){
         return height*width*depth;
     }


    public void setValue(double h,double w, double d) {
        this.height = h;
        this.width = w;
        this.depth = d;
    }
    public void getValue() {
        System.out.println("Height is: "+this.height);
        System.out.println("Width is: "+this.width);
        System.out.println("Depth is: "+this.depth);
        System.out.println("Volume is: "+this.volume());

    }

}

class solidPrism extends prism {


    public double density;
    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double massOfTheSolidPrism(){
            return volume() * density;
        }
}
