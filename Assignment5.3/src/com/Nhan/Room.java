package com.Nhan;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    protected String roomName;
    protected String roomInfo;

    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomInfo() {
        return roomInfo;
    }
    public void setRoomInfo(String roomInfo) {
        this.roomInfo = roomInfo;
    }

    public void askData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the room's number?");
        roomName= sc.nextLine();
        System.out.println("What is the description of that room?");
        roomInfo= sc.nextLine();
    }
    public String toString(){
        return String.format("%s: %s", roomName, roomInfo);
    }
}
class Office extends Room {
    public ArrayList<String> getStaffMembers() {
        return staffMembers;
    }

    private ArrayList<String> staffMembers = new ArrayList<>();

    public void askInfo() {
        super.askData();
        Scanner sc1 = new Scanner(System.in);
        while (true) {
            System.out.println("What are the names of the staff? (Press 0 to stop)");
            String input = sc1.nextLine();
            if (input.equals("0"))
                break;
            staffMembers.add(input);
        }
}
    public String toString(){
        return String.format("%s: %s, staff members %s", super.roomName, super.roomInfo, String.join(", ", staffMembers ));
    }
    public boolean worksHere(String name){
            return staffMembers.contains(name);
        }


}
class ClassRoom extends Room{
    private int numOfSeats;
    private int numOfComputers;
    private String dataProjector;


    public int getNumOfSeats() {
        return numOfSeats;
    }
    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public int getNumOfComputers() {
        return numOfComputers;
    }
    public void setNumOfComputers(int numOfComputers) {
        this.numOfComputers = numOfComputers;
    }

    public String getDataProjector() {
        return dataProjector;
    }
    public void setDataProjector(String dataProjector) {
        this.dataProjector = dataProjector;
    }

    public void askInfo1(){
        super.askData();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("What is the number of seats?");
        numOfSeats= sc2.nextInt();
        System.out.println("What is the number of computers?");
        numOfComputers= sc2.nextInt();
        System.out.println("If there is a projector? Yes or No");
        String ask = sc2.next();
            if(ask.toLowerCase().equals("yes") )
                dataProjector=", data projector";
            else if (ask.toLowerCase().equals("no") )
                dataProjector=" ";

    }
    @Override
    public String toString(){
        return String.format("%s: %s,seats %s, computers %s%s ",super.roomName, super.roomInfo, this.numOfSeats,this.numOfComputers,this.dataProjector);
    }

}
class Other extends Room{

    public void askInfo2(){
        super.askData();
    }
    @Override
    public String toString(){
        return String.format("%s: %s", super.roomName, super.roomInfo);
    }
}







