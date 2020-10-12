import java.awt.Color;

/**
 * sunny background.
 * full of sunshine.
 */
public class SunnyBackground extends Background {
    private Color backgroundColor;
    private SpriteCollection drawings;
    private Frame frame;
    private Circle sun;
    static final int SPACE_BETWEEN_RAYS = 15;

    /**
     * constructor.
     */
    public SunnyBackground() {
        this.backgroundColor = Color.cyan;
        this.drawings = new SpriteCollection();
        this.frame = new Frame(this.backgroundColor);
        this.sun = new Circle(new Point(400, 30), 100, Color.yellow);
        this.drawings.addSprite(this.frame);
        this.drawings.addSprite(this.sun);
        DrawingLine l;
        int x, y;
        x = 0;
        y = 40;
        for (int i = 0; i < 35; i++) {
            l = new DrawingLine(new Point((int) this.sun.getCenter().getX(), (int) this.sun.getCenter().getY()),
                    new Point(x, y), Color.yellow);
            this.drawings.addSprite(l);
            y += SPACE_BETWEEN_RAYS;
        }
        for (int i = 0; i < 80; i++) {
            l = new DrawingLine(new Point((int) this.sun.getCenter().getX(), (int) this.sun.getCenter().getY()),
                    new Point(x, y), Color.yellow);
            this.drawings.addSprite(l);
            x += SPACE_BETWEEN_RAYS;
        }
        for (int i = 0; i < 35; i++) {
            l = new DrawingLine(new Point((int) this.sun.getCenter().getX(), (int) this.sun.getCenter().getY()),
                    new Point(x, y), Color.yellow);
            this.drawings.addSprite(l);
            y -= SPACE_BETWEEN_RAYS;
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override
    public SpriteCollection getDrawings() {
        return this.drawings;
    }

    @Override
    public void timePassed() {
    }
}
