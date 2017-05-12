package codeguru.mathybird.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import codeguru.mathybird.MathyBirdGame;
import codeguru.mathybird.gameobjects.Bird;
import codeguru.mathybird.gameobjects.ScrollHandler;

public class GameWorld {
    private final MathyBirdGame game;
    private ScrollHandler scroller = new ScrollHandler(this, 15.0f);
    private Bird bird;
    private Rectangle ground = new Rectangle(0.0f, 0.0f, GameRenderer.GROUND_WIDTH, GameRenderer.GROUND_HEIGHT);
    private int score = 0;
    private float birdStartY;

    public GameWorld(MathyBirdGame game, int midPointY) {
        this.game = game;
        birdStartY = midPointY - 5.0f;
        bird = new Bird(33, birdStartY, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            // Clean up on game over
            scroller.stop();
            bird.die();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
            game.gameOver();
        }
    }

    public Bird getBird() {
        return bird;

    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public void reset() {
        score = 0;
        bird.reset(birdStartY);
        scroller.reset();
    }
}
