import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 2.
 */
public class Level2 implements LevelInformation {
    static final int BORDER_HEIGHT_OR_WIDTH = 17;
    static final int REC_WIDTH = 51;
    static final int REC_HEIGHT = 30;
    static final int NUMBER_OF_HITS = 1;
    static final int NUMBER_OF_BLOCKS = 15;

    @Override
    public Sprite getBackground() {
        return new RainyBackground();
    }

    @Override
    public int paddleSpeed() {
        return 1;
    }

    @Override
    public int numberOfBalls() {
        return 5;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS;
    }

    @Override
    public int paddleWidth() {
        return 650;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int x = BORDER_HEIGHT_OR_WIDTH, y = 200, count = NUMBER_OF_BLOCKS;
        while (count > 0) {
            Point p = new Point((double) x, (double) y);
            Rectangle r = new Rectangle(p, REC_WIDTH, REC_HEIGHT);
                Block block = new DestroyableBlock(r, Color.lightGray, NUMBER_OF_HITS);
            blocks.add(block);
            x += REC_WIDTH;
            count--;
        }
        return blocks;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocitys = new ArrayList<>();
        velocitys.add(new Velocity(0, -12));
        velocitys.add(new Velocity(2, -12));
        velocitys.add(new Velocity(-2, -12));
        velocitys.add(new Velocity(5, -12));
        velocitys.add(new Velocity(-5, -12));
        return velocitys;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }
}
