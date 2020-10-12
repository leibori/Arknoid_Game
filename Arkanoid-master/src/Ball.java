import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 *  Ball object has a center point value, a radius, a color,
 *  its own velocity for movement and its boundries which it can move in.
 */
public class Ball implements Sprite, HitNotifier {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment ge;
    private List<HitListener> hitListeners;
    private boolean shot;

    /**
     * @param center the center Point of the ball.
     * @param color  the color of the ball.
     * @param r      the radius of the ball.
     * @param ge     A GameEnvironment object.
     * @param shot indicates if the ball is a shot.
     * constructor.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment ge, boolean shot) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity();
        this.ge = ge;
        this.hitListeners = new ArrayList<>();
        this.shot = shot;
    }

    /**
     * @param center the center Point of the ball.
     * @param color  the color of the ball.
     * @param r      the radius of the ball.
     * @param ge     A GameEnvironment object.
     * constructor.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment ge) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity();
        this.ge = ge;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * @param x     the x value of the center.
     * @param y     the y value of the center.
     * @param r     the radius size.
     * @param color the color of the ball.
     * @param ge    A GameEnvironment object.
     * constructor.
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment ge) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity();
        this.ge = ge;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * @param center the center Point of the ball.
     * @param color  the color of the ball.
     * @param r      the radius of the ball.
     * @param v1     a new velocity object.
     * @param ge     A GameEnvironment object.
     * constructor.
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity v1, GameEnvironment ge) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = v1;
        this.ge = ge;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * @param x     the x value of the center.
     * @param y     the y value of the center.
     * @param r     the radius size.
     * @param color the color of the ball.
     * @param v1    a new velocity object.
     * @param ge    A GameEnvironment object.
     * constructor.
     */
    public Ball(double x, double y, int r, java.awt.Color color, Velocity v1, GameEnvironment ge) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = v1;
        this.ge = ge;
        this.hitListeners = new ArrayList<>();
    }

    @Override
    /**
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     *
     * @param g a gamelevel object.
     * removes the ball from a cretain game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    // accessors
    /**
     * @return Returns the x value of the center.
     * gets the balls centers x value.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return Returns the y value of the center.
     * gets the balls centers y value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return Returns the radius of the ball.
     * gets the balls size.
     */
    public int getSize() {
        return (int) this.r;
    }

    /**
     * @return Returns the xcolor of the ball.
     * gets the balls color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @return Returns the balls velocity.
     * gets balls velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * @param v1 A new velocity.
     * set the balls velocity to a given Velocity object.
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * @param dx the change in x.
     * @param dy the change in y.
     * set the balls velocity to a given dx dy values.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    @Override
    /**
     * @param surface a DrawSurface object
     * draw the ball on the given DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), (int) this.r);
    }

    /**
     * Moves the ball according to its Velocity.
     */
    public void moveOneStep() {
        double x = this.center.getX();
        double y = this.center.getY();
        Line tragectory = new Line(x, y, x + this.v.getDX(), y + this.v.getDY());
        CollisionInfo collision = this.ge.getClosestCollision(tragectory);
        // if there is no collision.
        if (collision == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            if (this.v.getDX() < 0) {
                this.center = new Point(x + this.r / 2, y);
            }
            if (this.v.getDX() > 0) {
                this.center = new Point(x - this.r / 2, y);
            }
            if (this.v.getDY() < 0) {
                this.center = new Point(x, y + this.r / 2);
            }
            if (this.v.getDY() > 0) {
                this.center = new Point(x, y - this.r / 2);
            }
            this.setVelocity(collision.collisionObject().hit(this, collision.collisionPoint(), this.v));
        }
    }

    @Override
    /**
     * moves the ball as time passes.
     */
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     *
     * @return true if the ball is a shot, false otherwise.
     */
    public boolean isShot() {
        return this.shot;
    }
}