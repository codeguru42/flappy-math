package codeguru.mathybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.gameworld.GameWorld;
import codeguru.mathybird.util.InputHandler;

public class GameScreen implements Screen {
    private GameWorld world;
    private GameRenderer renderer;
    private float runTime = 0.0f;

    public GameScreen() {
        Gdx.app.log("GameScreen", "attached");
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world);
        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
