/*
 * Created on Oct 1, 2018
 *
 */
package music;

import music.enums.Genre;

public class Performer extends Musician implements PerformingArtist {
    
    protected String name;
    private boolean aliveAndKicking;
    protected int age;
    protected Performance firstPerformance;
    
    public Performer(Genre genre, String name, boolean aliveAndKicking, int age, Performance firstPerformance) {
        super(genre);
        this.name = name;
        this.aliveAndKicking = aliveAndKicking;
        this.age = age;
        this.firstPerformance = firstPerformance;
    }

    public Performer(String name, boolean aliveAndKicking, int age) {
        super();
        this.name = name;
        this.aliveAndKicking = aliveAndKicking;
        this.age = age;
    }

    public Performer(String name) {
        super();
        this.name = name;
        this.aliveAndKicking = true;
        this.age = 30;
    }

    public Performer() {
        super();
    }
    
    @Override
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("I'm playing...");
    }

    public void play(Song song) {
//        System.out.print(this.name + " playing " + song.getTitle());
        System.out.println(this.name + ", playing \"" + song.getTitle() + "\"");
    }
    
    @Override
    public void showFirstPerformance() {
        System.out.println(this.name + "'s first performance: " + this.firstPerformance);
    }

    @Override
    public double showAvgPerformanceTime() {
        return this.age > 50 ? 120 : 70;
    }

    @Override
    public String toString() {
    	return "Performer: " + this.name + ", " + (this.aliveAndKicking ? "active" : "not active");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAliveAndKicking() {
        return aliveAndKicking;
    }

    public void setAliveAndKicking(boolean aliveAndKicking) {
        this.aliveAndKicking = aliveAndKicking;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Performance getFirstPerformance() {
        return firstPerformance;
    }

    public void setFirstPerformance(Performance firstPerformance) {
        this.firstPerformance = firstPerformance;
    }

}
