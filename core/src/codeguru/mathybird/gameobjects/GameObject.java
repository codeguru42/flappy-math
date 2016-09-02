package codeguru.mathybird.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {
    void update(float delta);
    void render(SpriteBatch batch, float runTime);
}
