import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;

/**
 * a moon sprite.
 */
public class Moon implements Sprite {
    private Circle moon;
    private ArrayList<Sprite> craters;

    /**
     *
     * @param c a Circle object.
     * constructor.
     */
    public Moon(Circle c) {
        this.moon = c;
        this.craters = new ArrayList<>();
        int unit = this.moon.getSize() / 100;
        Circle crater = new Circle(new Point(this.moon.getCenter().getX(), this.moon.getCenter().getY()), 2 * unit,
                Color.BLACK, false);
        Circle crater1 = new Circle(new Point(this.moon.getCenter().getX() - 20, this.moon.getCenter().getY() - 10),
                7 * unit, Color.BLACK, false);
        Circle crater2 = new Circle(new Point(this.moon.getCenter().getX(), this.moon.getCenter().getY() + 27),
                4 * unit, Color.BLACK, false);
        Circle crater3 = new Circle(new Point(this.moon.getCenter().getX() - 40, this.moon.getCenter().getY() - 37),
                6 * unit, Color.BLACK, false);
        Circle crater4 = new Circle(new Point(this.moon.getCenter().getX() + 35, this.moon.getCenter().getY() - 23),
                17 * unit, Color.BLACK, false);
        Circle crater5 = new Circle(new Point(this.moon.getCenter().getX() + 41,
                this.moon.getCenter().getY() + 43), 10 * unit, Color.BLACK, false);
        Circle crater6 = new Circle(new Point(this.moon.getCenter().getX() - 60,
                this.moon.getCenter().getY() + 38), 5 * unit, Color.BLACK, false);
        Circle crater7 = new Circle(new Point(this.moon.getCenter().getX() + 12, this.moon.getCenter().getY() + 100),
                20 * unit, Color.BLACK, false);
        Circle crater8 = new Circle(new Point(this.moon.getCenter().getX() - 47, this.moon.getCenter().getY() - 90),
                14 * unit, Color.BLACK, false);
        Circle crater9 = new Circle(new Point(this.moon.getCenter().getX() + 70, this.moon.getCenter().getY() - 70),
                14 * unit, Color.BLACK, false);
        this.craters.add(crater);
        this.craters.add(crater1);
        this.craters.add(crater2);
        this.craters.add(crater3);
        this.craters.add(crater4);
        this.craters.add(crater5);
        this.craters.add(crater6);
        this.craters.add(crater7);
        this.craters.add(crater8);
        this.craters.add(crater9);
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.moon.drawOn(d);
        for (int i = 0; i < this.craters.size(); i++) {
            this.craters.get(i).drawOn(d);
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed() {

    }
}
