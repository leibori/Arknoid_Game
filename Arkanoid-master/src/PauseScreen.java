import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

/**
 * the screen displayed when the game is paused.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     *
     * @param k a keyboardsensor.
     * constructor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }

    @Override
    public boolean shouldStop() { return this.stop; }
}