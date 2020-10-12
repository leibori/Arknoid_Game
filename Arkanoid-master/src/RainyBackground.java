import java.awt.Color;
import java.util.Random;

/**
 * a background the makes you feel the nature.
 */
public class RainyBackground extends Background {
    private SpriteCollection collection;
    private Color backgroundColor;

    /**
     * constructor.
     */
    public RainyBackground() {
        this.collection = new SpriteCollection();
        this.backgroundColor = new Color(102, 51, 0);
        Frame f = new Frame(Color.blue);
        DrawingRectangle grass = new DrawingRectangle(new Point(0, Ass5Game.SCREEN_HEIGHT - Ass5Game.SCREEN_HEIGHT / 3),
                Ass5Game.SCREEN_WIDTH, 50, Color.green);
        DrawingRectangle dirt = new DrawingRectangle(new Point(0, Ass5Game.SCREEN_HEIGHT - Ass5Game.SCREEN_HEIGHT
                / 3 + 50), Ass5Game.SCREEN_WIDTH, Ass5Game.SCREEN_HEIGHT / 3 + 50, new Color(102, 51, 0));
        Cloud c = new Cloud(new Point(50, 100), Color.darkGray);
        Cloud c1 = new Cloud(new Point(100, 100), Color.darkGray);
        Cloud c2 = new Cloud(new Point(200, 100), Color.darkGray);
        Cloud c3 = new Cloud(new Point(300, 100), Color.darkGray);
        Cloud c4 = new Cloud(new Point(400, 100), Color.darkGray);
        Cloud c5 = new Cloud(new Point(500, 100), Color.darkGray);
        Cloud c6 = new Cloud(new Point(600, 100), Color.darkGray);
        Cloud c7 = new Cloud(new Point(700, 100), Color.darkGray);
        this.collection.addSprite(f);
        for (int i = 0; i < 500; i++) {
            Random r = new Random();
            int x = r.nextInt(Ass5Game.SCREEN_WIDTH + 200) - 200, y = r.nextInt(Ass5Game.SCREEN_HEIGHT);
            int length = r.nextInt(5);
            DrawingLine l = new DrawingLine(new Point(x, y), new Point(x + length, y + length), Color.cyan);
            RainDrop drop = new RainDrop(l);
            this.collection.addSprite(drop);
        }
        this.collection.addSprite(c);
        this.collection.addSprite(c1);
        this.collection.addSprite(c2);
        this.collection.addSprite(c3);
        this.collection.addSprite(c4);
        this.collection.addSprite(c5);
        this.collection.addSprite(c6);
        this.collection.addSprite(c7);
        this.collection.addSprite(grass);
        this.collection.addSprite(dirt);
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed() {
        this.collection.notifyAllTimePassed();
    }

    @Override
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override
    public SpriteCollection getDrawings() {
        return this.collection;
    }
}
