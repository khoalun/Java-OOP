package com.Nhan;

public abstract class machineParts {
    protected String name;
    protected int numberInStock;

    public String getName() {
        return name;
    }

    public int getNumberInStock() {
        return numberInStock;
    }
    abstract public  double inventoryValue();

    public abstract String nameAndValue();

    public machineParts(String name, int numberInStock){
        this.name=name;
        this.numberInStock=numberInStock;
    }
    public String toString(){
        return String.format("%s\t\t%s", name, numberInStock);


    }

}

 class partsFromSameFactory extends  machineParts{
    private int amount;
    private double unitPrice;

    public partsFromSameFactory(String name, int numberInStock, int amount, double unitPrice){
        super(name, numberInStock);
        this.amount = amount;
        this.unitPrice= unitPrice;
    }

     public  double inventoryValue(){
         return this.amount * this.unitPrice * super.numberInStock;
     }
     @Override
     public String toString(){
         return String.format("%s\t\t%s\t\t%s\t\t%.2f\t\t%.2f", name, numberInStock, amount, unitPrice, inventoryValue());
     }

     public String nameAndValue(){
         return String.format("%s\t\t%.2f", name, inventoryValue());
     }


}

class partsArePurchased extends machineParts{
    private double price;
    private String supplier;
    public partsArePurchased(String name, int numberInStock, double price, String supplier){
        super(name, numberInStock);
        this.price = price;
        this.supplier= supplier;
    }
    public  double inventoryValue(){
        return this.price * super.numberInStock;
    }
    @Override
    public String toString(){
        return String.format("%s\t\t%s\t\t%.2f\t\t%s\t\t%.2f", name, numberInStock, price, supplier, inventoryValue());

    }
    public String nameAndValue(){
        return String.format("%s\t\t%.2f", name, inventoryValue());
    }
}