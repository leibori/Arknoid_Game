import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 3.
 */
public class Level3 implements LevelInformation {
    static final int BORDER_HEIGHT_OR_WIDTH = 17;
    static final int REC_WIDTH = 51;
    static final int REC_HEIGHT = 30;
    static final int NUMBER_OF_HITS = 1;
    static final int NUMBER_OF_BLOCKS = 40;
    static final int NUMBER_OF_ROWS = 5;
    static final Color[] COLORS = {Color.lightGray, Color.red, Color.yellow, Color.blue, Color.pink, Color.green,
            Color.gray};

    @Override
    public Sprite getBackground() {
        return new NightBackground();
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int x = Ass5Game.SCREEN_WIDTH - BORDER_HEIGHT_OR_WIDTH - 10 * REC_WIDTH, y = 150, count = 10;
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            while (count > 0) {
                Point p = new Point((double) x, (double) y);
                Rectangle r = new Rectangle(p, REC_WIDTH, REC_HEIGHT);
                Block block;
                if (i == 0) {
                    block = new DestroyableBlock(r, COLORS[i], NUMBER_OF_HITS + 1);
                } else {
                    block = new DestroyableBlock(r, COLORS[i], NUMBER_OF_HITS);
                }
                blocks.add(block);
                x += REC_WIDTH;
                count--;
            }
            x = Ass5Game.SCREEN_WIDTH - BORDER_HEIGHT_OR_WIDTH - (10 - 1 - i) * REC_WIDTH;
            y += REC_HEIGHT;
            count = 10 - 1 - i;
        }
        return blocks;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocitys = new ArrayList<>();
        velocitys.add(new Velocity(-2, -5));
        velocitys.add(new Velocity(2, -5));
        return velocitys;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }
}