import Devices.Light;

public class LightOnCommand implements Command {
    
    private final Light light;

    LightOnCommand( Light light ) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();        
    }

}
