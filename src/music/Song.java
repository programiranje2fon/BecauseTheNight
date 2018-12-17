/*
 * Created on Oct 1, 2018
 *
 */
package music;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.Icon;

public class Song implements Serializable {
    
    static final long serialVersionUID = 2242L;
    
    private static String concept;
    
    private String title;
    private int year;
    private Performer performer;
    
    private Icon icon;
    private String lyrics;
    
    static {
        concept = "A nice piece of music";
    }
    
    public Song(String title, int year, Performer performer, Icon icon, String lyrics) {
        super();
        this.title = title;
        this.year = year;
        this.performer = performer;
        this.icon = icon;
        this.lyrics = lyrics;
    }

    public Song(String title, int year, Performer performer) {
        super();
        this.title = title;
        this.year = year;
        this.performer = performer;
    }

    public Song(String title, int year) {
        super();
        this.title = title;
        this.year = year;
    }
    
    public Song() {
        super();
    }
    
    public static void defineConcept() {
//        System.out.println(this.concept);       // No way - concept is static!
        System.out.println(concept);
    }
    
    public void play() {
        System.out.print("Playing: " + this.title + " (" + this.performer.getName() + ")");
//        System.out.println(this.title);
    }
    
    public void serialize(String filename) {
//        ObjectOutputStream out = null;
//        try {
//            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(filename))));
//            out.writeObject(this);
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                try {
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(filename))))) {
            out.writeObject(this);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static Song deserialize(String filename) {
        Song song = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(filename)))) {
            song = (Song) in.readObject();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return song;
    }
    
    @Override
    public String toString() {
//    	return "Song: " + this.title + ", " + this.year + " (" + this.getPerformer().getName() + ")";
    	return this.title + ", " + this.year;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if ((title != null) && (title != "")) {
            this.title = title;
        } else {
            System.out.println("Error - title must not be null or \"\"");
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Performer getPerformer() {
        return performer;
    }
    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public static String getConcept() {
        return concept;
    }

    public static void setConcept(String concept) {
        Song.concept = concept;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

}
