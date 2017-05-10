package codeguru.mathybird.screens;

import com.badlogic.gdx.ScreenAdapter;

import codeguru.mathybird.gameworld.GameRenderer;

public class ReadyScreen extends ScreenAdapter {
    private GameRenderer renderer;
    private float runTime = 0.0f;

    public ReadyScreen(GameRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        renderer.render(runTime);
    }
}
