public class MusicIterator implements SongIterator<Music> {
    private Music[] list;
    private int position = 0;

    public MusicIterator(Music[] list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.length && list[position] != null;
    }

    @Override
    public Music next() {
        Music musicItem = list[position];
        position++;
        return musicItem;
    }
}