package com.Nhan;

public  class Customer {
    protected int number;
    protected String name;
    protected String address;

   //setter and getter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //constructor
    public Customer(int number, String name, String address){
        this.number= number;
        this.name=name;
        this.address=address;
    }
   public  String toString(){
      return String.format("%s\t%s\t%s", number, name, address);
   }

}

class preferredCustomer extends Customer{
    public double purchases;
    private double valueBonus;
    public preferredCustomer(int number, String name, String address,double purchases){

        super(number, name, address);
        this.purchases= purchases;
    }
    public double getValueBonus() {
        return valueBonus;
    }

    public void setValueBonus(double valueBonus) {
        this.valueBonus = valueBonus;
    }

    public double getPurchases() {
        return purchases;
    }

    public void setPurchases(double purchases) {
        this.purchases = purchases;
    }


    public double calculateBonus (){
        if(purchases >=500 &&purchases <= 1000){
           valueBonus= purchases*2/100;
        }
        else if(purchases >1000){
            valueBonus= purchases *5/100;
        }

        return valueBonus;
    }
    @Override
    public String toString(){
        return String.format("%s\t%s\t\t%s\t\t%.2f\t\t%.2f", super.number, super.name, super.address,this.purchases, this.calculateBonus());
    }
/*
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append();
    }
*/

}

