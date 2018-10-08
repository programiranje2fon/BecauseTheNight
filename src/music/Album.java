/*
 * Created on Oct 8, 2018
 *
 */
package music;

public class Album {
    
    private String title;
    private int year;
    private Song[] songs;
    
    public Album(String title, int year, Song[] songs) {
        super();
        this.title = title;
        this.year = year;
        this.songs = songs;
    }

    public Album(String title, int year, int noOfSongs) {
        super();
        this.title = title;
        this.year = year;
        this.songs = new Song[noOfSongs];
    }

    public Album() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

}
