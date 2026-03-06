import Devices.Fan;
import Devices.Light;
import Devices.Tv;

public class CommandService {
    public static void main(String[] args) {
        
        LightOnCommand lightOn = new LightOnCommand(new Light());
        LightOffCommand lightOff = new LightOffCommand(new Light());

        Remote remote = new Remote();
        remote.setCommand(lightOff);
        remote.press();
        remote.undo();

        remote.setCommand(lightOn);
        remote.press();
        remote.undo();


        FanOnCommand fanOn = new FanOnCommand(new Fan());
        FanOffCommand fanOff = new FanOffCommand(new Fan());
        remote.setCommand(fanOn);
        remote.press();
        remote.undo();

        remote.setCommand(fanOff);
        remote.press();
        remote.undo();


        TvOnCommand tvOn = new TvOnCommand(new Tv());
        TvOffCommand tvOff = new TvOffCommand(new Tv());

        remote.setCommand(tvOn);
        remote.press();
        remote.undo();


        remote.setCommand(tvOff);
        remote.press();
        remote.undo();


    }
}


