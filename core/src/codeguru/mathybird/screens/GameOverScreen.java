package codeguru.mathybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;

import codeguru.mathybird.MathyBirdGame;
import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.util.GameOverInputHandler;

public class GameOverScreen extends ScreenAdapter {
    private GameRenderer renderer;
    private float runTime = 0.0f;
    private InputProcessor input;

    public GameOverScreen(MathyBirdGame game, GameRenderer renderer) {
        this.renderer = renderer;
        input = new GameOverInputHandler(game);
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        renderer.renderGameOver(runTime);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(input);
    }
}
