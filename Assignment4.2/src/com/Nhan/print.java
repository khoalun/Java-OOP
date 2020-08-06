package com.Nhan;


public class print {
    // a reference to a distribution object as its instance variable
    private Distribution distri;

    //the distribution to be printed is passed as an argument to the constructor
    public  print(Distribution dis){
        this.distri = dis;
    }

    //a method that prints the distribution in a neat form (it prints out frequencies of the values and the average).
    public void displayDistribution(int value){
        Distribution d = distri;
        System.out.println("Frequency: "+ d.frequency(value));
        System.out.println("Average: " + d.average());
    }

}
