import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 4.
 */
public class Level4 implements LevelInformation {
    static final int BORDER_HEIGHT_OR_WIDTH = 17;
    static final int REC_WIDTH = 51;
    static final int REC_HEIGHT = 30;
    static final int NUMBER_OF_HITS = 1;
    static final int NUMBER_OF_ROWS = 7;
    static final Color[] COLORS = {Color.lightGray, Color.red, Color.yellow, Color.blue, Color.pink, Color.green,
            Color.gray};

    @Override
    public Sprite getBackground() {
        return new UnderwaterBackground();
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }

    @Override
    public int paddleWidth() {
        return 120;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int x = BORDER_HEIGHT_OR_WIDTH, y = 100, count = 15;
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            while (count > 0) {
                Point p = new Point((double) x, (double) y);
                Rectangle r = new Rectangle(p, REC_WIDTH, REC_HEIGHT);
                Block block;
                block = new DestroyableBlock(r, COLORS[i], NUMBER_OF_HITS);
                blocks.add(block);
                x += REC_WIDTH;
                count--;
            }
            x = BORDER_HEIGHT_OR_WIDTH;
            y += REC_HEIGHT;
            count = 15;
        }
        return blocks;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocitys = new ArrayList<>();
        velocitys.add(new Velocity(-2, -5));
        velocitys.add(new Velocity(0, -5));
        velocitys.add(new Velocity(2, -5));
        return velocitys;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }
}