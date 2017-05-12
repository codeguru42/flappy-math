package codeguru.mathybird.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
    private static TextureAtlas atlas;
    public static TextureRegion bg, grass;

    public static Animation birdAnimation;
    public static TextureRegion bird;
    private static TextureRegion birdDown;
    private static TextureRegion birdUp;

    public static TextureRegion skullUp, skullDown, bar;
    public static BitmapFont font, shadow;

    public static void load() {
        atlas = new TextureAtlas("texture.atlas");

        bg = atlas.findRegion("bg");
        grass = atlas.findRegion("grass");
        birdDown = atlas.findRegion("bird-down");
        bird = atlas.findRegion("bird");
        birdUp = atlas.findRegion("bird-up");

        TextureRegion[] birds = { birdDown, bird, birdUp };
        birdAnimation = new Animation(0.06f, birds);
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        skullDown = atlas.findRegion("p1");
        skullUp = new TextureRegion(skullDown);
        skullUp.flip(false, true);

        bar = atlas.findRegion("p2");

        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        font.getData().setScale(.25f, .25f);
        shadow = new BitmapFont(Gdx.files.internal("shadow.fnt"));
        shadow.getData().setScale(.25f, .25f);
    }

    public static void dispose() {
        atlas.dispose();
    }
}
