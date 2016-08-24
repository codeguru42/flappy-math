package codeguru.mathybird.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
    public static Texture texture;
    public static TextureRegion bg, grass;

    public static Animation birdAnimation;
    public static TextureRegion bird, birdDown, birdUp;

    public static TextureRegion skullUp, skullDown, bar;

    public static void load() {
        texture = new Texture(Gdx.files.internal("texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        bg = new TextureRegion(texture, 0, 0, 136, 43);
        grass = new TextureRegion(texture, 0, 43, 143, 11);
        birdDown = new TextureRegion(texture, 136, 0, 17, 12);
        bird = new TextureRegion(texture, 153, 0, 17, 12);
        birdUp = new TextureRegion(texture, 170, 0, 17, 12);

        TextureRegion[] birds = { birdDown, bird, birdUp };
        birdAnimation = new Animation(0.06f, birds);
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        skullDown = new TextureRegion(texture, 192, 0, 24, 14);
        skullUp = new TextureRegion(skullDown);
        skullUp.flip(false, true);

        bar = new TextureRegion(texture, 136, 16, 22, 3);
    }

    public static void dispose() {
        texture.dispose();
    }
}
