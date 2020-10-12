import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a drawing of a spaceship.
 */
public class Spaceship implements Sprite {
    private Point startPoint;

    /**
     *
     * @param x the x coordinates of the spaceships center.
     * @param y the y coordinates of the spaceships center.
     * constructor.
     */
    public Spaceship(int x, int y) {
        this.startPoint = new Point(x, y);
    }

    /**
     *
     * @param p the spaceships center.
     * constructor.
     */
    public Spaceship(Point p) {
        this.startPoint = p;
    }

    @Override
    public void timePassed() {
        if (this.startPoint.getY() <= 0) {
            this.startPoint = new Point(this.startPoint.getX() - 600, this.startPoint.getY() + 600);
        } else {
            this.startPoint = new Point(this.startPoint.getX() + 1, this.startPoint.getY() - 1);
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green);
        d.drawOval((int) this.startPoint.getX(), (int) this.startPoint.getY(), 100, 50);
        d.setColor(Color.red);
        d.fillOval((int) this.startPoint.getX(), (int) this.startPoint.getY(), 100, 50);
        d.setColor(Color.green);
        d.drawCircle((int) this.startPoint.getX() + 50, (int) this.startPoint.getY() + 10, 30);
        d.setColor(Color.red);
        d.fillOval((int) this.startPoint.getX(), (int) this.startPoint.getY() + 12, 100, 30);
        d.setColor(Color.black);
        d.drawOval((int) this.startPoint.getX() + 20, (int) this.startPoint.getY() + 6, 59, 20);
        d.fillCircle((int) this.startPoint.getX() + 12, (int) this.startPoint.getY() + 32, 5);
        d.fillCircle((int) this.startPoint.getX() + 25, (int) this.startPoint.getY() + 40, 5);
        d.fillCircle((int) this.startPoint.getX() + 43, (int) this.startPoint.getY() + 43, 5);
        d.fillCircle((int) this.startPoint.getX() + 61, (int) this.startPoint.getY() + 43, 5);
        d.fillCircle((int) this.startPoint.getX() + 78, (int) this.startPoint.getY() + 39, 5);
        d.fillCircle((int) this.startPoint.getX() + 90, (int) this.startPoint.getY() + 30, 5);
    }
}
