public class VlcAdapter implements MediaPlayer {

    private final VlcPlayer vlcPlayer;

    public VlcAdapter(VlcPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }

    @Override
    public void play() {
        vlcPlayer.play( );
    }

    @Override
    public void pause() {
        vlcPlayer.pause();
    }

    @Override
    public void stop() {
        vlcPlayer.stop();
    }

    @Override
    public void next() {
        vlcPlayer.next();
    }

    @Override
    public void previous() {
        vlcPlayer.previous();
    }

    @Override
    public void volumeUp() {
        vlcPlayer.volumeUp();
    }    

    @Override
    public void volumeDown() {
        vlcPlayer.volumeDown();
    }

    
}
