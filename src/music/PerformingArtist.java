/*
 * Created on Nov 18, 2018
 *
 */
package music;

public interface PerformingArtist {
    
    public void showFirstPerformance();
    public double avgPerformanceTime();
    default public void showMembers() {}

}
