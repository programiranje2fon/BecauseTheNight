/*
 * Created on Nov 5, 2018
 *
 */
package music;

import music.enums.Genre;

public class Composer extends Musician {
    
    private String name;

    public Composer(Genre genre, String name) {
        super(genre);
        this.name = name;
    }

    public Composer() {
        super(Genre.ROCK);
    }

    @Override
    public void play() {
        System.out.println("I just compose that music, but I don't perform in public.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
