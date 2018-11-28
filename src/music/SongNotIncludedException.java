/*
 * Created on Nov 28, 2018
 *
 */
package music;

public class SongNotIncludedException extends Exception {
    
    private Song song;
    private Album album;
    
    public SongNotIncludedException(Song song, Album album) {
        super();
        this.song = song;
        this.album = album;
    }
    
    public SongNotIncludedException() {
        super();
    }
    
    @Override
    public String getMessage() {
        return "Song " + '\"' + this.song.getTitle() + '\"' + " not included on album " + '\"' + album.getTitle() + '\"';
    }
    
    public Song getSong() {
        return song;
    }
    public void setSong(Song song) {
        this.song = song;
    }
    public Album getAlbum() {
        return album;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }

}
