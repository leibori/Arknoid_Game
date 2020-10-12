import java.awt.Color;
import java.util.Random;

/**
 * a night background.
 * the dark is an amazing place.
 */
public class NightBackground extends Background {
    private Color backgroundColor;
    private SpriteCollection drawings;
    private Frame frame;

    /**
     * constructor.
     */
    public NightBackground() {
        this.backgroundColor = Color.black;
        this.drawings = new SpriteCollection();
        this.frame = new Frame(this.backgroundColor);
        Star star = new Star(new Point(130, 350), 55, Color.black);
        Star star1 = new Star(new Point(300, 50), 50, Color.black);
        Star star2 = new Star(new Point(470, 430), 10, Color.black);
        Star star3 = new Star(new Point(550, 370), 40, Color.black);
        Star star4 = new Star(new Point(250, 150), 70, Color.black);
        Star star5 = new Star(new Point(470, 170), 60, Color.black);
        Circle moonCircle = new Circle(new Point(150, 180), 100, Color.white);
        Moon moon = new Moon(moonCircle);
        this.drawings.addSprite(this.frame);
        this.drawings.addSprite(star);
        this.drawings.addSprite(star1);
        this.drawings.addSprite(star2);
        this.drawings.addSprite(star3);
        this.drawings.addSprite(star4);
        this.drawings.addSprite(star5);
        Random r = new Random();
        int x, y, size;
        Circle c;
        for (int i = 0; i < 100; i++) {
            x = r.nextInt(Ass5Game.SCREEN_WIDTH);
            y = r.nextInt(Ass5Game.SCREEN_HEIGHT);
            size = r.nextInt(3);
            c = new Circle(new Point(x, y), size, Color.white, true);
            this.drawings.addSprite(c);
        }
        this.drawings.addSprite(moon);
        this.drawings.addSprite(new Spaceship(300, 400));
        this.drawings.addSprite(new Spaceship(450, 100));
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public SpriteCollection getDrawings() {
        return this.drawings;
    }

    @Override
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }
}
