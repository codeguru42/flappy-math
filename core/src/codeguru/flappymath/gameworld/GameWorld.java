package codeguru.flappymath.gameworld;

import codeguru.flappymath.gameobjects.Bird;
import codeguru.flappymath.gameobjects.ScrollHandler;

public class GameWorld {
    private ScrollHandler scroller = new ScrollHandler(26.0f);
    private Bird bird;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);
    }

    public Bird getBird() {
        return bird;

    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
