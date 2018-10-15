/*
 * Created on Oct 1, 2018
 *
 */
package music;

public class Song {
    
    private static String concept;
    
    private String title;
    private int year;
    private Performer performer;
    
    static {
        concept = "A nice piece of music";
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
        System.out.print("Playing: " + this.title + "(" + this.performer.getName() + ")");
//        System.out.println(this.title);
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

}
