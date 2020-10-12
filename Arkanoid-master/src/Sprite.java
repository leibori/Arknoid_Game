import biuoop.DrawSurface;

/**
 * An object in the game.
 */
public interface Sprite {

    /**
     *
     * @param d a DrawSurface object.
     * draw the sprite to the screen.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     *
     * @param g a game object.
     * adds a sprite object to a game.
     */
    void addToGame(GameLevel g);
}