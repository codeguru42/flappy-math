package codeguru.flappymath.util;

import com.badlogic.gdx.InputAdapter;

import codeguru.flappymath.gameobjects.Bird;

public class InputHandler extends InputAdapter {
    private Bird myBird;

    public InputHandler(Bird bird) {
        myBird = bird;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myBird.onClick();
        return true;
    }
}
