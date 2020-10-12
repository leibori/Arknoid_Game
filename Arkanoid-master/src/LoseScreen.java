import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * the screen displayed when all lives are lost.
 */
public class LoseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;

    /**
     *
     * @param k a keyboardsensor.
     * @param score the score at the end of the game.
     * constructor.
     */
    public LoseScreen(KeyboardSensor k, int score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(Ass5Game.SCREEN_WIDTH / 4, Ass5Game.SCREEN_HEIGHT / 2, "Game Over. your score is " + this.score, 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
