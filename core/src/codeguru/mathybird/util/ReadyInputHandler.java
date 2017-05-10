package codeguru.mathybird.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.Logger;

import codeguru.mathybird.MathyBirdGame;

public class ReadyInputHandler extends InputAdapter {
    private final MathyBirdGame game;

    public ReadyInputHandler(MathyBirdGame game) {
        this.game = game;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.startGame();
        return true;
    }
}
