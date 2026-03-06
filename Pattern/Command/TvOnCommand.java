import Devices.Tv;

public class TvOnCommand implements Command {
    private final Tv tv;

    TvOnCommand( Tv tv ) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    } 
}
