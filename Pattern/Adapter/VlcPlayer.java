public class VlcPlayer{

    String fileName;

    public VlcPlayer(String fileName) {
        this.fileName = fileName;
    }

    public void play() {
        System.out.println("playing vlc "+fileName);
    }

    public void pause() {
        System.out.println("pausing vlc " + fileName);
    }

    public void stop() {
        System.out.println("stopping vlc " + fileName);        
    }

    public void next() {
        System.out.println("nexting vlc " + fileName);
    }

    public void previous() {
        System.out.println("previously vlc " + fileName);
    }

    public void volumeUp() {
        System.out.println("volume's up vlc " + fileName);
    }

    public void volumeDown() {
        System.out.println("volume's down vlc " + fileName);
    }
}