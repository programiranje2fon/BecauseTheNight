/*
 * Created on Nov 3, 2018
 *
 */
package music;

import music.enums.GuitarRole;
import music.enums.Instrument;

public class GuitarPlayer extends MusicPlayer {

    private GuitarRole guitarRole;

    public GuitarPlayer(String name, boolean aliveAndKicking, int age, Instrument instrument, GuitarRole guitarRole) {
        super(name, aliveAndKicking, age, instrument);
        this.guitarRole = guitarRole;
    }

    public GuitarPlayer() {
        super();
        this.guitarRole = GuitarRole.LEAD;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.delete(sb.indexOf("(") + 1, sb.length()).append(this.guitarRole.toString().toLowerCase() + " guitar)");
        return sb.toString();
    }
    
    public void play(Song song) {
        super.play(song);
        if (this.guitarRole == GuitarRole.LEAD) {
            System.out.println("Playing solo...");
        } else {
            System.out.println("Playing rhythm guitar...");
        }
    }

    public GuitarRole getGuitarRole() {
        return guitarRole;
    }

    public void setGuitarRole(GuitarRole guitarRole) {
        this.guitarRole = guitarRole;
    }
    
    
}
