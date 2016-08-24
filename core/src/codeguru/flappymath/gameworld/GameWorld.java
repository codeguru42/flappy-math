package codeguru.flappymath.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import codeguru.flappymath.gameobjects.Bird;
import codeguru.flappymath.gameobjects.ScrollHandler;

public class GameWorld {
    private ScrollHandler scroller = new ScrollHandler(26.0f);
    private Bird bird;
    private Rectangle ground = new Rectangle(0.0f, 0.0f, GameRenderer.GROUND_WIDTH, GameRenderer.GROUND_HEIGHT);

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);

        Gdx.app.log("Bird", bird.toString());

        if (scroller.collides(bird) && bird.isAlive()) {
            // Clean up on game over
            scroller.stop();
            bird.die();
        }

        Circle c = bird.getBoundingCircle();
        if (c.y < ground.height) {
            Gdx.app.log("Bounding Circle: ", c.toString());
            Gdx.app.log("Ground: ", ground.toString());
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            Gdx.app.log("GameWorld", "collision with ground");
            scroller.stop();
            bird.die();
            bird.decelerate();
        }
    }

    public Bird getBird() {
        return bird;

    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
