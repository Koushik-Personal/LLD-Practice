
public interface MusicCollection {
    SongIterator<Music> createIterator();
    void add(Music music);   
}
