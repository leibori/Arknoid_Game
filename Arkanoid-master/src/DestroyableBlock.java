import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * A block consisting of a rectangle.
 */
public class DestroyableBlock extends Block implements HitNotifier {
    private Rectangle rec;
    private Color color;
    private int hits;
    private List<HitListener> hitListeners;

    /**
     * @param rec1 A rectangle object.
     * @param c A color for the rectangle.
     * @param hits1 represents the number of hits the block has.
     * constructor.
     */
    public DestroyableBlock(Rectangle rec1, Color c, int hits1) {
        this.rec = rec1;
        this.color = c;
        this.hits = hits1;
        this.hitListeners = new ArrayList<>();
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
     * @param hitter the hitting ball.
     * notifys all listeners that a hit occurred.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     *
     * @return returns the list of listeners.
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
    }

    @Override
    public int getHitPoints() {
        return this.hits;
    }

    @Override
    public Rectangle getRec() {
        return this.rec;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = currentVelocity;
        if (this.hits > 0) {
            this.hits -= 1;
        }
        if (collisionPoint == null) {
            return v;
        }
        //check if collision occured on the edge of the block.
        if (collisionPoint.getY() == this.rec.getUpperLeft().getY() && collisionPoint.getX()
                == this.rec.getUpperLeft().getX()) {
            //if a corner was hit and DX is positive and DY is negative,change DX.
            //else change DY.
            if (currentVelocity.getDY() < 0 && currentVelocity.getDX() > 0) {
                v = new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            } else {
                v = new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
        } else if (collisionPoint.getY() == this.rec.getUpperLeft().getY() && collisionPoint.getX()
                == this.rec.getBottomRight().getX()) {
            //if a corner was hit and DX is negative and DY is negative,change DX.
            //else change DY.
            if (currentVelocity.getDY() < 0 && currentVelocity.getDX() < 0) {
                v = new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            } else {
                v = new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
        } else if (collisionPoint.getY() == this.rec.getBottomRight().getY() && collisionPoint.getX()
                == this.rec.getUpperLeft().getX()) {
            //if a corner was hit and DX is positive and DY is positive,change DX.
            //else change DY.
            if (currentVelocity.getDY() > 0 && currentVelocity.getDX() > 0) {
                v = new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            } else {
                v = new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
        } else if (collisionPoint.getY() == this.rec.getBottomRight().getY() && collisionPoint.getX()
                == this.rec.getBottomRight().getX()) {
            //if a corner was hit and DX is negative and DY is positive,change DX.
            //else change DY.
            if (currentVelocity.getDY() > 0 && currentVelocity.getDX() < 0) {
                v = new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
            } else {
                v = new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
            }
        } else if (collisionPoint.getY() == this.rec.getUpperLeft().getY()) { //if collision occurs on top line.
            v = new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
        } else if (collisionPoint.getY() == this.rec.getBottomRight().getY()) { //if collision occurs on bottom line.
            v = new Velocity(currentVelocity.getDX(), -currentVelocity.getDY());
        } else if (collisionPoint.getX() == this.rec.getUpperLeft().getX()) { //if collision occurs on left line.
            v = new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
        } else if (collisionPoint.getX() == this.rec.getBottomRight().getX()) { //if collision occurs on right line.
            v = new Velocity(-currentVelocity.getDX(), currentVelocity.getDY());
        }
        this.notifyHit(hitter);
        return v;
    }
}