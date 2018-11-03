/*
 * Created on Nov 3, 2018
 *
 */
package music;

import music.enums.Instrument;

public class MusicPlayer extends Performer {

    private Instrument instrument;

    public MusicPlayer(String name, boolean aliveAndKicking, int age, Instrument instrument) {
        super(name, aliveAndKicking, age);
        this.instrument = instrument;
    }

    public MusicPlayer() {
        super();
        this.instrument = Instrument.GUITAR;
    }
    
    public void play() {
        System.out.println(this.getName() + ", playing " + (this.instrument).toString().toLowerCase() + "...");
    }
    
    public void play(Song song) {
//        super.play(song);
        System.out.println("Song: " + song.getTitle());
        play();
    }
    
    @Override
    public String toString() {
//        return super.toString() + " (" + this.instrument + ")";
        return super.toString() + " (" + (this.instrument).toString().toLowerCase() + ")";
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
    
    
}
