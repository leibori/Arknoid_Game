import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * the screen displayed when the game is won.
 */
public class WinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;

    /**
     *
     * @param k a keyboardsensor.
     * @param score the players score.
     * constructor.
     */
    public WinScreen(KeyboardSensor k, int score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Crown crown = new Crown();
        crown.drawOn(d);
        d.setColor(Color.black);
        d.drawText(Ass5Game.SCREEN_WIDTH / 4, Ass5Game.SCREEN_HEIGHT / 2, "You Win! Your score is " + this.score, 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }
}
