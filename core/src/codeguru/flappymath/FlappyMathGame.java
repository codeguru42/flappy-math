package codeguru.flappymath;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import codeguru.flappymath.screens.GameScreen;

public class FlappyMathGame extends Game {
	@Override
	public void create() {
		Gdx.app.log("ZBGame", "created");
		setScreen(new GameScreen());
	}
}
