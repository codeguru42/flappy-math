package codeguru.mathybird.screens;

import com.badlogic.gdx.ScreenAdapter;

import codeguru.mathybird.gameworld.GameRenderer;

public class GameOverScreen extends ScreenAdapter {
    private GameRenderer renderer;
    private float runTime = 0.0f;

    public GameOverScreen(GameRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        renderer.renderGameOver(runTime);
    }
}
