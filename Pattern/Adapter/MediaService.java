public class MediaService {
    
    public static void main(String[] args) {
        
        MediaPlayer vlcPlayer = new VlcAdapter(new VlcPlayer("Vlc"));
        MediaPlayer mp3Player = new Mp3Adapter(new Mp3Player("MP3"));

        vlcPlayer.play();
        vlcPlayer.pause();
        vlcPlayer.stop();
        vlcPlayer.next();
        vlcPlayer.previous();
        vlcPlayer.volumeUp();
        vlcPlayer.volumeDown();

        mp3Player.play();
        mp3Player.pause();
        mp3Player.stop();
        mp3Player.next();
        mp3Player.previous();
        mp3Player.volumeUp();
        mp3Player.volumeDown();

    }
}
