import biuoop.DrawSurface;

/**
 * a sprite that is a drop of rain.
 */
public class RainDrop implements Sprite {
    private DrawingLine originalDrop;
    private DrawingLine drop;

    /**
     *
     * @param dl the drops line.
     * constructor.
     */
    public RainDrop(DrawingLine dl) {
        this.drop = dl;
        this.originalDrop = dl;
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.drop.drawOn(d);
    }

    @Override
    public void timePassed() {
        double moveByX = Ass5Game.SCREEN_WIDTH - this.originalDrop.getStart().getX();
        //double moveByY = this.drop.getStart().getY() - this.originalDrop.getStart().getY();
        this.drop.moveStartBy(3);
        if (this.drop.getStart().getY() >= Ass5Game.SCREEN_HEIGHT) {
            this.drop.setStart(new Point(this.drop.getStart().getX() - 600, this.drop.getStart().getY() - 600));
        }
        if (this.drop.getStart().getX() >= Ass5Game.SCREEN_WIDTH) {
            this.drop.setStart(new Point(this.drop.getStart().getX() - moveByX, this.drop.getStart().getY() - moveByX));
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
