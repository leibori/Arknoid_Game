import biuoop.DrawSurface;
/**
 *
 */
public interface Animation {

    /**
     *
     * @param d creates one frame of the animation.
     */
    void doOneFrame(DrawSurface d);

    /**
     *
     * @return returns true if the game should stop running, false otherwise.
     */
    boolean shouldStop();
}