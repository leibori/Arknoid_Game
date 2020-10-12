import biuoop.DrawSurface;

/**
 * indicates how many lives are left.
 */
public class LivesIndicator implements Sprite {
    private Counter lives;

    /**
     *
     * @param l a new counter for lives.
     * constructor.
     */
    public LivesIndicator(Counter l) {
        this.lives = l;
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(100, 20, "Lives: " + this.lives.getValue(), 20);
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
