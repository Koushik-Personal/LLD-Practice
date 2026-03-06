

public class Mp3Player{

    String fileName;

    public Mp3Player(String fileName) {
        this.fileName = fileName;
    }

    public void play() {
        System.out.println("playing mp3 "+fileName);
    }

    public void pause() {
        System.out.println("pausing mp3 "+fileName);
    }

    public void stop() {
        System.out.println("stopping mp3 "+fileName);
    }

    public void next() {
        System.out.println("nexting mp3 "+fileName);
    }

    public void previous() {
        System.out.println("previously mp3 "+fileName);
    }

    public void volumeUp() {
        System.out.println("volume's up mp3 "+fileName);
    }

    public void volumeDown() {
        System.out.println("volume's down mp3 "+fileName);
    }
    
}
