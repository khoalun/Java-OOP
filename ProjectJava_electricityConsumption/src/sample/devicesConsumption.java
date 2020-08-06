package sample;
import java.io.Serializable;

public class devicesConsumption implements Serializable {
    protected String deviceName;
    protected int hour, min;
    protected double consumptionValue;

    //setter and getter
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getConsumptionValue() {
        return consumptionValue;
    }

    public void setConsumptionValue(double consumptionValue) {
        this.consumptionValue = consumptionValue;
    }

    //Constructor
    public devicesConsumption(String deviceName,double consumptionValue, int hour, int min){
        this.deviceName = deviceName;
        this.consumptionValue= consumptionValue;
        this.hour = hour;
        this.min = min;
    }
    //convert from minutes to hours
    public double durationInHours(){
        return hour + min/60;
    }

    //total sum of consumption for a device
    protected double sum(){
        return consumptionValue * durationInHours();
    }

    //toString method
    public String toString(){
        return String.format("%27s %12s %10.3f kW/h %1s %5s %1s %5s\n", this.getDeviceName(),"|",this.getConsumptionValue(),"|", this.getHour(),"|", this.getMin());
    }



}
