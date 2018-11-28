/*
 * Created on Oct 8, 2018
 *
 */
package music;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Album {
    
    private String title;
    private int year;
    private Song[] songs;
    private GregorianCalendar releaseDate;
    
    public Album(String title, int year, Song[] songs, GregorianCalendar releaseDate) {
		super();
		this.title = title;
		this.year = year;
		this.songs = songs;
		this.releaseDate = releaseDate;
	}

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
    
    public void printReleaseDate() {
    	SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
    	System.out.println(df.format(this.releaseDate.getTime()));
    }
    
    public boolean includes(Song song) {
        boolean includes = false;
        for (Song s : songs) {
            if (s.getTitle().equals(song.getTitle())) {
                includes = true;
                break;
            }
        }
        return includes;
    }
    
    public static void playSong(Song song, Album album) throws SongNotIncludedException {
        if (album.includes(song)) {
            song.play();
        } else {
            throw new SongNotIncludedException(song, album);
        }
    }

    public String toString() {
    	return this.title + ", " + this.year;
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

	public GregorianCalendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(GregorianCalendar releaseDate) {
		this.releaseDate = releaseDate;
	}

}
