import java.util.ArrayList;
import java.util.List;

public class MusicList implements MusicCollection {
    
    List<Music> musicList;

    public MusicList() {
        musicList = new ArrayList<>();
    }

    public void add(Music music) {
        musicList.add(music);
    }

    public SongIterator<Music> createIterator() {
        Music[] musicArray = new Music[musicList.size()];
        musicList.toArray(musicArray);
        return new MusicIterator(musicArray);
    }
}
