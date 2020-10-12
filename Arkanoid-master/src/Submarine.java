import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a drawing of a submarine.
 */
public class Submarine implements Sprite {
    private Point startPoint;
    private int width;
    private int height;
    private int startX;
    private int startY;

    /**
     *
     * @param x the submarines x coordinants.
     * @param y the submarines y coordinants.
     * @param width the submarines width.
     * @param height the submarines height.
     * constructor.
     */
    public Submarine(int x, int y, int width, int height) {
        this.startPoint = new Point(x, y);
        this.width = width;
        this.height = height;
        this.startX = x;
        this.startY = y;
    }

    /**
     *
     * @param p the submarines location.
     * @param width the submarines width.
     * @param height the submarines height.
     * constructor.
     */
    public Submarine(Point p, int width, int height) {
        this.startPoint = p;
        this.width = width;
        this.height = height;
        this.startX = (int) p.getX();
        this.startY = (int) p.getY();
    }

    @Override
    public void timePassed() {
        if (this.startPoint.getX() == 0 - this.width) {
            this.startPoint = new Point(Ass5Game.SCREEN_WIDTH, this.startY);
        } else {
            this.startPoint = new Point(this.startPoint.getX() - 1, this.startPoint.getY());
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillOval((int) this.startPoint.getX() + this.width / 2 - 20, (int) this.startPoint.getY() - 10, 40, 20);
        d.fillRectangle((int) this.startPoint.getX() + this.width / 2 - 5, (int) this.startPoint.getY() - 13, 10, 5);
        d.fillRectangle((int) this.startPoint.getX() + this.width / 2 - 4, (int) this.startPoint.getY() - 23, 8, 10);
        d.fillRectangle((int) this.startPoint.getX() + this.width / 2 - 20, (int) this.startPoint.getY() - 21, 20, 5);
        d.drawOval((int) this.startPoint.getX(), (int) this.startPoint.getY(), this.width, this.height);
        d.fillRectangle((int) this.startPoint.getX() + this.width, (int) this.startPoint.getY() + this.height
                / 2 - this.height / 18, 10, 10);
        d.fillOval((int) this.startPoint.getX() + this.width, (int) this.startPoint.getY() + this.height
                / 2 - this.height / 18 - 20, 10, 20);
        d.fillOval((int) this.startPoint.getX() + this.width, (int) this.startPoint.getY() + this.height
                / 2 - this.height / 18 + 8, 10, 20);
        d.setColor(Color.lightGray);
        d.fillOval((int) this.startPoint.getX(), (int) this.startPoint.getY(), this.width, this.height);
        d.setColor(Color.black);
        d.fillCircle((int) this.startPoint.getX() + this.width / 2, (int) this.startPoint.getY() + this.height
                / 2, 10);
        d.fillCircle((int) this.startPoint.getX() + this.width / 2 + 30, (int) this.startPoint.getY() + this.height
                / 2, 10);
        d.fillCircle((int) this.startPoint.getX() + this.width / 2 - 30, (int) this.startPoint.getY() + this.height
                / 2, 10);
    }
}
