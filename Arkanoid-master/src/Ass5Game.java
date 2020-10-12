import biuoop.GUI;
import biuoop.Sleeper;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;

/**
 * Executing class.
 */
public class Ass5Game {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    static final String[] LEVELS = {"1", "2", "3", "4"};
    static final LevelInformation[] LEVEL_INFO = {new Level1(), new Level2(), new Level3(), new Level4()};

    /**
     *
     * @param args the arguments to the main.
     * the main function.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", SCREEN_WIDTH, SCREEN_HEIGHT);
        Sleeper sleep = new Sleeper();
        AnimationRunner animationRunner = new AnimationRunner(gui, sleep);
        KeyboardSensor ks = gui.getKeyboardSensor();
        GameFlow game = new GameFlow(animationRunner, ks, gui);
        List<LevelInformation> levels = new ArrayList<>();
        //go over parameters.
        for (int i = 0; i < args.length; i++) {
            //go over level array
            for (int j = 0; j < LEVELS.length; j++) {
                //if the argument is a level of the game.
                if (args[i].toString().equals(LEVELS[j])) {
                    //add the level to executing array.
                    levels.add(LEVEL_INFO[j]);
                }
            }
        }
        //if no levels were enterd as parameter,run the game as usual.
        if (args.length == 0 || levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }
        //run the game.
        game.runLevels(levels);
    }
}