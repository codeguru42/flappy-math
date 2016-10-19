package codeguru.mathybird.screens;

import com.badlogic.gdx.ScreenAdapter;

import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.gameworld.GameWorld;

public class ReadyScreen extends ScreenAdapter {
    private GameWorld world;
    private GameRenderer renderer;

    public ReadyScreen(int worldWidth, int worldHeight) {
        world = new GameWorld(worldHeight / 2);
        renderer = new GameRenderer(world);
    }
}
