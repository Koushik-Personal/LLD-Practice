public class Mp3Adapter implements MediaPlayer {

    private final Mp3Player mp3Player;

    public Mp3Adapter(Mp3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    @Override
    public void play() {
        mp3Player.play();
    }

    @Override
    public void pause() {
        mp3Player.pause();
    }

    @Override
    public void stop() {
        mp3Player.stop();
    }

    @Override
    public void next() {
        mp3Player.next();
    }

    @Override
    public void previous() {
        mp3Player.previous();
    }

    @Override
    public void volumeUp() {
        mp3Player.volumeUp();
    }

    @Override
    public void volumeDown() {
        mp3Player.volumeDown();
    }

}
