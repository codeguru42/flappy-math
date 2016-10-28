package codeguru.mathybird.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.util.AssetLoader;

public class Pipe extends Scrollable {
    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;

    private Random r;

    private Rectangle skullUp = new Rectangle();
    private Rectangle skullDown = new Rectangle();
    private Rectangle barUp = new Rectangle();
    private Rectangle barDown = new Rectangle();
    private boolean isScored = false;

    public Pipe(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        r = new Random();
    }

    @Override
    public void reset(float newX) {
        super.reset(newX);
        height = r.nextInt(90) + 15;
        isScored = false;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        int winHeight = Gdx.graphics.getHeight();
        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width,
                winHeight - (position.y + height + VERTICAL_GAP));
        skullUp.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height
                - SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y,
                SKULL_WIDTH, SKULL_HEIGHT);
    }

    @Override
    public void render(SpriteBatch batch, float runTime) {
        batch.draw(AssetLoader.bar, getX(), getY(), getWidth(), getHeight());
        batch.draw(AssetLoader.bar, getX(), getY() + getHeight() + VERTICAL_GAP,
                getWidth(), GameRenderer.WORLD_HEIGHT - getHeight());

        batch.draw(AssetLoader.skullDown, getX() - 1, getY() + getHeight() - 14);
        batch.draw(AssetLoader.skullUp, getX() - 1, getY() + getHeight() + VERTICAL_GAP);
    }

    public boolean collides(Bird bird) {
        return position.x < bird.getX() + bird.getWidth()
                && (Intersector.overlaps(bird.getBoundingCircle(), barUp)
                || Intersector.overlaps(bird.getBoundingCircle(), barDown)
                || Intersector.overlaps(bird.getBoundingCircle(), skullUp)
                || Intersector.overlaps(bird.getBoundingCircle(), skullDown));
    }

    public boolean isScored() {
        return isScored;
    }

    public void setScored(boolean b) {
        isScored = b;
    }
}
