package com.Nhan;

public class musicTracks  implements Comparable<musicTracks>{
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private String title;
    private String artist;
    private double duration;
    private double rating;

    public musicTracks(String title, String artist, double duration, double rating){
        this.title= title;
        this.artist= artist;
        this.duration= duration;
        this.rating= rating;
    }

    public String toString(){
        return "Title: "+ title +"\t\t Artist: "+ artist +"\t\t Duration: "+ duration+"\t\t Rating: "+rating +"\t\t";
    }

    public int compareTo(musicTracks mT){
        return title.compareToIgnoreCase(mT.title);
    }

}
