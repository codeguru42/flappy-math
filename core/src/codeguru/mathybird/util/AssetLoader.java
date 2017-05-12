package codeguru.mathybird.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
    private static TextureAtlas atlas;
    public static TextureRegion bg, grass;

    public static Animation birdAnimation;
    public static TextureRegion bird;

    public static TextureRegion skullUp, skullDown, bar;
    public static BitmapFont font, shadow, whiteFont;

    public static Sound dead;
    public static Sound flap;
    public static Sound coin;

    public static void load() {
        atlas = new TextureAtlas("texture.atlas");

        bg = atlas.findRegion("bg");
        grass = atlas.findRegion("grass");
        bird = atlas.findRegion("bird");

        TextureRegion birdDown = atlas.findRegion("bird-down");
        TextureRegion birdUp = atlas.findRegion("bird-up");
        TextureRegion[] birds = {birdDown, bird, birdUp};
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
        whiteFont = new BitmapFont(Gdx.files.internal("whitetext.fnt"));
        whiteFont.getData().setScale(.1f, .1f);

        loadAudioResources();
    }

    private static void loadAudioResources() {
        dead = Gdx.audio.newSound(Gdx.files.internal("audio/dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("audio/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("audio/coin.wav"));
    }

    public static void dispose() {
        atlas.dispose();
        dead.dispose();
        flap.dispose();
        coin.dispose();
    }
}
