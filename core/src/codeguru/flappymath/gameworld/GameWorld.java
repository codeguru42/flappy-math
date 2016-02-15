package codeguru.flappymath.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import codeguru.flappymath.util.AssetLoader;

public class GameWorld {
    private static final int SPRITE_COUNT = 5;
    private Sprite[] sprites = new Sprite[SPRITE_COUNT];

    public GameWorld() {
        sprites[0] = new Sprite(AssetLoader.bird);
        sprites[1] = new Sprite(AssetLoader.grass);
        sprites[2] = new Sprite(AssetLoader.skullUp);
        sprites[3] = new Sprite(AssetLoader.skullDown);
        sprites[4] = new Sprite(AssetLoader.bg);
    }

    public Sprite[] getSprites() {
        return sprites;
    }

    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
    }
}
