package sample;
import java.io.Serializable;
import java.util.ArrayList;

public class UserInfo implements Serializable {
    protected String userName;
    protected date dateUsed;
    protected String location;
    protected ArrayList<devicesConsumption> devices = new ArrayList<>();

    //setter and getter
    public String getUserName() { return userName; }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public date getDateUsed() {
        return dateUsed;
    }
    public void setDateUsed(date dateUsed) {
        this.dateUsed = dateUsed;
    }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    //constructor
    public UserInfo(String userName, date dateUsed, String location) {
        this.userName = userName;
        this.dateUsed = dateUsed;
        this.location = location;
    }

    //add devices consumption to arraylist
    public void  addNewDevices (devicesConsumption device){
        this.devices.add(device);
    }

    //calculate sum consumption in one day
    private double totalSumDay(){
        double sum =0;
        for(devicesConsumption us: devices){
            sum +=us.sum();
        }
        return sum;
    }

    // toString method
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User Name: " + this.userName + "\n");
        sb.append("Date Used: " + this.dateUsed + "\n");
        sb.append("Location: " + this.location + "\n");
        sb.append(String.format("%27s %12s %10s %5s %5s %1s %5s\n","Devices","|","Consumption","|","Hour","|","Minutes"));
       sb.append(String.format("%s\n", "------------------------------------------------------------------------------"));
        for (devicesConsumption d : devices) {
            sb.append(d);
        }
        sb.append(String.format("Total: %.3fkW" , this.totalSumDay()));
        return sb.toString();

    }
}

