/*
 * Created on Oct 1, 2018
 *
 */
package music;

public class Performer {
    
    private String name;
    private boolean aliveAndKicking;
    private int age;
    
    public Performer(String name, boolean aliveAndKicking, int age) {
        super();
        this.name = name;
        this.aliveAndKicking = aliveAndKicking;
        this.age = age;
    }

    public Performer() {
        super();
    }
    
    public void play(Song song) {
        System.out.print(this.name + ", playing " + song.getTitle());
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

}
