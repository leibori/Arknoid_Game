import java.awt.Color;

/**
 * underwater background.
 * the sea world.
 */
public class UnderwaterBackground extends Background {
    private SpriteCollection collection;
    private Color backgroundColor;
    private Frame frame;

    /**
     * constructor.
     */
    public UnderwaterBackground() {
        this.collection = new SpriteCollection();
        this.backgroundColor = Color.BLUE;
        this.frame = new Frame(this.backgroundColor);
        this.collection.addSprite(frame);
        Submarine sub = new Submarine(300, 400, 200, 90);
        this.collection.addSprite(sub);
        DrawingLine l;
        int x, y, r = 0, g = 255, b = 255;
        x = Ass5Game.SCREEN_WIDTH;
        y = Ass5Game.SCREEN_HEIGHT;
        for (int i = 0; i < 35; i++) {
            l = new DrawingLine(new Point(Ass5Game.SCREEN_WIDTH / 2, 0), new Point(x, y), new Color(r, g, b));
            this.collection.addSprite(l);
            x += 20;
            r += 3;
        }
        for (int i = 0; i < 35; i++) {
            l = new DrawingLine(new Point(Ass5Game.SCREEN_WIDTH / 2, 0), new Point(x, y), new Color(r, g, b));
            this.collection.addSprite(l);
            r += 3;
            y -= 20;
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public SpriteCollection getDrawings() {
        return this.collection;
    }

    @Override
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }


}
