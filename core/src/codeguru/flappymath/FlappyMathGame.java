package codeguru.flappymath;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import codeguru.flappymath.screens.GameScreen;
import codeguru.flappymath.util.AssetLoader;

public class FlappyMathGame extends Game {
	@Override
	public void create() {
		Gdx.app.log("ZBGame", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
