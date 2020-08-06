package com.Nhan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here




        Scanner scanner = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();
        int choice, room;

        do{
            System.out.println("Options: 1.Insert a room\t 2.Print out all rooms\t 3.Print out offices\t 4.Print out classrooms\t 5.Print out other rooms\t 6. Search a room\t 7.Search a staff");
            choice = scanner.nextInt();

            switch(choice) {
                case 1: //insert a room
                    do {
                        System.out.println("Which rooms you want to add?(Press 0 to stop!) 1.Office\t 2.Classroom\t 3.Other");
                        room = scanner.nextInt();

                        switch (room) {
                            case 1: // insert an office
                                System.out.println("Insert an office:");
                                Office of = new Office();
                                of.askInfo();
                                System.out.println("Added! \n--------------------------");
                                rooms.add(of);

                                break;

                            case 2: //insert a classroom
                                System.out.println("Insert a classroom:");
                                ClassRoom cl = new ClassRoom();
                                cl.askInfo1();
                                System.out.println("Added! \n--------------------------");
                                rooms.add(cl);

                                break;

                            case 3: //insert a regular room
                                System.out.println("Insert an other room:");
                                Other ot = new Other();
                                ot.askInfo2();
                                System.out.println("Added! \n--------------------------");
                                rooms.add(ot);

                                break;
                        }
                    } while (room != 0);
                    break;

                case 2: //print out all the rooms
                    for (Room r : rooms) {
                        System.out.println(r.toString());
                        System.out.println("-------------");
                    }
                    break;
                case 3:
                    for(Room of: rooms){
                        if(of instanceof Office){
                            System.out.println(of.toString());
                            System.out.println("-------------");
                        }
                    }
                    break;
                case 4:
                    for(Room cl: rooms){
                        if(cl instanceof ClassRoom){
                            System.out.println(cl.toString());
                            System.out.println("-------------");
                        }
                    }
                    break;
                case 5:
                    for(Room ot: rooms){
                        if(ot instanceof Other){
                            System.out.println(ot.toString());
                            System.out.println("-------------");
                        }
                    }
                    break;
                case 6:
                    boolean isRoomFound = false;
                    System.out.println("which rooms you want to search?");
                    String searchRoom = scanner.next();
                    for(int i =0; i < rooms.size(); i++) {
                        if (rooms.get(i).getRoomName().toLowerCase().equals(searchRoom)){
                            System.out.println(rooms.get(i).toString());
                            System.out.println("-------------");
                            isRoomFound = true;
                            break;
                        }
                    }
                    if(!isRoomFound)
                        System.out.println("No information found!");
                    break;
                case 7:
                    boolean isStaffFound = false;
                    System.out.println("Search name of staff member");
                    String name = scanner.next();
                    for(Room of: rooms){
                        if(of instanceof Office) {
                            if(((Office) of).worksHere(name)){
                                System.out.println("FOUND!");
                                System.out.println(of);
                                isStaffFound =true;
                            }
                        }
                        if(!isStaffFound){
                            System.out.println(name + " is not found!");
                        }
                    }
            }
        }while(choice != 0);

    }
}

