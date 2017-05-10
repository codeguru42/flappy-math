package codeguru.mathybird.util;

import com.badlogic.gdx.InputAdapter;

import codeguru.mathybird.gameobjects.Bird;

public class GameInputHandler extends InputAdapter {
    private Bird myBird;

    public GameInputHandler(Bird bird) {
        myBird = bird;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myBird.onClick();
        return true;
    }
}
