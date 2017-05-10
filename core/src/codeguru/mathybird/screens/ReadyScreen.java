package codeguru.mathybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;

import codeguru.mathybird.MathyBirdGame;
import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.util.ReadyInputHandler;

public class ReadyScreen extends ScreenAdapter {
    private InputProcessor input;
    private GameRenderer renderer;
    private float runTime = 0.0f;

    public ReadyScreen(MathyBirdGame game, GameRenderer renderer) {
        this.input = new ReadyInputHandler(game);
        this.renderer = renderer;
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        renderer.render(runTime);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(input);
    }
}
