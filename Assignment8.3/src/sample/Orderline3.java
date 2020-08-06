package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Orderline3 implements Serializable {
    protected int Id;
    protected String customerName;
    protected date OrderDate;
    protected ArrayList<Orderline> lines = new ArrayList<>();

//serialziable all class




    public Orderline3( int id, String customerName, date OrderDate) {
        this.customerName = customerName;
        this.Id= id;
        this.customerName= customerName;
        this.OrderDate= OrderDate;
    }
    public void addNewOrderline (Orderline line){
        this.lines.add(line);
    }

    private double totalPrice(){
        double sum =0;
        for(Orderline ol: lines){
            sum +=ol.priceOfOrder();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderID: " + this.Id + "\n");
        sb.append("Customer: " + this.customerName + "\n");
        sb.append("Order date: " + this.OrderDate + "\n");
        sb.append("Product\t\tPrice\tQuantity\tSum\n");
        for (Orderline l : this.lines) {
            sb.append(l + "\n");
        }


        sb.append("Total: " + this.totalPrice());
        return sb.toString();
    }
}
