import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a cloud object.
 */
public class Cloud implements Sprite {
    private Point location;
    private Color cloudColor;

    /**
     *
     * @param location a starting point for the cloud.
     * @param c the color of the could.
     * constructor.
     */
    public Cloud(Point location, Color c) {
        this.location = location;
        this.cloudColor = c;
    }

    /**
     *
     * @param x the x value of the starting point for the cloud.
     * @param y the y value of the starting point for the cloud.
     * @param c the color of the could.
     * constructor.
     */
    public Cloud(int x, int y, Color c) {
        this.location = new Point(x, y);
        this.cloudColor = c;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void drawOn(DrawSurface d) {
        int x = (int) this.location.getX(), y = (int) this.location.getY(), size = 30, unit = size / 20;
        d.setColor(this.cloudColor);
        d.fillCircle(x, y, size);
        d.fillCircle(x - 2 * size / 4, y - 15 * unit, size);
        d.fillCircle(x + 18 * unit, y, size);
        d.fillCircle(x + 2 * size / 4, y - 17 * unit, size);
        d.fillCircle(x - 19 * unit, y, size);
        d.fillCircle(x, y + 15, size);
        d.fillCircle(x + 30, y, size);
        d.fillCircle(x + 45, y, size);
        d.fillCircle(x - 20, y - 20, size);
        d.fillCircle(x, y - 30, size);
        d.fillCircle(x + 70, y + 10, size);
        d.fillCircle(x + 90, y - 10, size);
        d.fillCircle(x + 55, y - 30, size);
        d.fillCircle(x + 20, y - 40, size);
        d.fillCircle(x + 25, y + 25, size);
    }
}
