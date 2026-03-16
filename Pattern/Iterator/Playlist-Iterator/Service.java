public class Service {
    
    public static void main(String[] args) {
        MusicCollection musicList = new MusicList();
        musicList.add(new Music("music1"));
        musicList.add(new Music("music2"));
        musicList.add(new Music("music3"));


        SongIterator<Music> iterator = musicList.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().name);
        }
    }
}
