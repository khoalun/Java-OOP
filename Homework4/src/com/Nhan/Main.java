package com.Nhan;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<musicTracks> tracks = new ArrayList<>();
        tracks.add(new musicTracks("Love Yourself", "KB", 4.5, 4));
        tracks.add(new musicTracks("The lazy song", "BM", 4.2, 2));
        tracks.add(new musicTracks("Grenade", "AM", 4, 3.4));
        tracks.add(new musicTracks("Sorry", "JB", 4, 4.9));
        tracks.add(new musicTracks("Sorry1", "JB", 3.9, 4.9));
        tracks.add(new musicTracks("Sorry2", "JB", 4.3, 4.9));


        Collections.sort(tracks);
        System.out.println("--Sort the tracks by title--");
        for(musicTracks m: tracks){
            System.out.println(m);
        }
        System.out.println("\n");
        System.out.println("--Sort the tracks by rating in descending order--");
            tracks.sort( new Comparator<musicTracks>() {
                @Override
                public int compare(musicTracks o1, musicTracks o2) {
                   return Double.compare(o2.getRating(),o1.getRating()); //to reverse
                   /* int r = 0;
                    if(o1.getRating() < o2.getRating())
                        r = 1;
                    else if(o1.getRating() > o2.getRating())
                        r = -1;
                    else
                        r = 0;
                    return r;*/
                }
            });
        for(musicTracks m: tracks) {
            System.out.println(m);
        }
        System.out.println("\n");
        System.out.println("--Sort the tracks by artist--");
            tracks.sort(
                    (musicTracks m1, musicTracks m2)-> m1.getArtist().compareToIgnoreCase(m2.getArtist())
            );
            for(musicTracks m: tracks) {
                System.out.println(m);
            }
        Scanner sc = new Scanner(System.in);
        System.out.println("Which artist?");
        String artist = sc.next();
        System.out.println("--Sort duration of selected artist in ascending order: --");
        //create a new list only get artist name
       //List<musicTracks> track2 = tracks

        tracks.stream()
                .filter(a -> a.getArtist().equals(artist))
                .sorted(Comparator.comparing(musicTracks::getDuration))
                 .forEach(s -> System.out.println(s.toString()));
        System.out.println("\n");

    }
}

