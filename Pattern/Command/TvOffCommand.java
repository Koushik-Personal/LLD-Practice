import Devices.Tv;

public class TvOffCommand implements Command {
    
    private final Tv tv;

    TvOffCommand( Tv tv ) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }   
}
