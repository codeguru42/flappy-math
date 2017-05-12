package codeguru.mathybird.util;

import com.badlogic.gdx.InputAdapter;

import codeguru.mathybird.MathyBirdGame;

public class GameOverInputHandler extends InputAdapter {
    private MathyBirdGame game;

    public GameOverInputHandler(MathyBirdGame game) {
        this.game = game;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.reset();
        return true;
    }
}
