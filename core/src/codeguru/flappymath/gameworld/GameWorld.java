package codeguru.flappymath.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import codeguru.flappymath.gameobjects.Bird;
import codeguru.flappymath.gameobjects.ScrollHandler;

public class GameWorld {
    private ScrollHandler scroller = new ScrollHandler(26.0f);
    private Bird bird;
    private Rectangle ground = new Rectangle(0.0f, 0.0f, 136.0f, 26.0f);

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);

        Gdx.app.log("Bird", bird.toString());

        if (scroller.collides(bird)) {
            // Clean up on game over
            scroller.stop();
            bird.die();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
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
