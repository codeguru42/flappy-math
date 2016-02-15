package codeguru.flappymath.gameworld;

import codeguru.flappymath.gameobjects.ScrollHandler;

public class GameWorld {
    private ScrollHandler scroller = new ScrollHandler(52.0f);

    public void update(float delta) {
        scroller.update(delta);
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
