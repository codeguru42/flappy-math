package codeguru.mathybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import codeguru.mathybird.screens.GameScreen;
import codeguru.mathybird.util.AssetLoader;

public class MathyBirdGame extends Game {
	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameScreen());
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
