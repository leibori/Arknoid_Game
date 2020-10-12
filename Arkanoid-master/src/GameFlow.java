import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * incharge of running the levels one after the other.
 */
public class GameFlow {
    private Counter score;
    private Counter lives;
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;
    static final int LIVES = 7;

    /**
     *
     * @param ar animationrunner object.
     * @param ks ketboardsensor object.
     * @param gui1 a new GUI object.
     * constructor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui1) {
        this.score = new Counter();
        this.lives = new Counter();
        this.lives.increase(LIVES);
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui1;
    }

    /**
     *
     * @param levels an array with the levels to run.
     * runs the levels in the array one after the other.
     */
    public void runLevels(List<LevelInformation> levels) {
        //go over the array of levels.
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner,
                    this.lives, this.score);
            level.initialize();
            while (this.lives.getValue() != 0 && level.getBlockCounter().getValue() != 0) {
                level.playOneTurn();
            }
            //if the player has no more lives.
            if (this.lives.getValue() == 0) {
                this.animationRunner.run(new LoseScreen(this.keyboardSensor, this.score.getValue()));
                break;
            }
        }
        //if the player has more lives.
        if (this.lives.getValue() != 0) {
            this.animationRunner.run(new WinScreen(this.keyboardSensor, this.score.getValue()));
        }
        //close the gui.
        this.gui.close();
    }
}