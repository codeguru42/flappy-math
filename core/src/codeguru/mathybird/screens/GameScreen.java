package codeguru.mathybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;

import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.gameworld.GameWorld;
import codeguru.mathybird.util.GameInputHandler;

public class GameScreen extends ScreenAdapter {
    private GameWorld world;
    private GameRenderer renderer;
    private float runTime = 0.0f;

    public GameScreen(GameWorld world, GameRenderer renderer) {
        Gdx.input.setInputProcessor(new GameInputHandler(world.getBird()));
        this.world = world;
        this.renderer = renderer;
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }
}
