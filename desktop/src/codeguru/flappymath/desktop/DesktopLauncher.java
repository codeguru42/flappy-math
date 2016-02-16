package codeguru.flappymath.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import codeguru.flappymath.FlappyMathGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Flappy Math";
		config.width = (int)(272 * 1.5);
		config.height = (int)(408 * 1.5);
		new LwjglApplication(new FlappyMathGame(), config);
	}
}
