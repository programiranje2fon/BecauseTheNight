/*
 * Created on Nov 4, 2018
 *
 */
package music;

import music.enums.Genre;

public abstract class Musician {
    
    protected Genre genre;

    public Musician(Genre genre) {
        super();
        this.genre = genre;
    }
    
    public Musician() {
        super();
    }
    
    public abstract void play();

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    

}
