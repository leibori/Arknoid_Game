import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 1.
 */
public class Level1 implements LevelInformation {
    static final int REC_WIDTH = 50;
    static final int REC_HEIGHT = 30;
    static final int NUMBER_OF_HITS = 1;

    @Override
    public Sprite getBackground() {
        return new SunnyBackground();
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Point p = new Point(Ass5Game.SCREEN_WIDTH / 2 - REC_WIDTH / 2, Ass5Game.SCREEN_HEIGHT / 2 - REC_HEIGHT / 2);
        Rectangle r = new Rectangle(p, REC_WIDTH, REC_HEIGHT);
        Block block = new DestroyableBlock(r, Color.black, NUMBER_OF_HITS);
        blocks.add(block);
        return blocks;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocitys = new ArrayList<>();
        velocitys.add(new Velocity(0, -5));
        return velocitys;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }
}
