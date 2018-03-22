package mindcraft3495.scout;

/**
 * Created by 7nys on 2/10/2018.
 **/

public class TeleopActivity {
    public String switchBoxes;
    public String scaleBoxes;
    public String boxesFumbled;
    public String exchangeBoxes;
    public String Climbed;
    public String Incap;
    public String Disabled;
    public String Robot;
    public String Robot2;

    public TeleopActivity(){

    }

    public TeleopActivity(String switchBoxes, String scaleBoxes, String boxesFumbled, String exchangeBoxes, String climbed, String incap, String disabled, String robot, String robot2) {
        this.switchBoxes = switchBoxes;
        this.scaleBoxes = scaleBoxes;
        this.boxesFumbled = boxesFumbled;
        this.exchangeBoxes = exchangeBoxes;
        Climbed = climbed;
        Incap = incap;
        Disabled = disabled;
        Robot = robot;
        Robot2 = robot2;
    }
}
