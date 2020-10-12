import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a line sprite.
 */
public class DrawingLine implements Sprite {
    private Point start;
    private Point end;
    private Color color;

    /**
     *
     * @param start lines starting point.
     * @param end lines end point.
     * @param c the lines color.
     * constructor.
     */
    public DrawingLine(Point start, Point end, Color c) {
        this.start = start;
        this.end = end;
        this.color = c;
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) this.start.getX(), (int) this.start.getY(), (int) this.end.getX(),
                (int) this.end.getY());
    }

    /**
     *
     * @param move the amount of pixles to move the line by.
     * moves the line a cretain amount of pixles from its current location.
     */
    public void moveStartBy(int move) {
        this.start = new Point(this.start.getX() + move, this.start.getY() + move);
        this.end = new Point(this.end.getX() + move, this.end.getY() + move);
    }

    /**
     *
     * @return returns the lines start point.
     */
    public Point getStart() {
        return this.start;
    }

    /**
     *
     * @param newStart the point to set the lines starting point to.
     * sets the line to a new location.
     */
    public void setStart(Point newStart) {
        double dist = this.start.getX() - this.end.getX();
        this.start = newStart;
        this.end = new Point(this.start.getX() + dist, this.start.getY() + dist);
    }
}
