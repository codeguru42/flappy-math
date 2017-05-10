package codeguru.mathybird.util;

import com.badlogic.gdx.InputAdapter;

import codeguru.mathybird.MathyBirdGame;
import codeguru.mathybird.gameobjects.Bird;

public class ReadyInputHandler extends InputAdapter {
    private final MathyBirdGame game;
    private final Bird bird;

    public ReadyInputHandler(MathyBirdGame game, Bird bird) {
        this.game = game;
        this.bird = bird;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        bird.onClick();
        game.startGame();
        return true;
    }
}
