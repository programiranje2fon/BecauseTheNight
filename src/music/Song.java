/*
 * Created on Oct 1, 2018
 *
 */
package music;

public class Song {
    
    private String title;
    private int year;
    private Performer performer;
    
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
    
    public void play() {
        System.out.print("Playing: " + this.title + "(" + this.performer.getName() + ")");
//        System.out.println(this.title);
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
    public Performer getPerformer() {
        return performer;
    }
    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

}
