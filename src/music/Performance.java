/*
 * Created on Nov 18, 2018
 *
 */
package music;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Performance {
    
    private GregorianCalendar date;
    private String location;
    
    public Performance(GregorianCalendar date, String location) {
        super();
        this.date = date;
        this.location = location;
    }
    
    public Performance() {
        super();
        this.date = new GregorianCalendar(0, 0, 0);                     // default; meant to denote unknown date
        this.location = "unknown";
    }
    
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
        return "date: " + (this.date.equals(new GregorianCalendar(0, 0, 0)) ? "unknown" : df.format(this.date.getTime())) + ", location: " + this.location;
    }
    
    public GregorianCalendar getDate() {
        return date;
    }
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
