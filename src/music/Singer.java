/*
 * Created on Nov 3, 2018
 *
 */
package music;

import music.enums.Vocals;

public class Singer extends Performer {
    
    private Vocals vocals;

    public Singer(String name, boolean aliveAndKicking, int age, Vocals vocals) {
        super(name, aliveAndKicking, age);
        this.vocals = vocals;
    }

    public Singer() {
        super();
        this.vocals = Vocals.LEAD;
    }
    
    @Override
    public String toString() {
        return super.toString() + "(" + this.vocals.toString().toLowerCase() + " vocals)";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vocals == null) ? 0 : vocals.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Singer other = (Singer) obj;
        if (vocals != other.vocals)
            return false;
        if (this.name != other.name)
            return false;
        if (this.age != other.age)
            return false;
        return true;
    }

    public Vocals getVocals() {
        return vocals;
    }

    public void setVocals(Vocals vocals) {
        this.vocals = vocals;
    }

}
