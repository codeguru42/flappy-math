package codeguru.mathybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.gameworld.GameWorld;
import codeguru.mathybird.screens.GameScreen;
import codeguru.mathybird.screens.ReadyScreen;
import codeguru.mathybird.util.AssetLoader;

public class MathyBirdGame extends Game {
    private Screen readyScreen;
    private Screen gameScreen;

	@Override
	public void create() {
		AssetLoader.load();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        GameWorld world = new GameWorld(midPointY);
        GameRenderer renderer = new GameRenderer(world);
        readyScreen = new ReadyScreen(renderer);
        gameScreen = new GameScreen(world, renderer);
		setScreen(readyScreen);
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

    public void startGame() {
        setScreen(gameScreen);
    }
}
