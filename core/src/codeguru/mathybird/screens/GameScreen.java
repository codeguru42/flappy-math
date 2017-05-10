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

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world);
        Gdx.input.setInputProcessor(new GameInputHandler(world.getBird()));
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }
}
