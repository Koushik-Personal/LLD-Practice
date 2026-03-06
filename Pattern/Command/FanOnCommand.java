import Devices.Fan;

public class FanOnCommand implements Command {

    private final Fan fan;

    FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();        
    }

    @Override
    public void undo() {
        fan.off();
    }
    
}
