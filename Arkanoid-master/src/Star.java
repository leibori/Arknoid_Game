import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a drawing of a star.
 */
public class Star implements Sprite {
    private Color starColor;
    private Color backgroundColor;
    private Point topLeft;
    private int starSize;
    private int circleSize;

    /**
     *
     * @param p the stars location.
     * @param size the stars size.
     * @param backgroundColor the stars background color.
     * constructor.
     */
    public Star(Point p, int size, Color backgroundColor) {
        this.starColor = Color.yellow;
        this.backgroundColor = backgroundColor;
        this.topLeft = p;
        this.starSize = size;
        this.circleSize = size / 2;
    }

    @Override
    public void drawOn(DrawSurface d) {
        Rectangle r = new Rectangle(this.topLeft, this.starSize, this.starSize);
        d.setColor(this.starColor);
        d.fillRectangle((int) this.topLeft.getX(), (int) this.topLeft.getY(), this.starSize, this.starSize);
        d.setColor(this.backgroundColor);
        d.fillCircle((int) r.getUpperLeft().getX(), (int) r.getUpperLeft().getY(), this.circleSize);
        d.fillCircle((int) r.getUpperLeft().getX(), (int) r.getBottomRight().getY(), this.circleSize);
        d.fillCircle((int) r.getBottomRight().getX(), (int) r.getUpperLeft().getY(), this.circleSize);
        d.fillCircle((int) r.getBottomRight().getX(), (int) r.getBottomRight().getY(), this.circleSize);
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed() {

    }
}
