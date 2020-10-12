import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a drawing circle.
 */
public class Circle implements Sprite {
    private Point center;
    private int size;
    private Color color;
    private boolean fill;

    /**
     *
     * @param p center point of circle.
     * @param size the circles size.
     * @param c circles color.
     * constructor.
     */
    public Circle(Point p, int size, Color c) {
        this.center = p;
        this.size = size;
        this.color = c;
        this.fill = true;
    }

    /**
     *
     * @param p center point of circle.
     * @param size the circles size.
     * constructor.
     */
    public Circle(Point p, int size) {
        this.center = p;
        this.size = size;
        this.color = Color.black;
        this.fill = true;
    }

    /**
     *
     * @param p center point of circle.
     * @param size the circles size.
     * @param fill fill circle or not.
     * @param c circles color.
     * constructor.
     */
    public Circle(Point p, int size, Color c, boolean fill) {
        this.center = p;
        this.size = size;
        this.color = c;
        this.fill = fill;
    }

    /**
     *
     * @param p center point of circle.
     * @param size the circles size.
     * @param fill fill circle or not.
     * constructor.
     */
    public Circle(Point p, int size, boolean fill) {
        this.center = p;
        this.size = size;
        this.color = Color.black;
        this.fill = fill;
    }

    /**
     *
     * @return returns the circles color.
     */
    public Color getColor() {
        return this.color;
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        if (this.fill) {
            d.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.size);
        } else {
            d.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.size);
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     *
     * @return returns the circles center point.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     *
     * @return returns the circles size.
     */
    public int getSize() {
        return this.size;
    }
}
