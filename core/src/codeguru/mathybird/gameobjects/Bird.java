package codeguru.mathybird.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.util.AssetLoader;

public class Bird implements GameObject {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private Circle boundingCircle = new Circle();

    private float rotation;
    private int width;
    private int height;
    private boolean isAlive = true;

    public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, -460);
    }

    @Override
    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));
        boundingCircle.set(position.x + 9.0f, position.y + 6.0f, 6.5f);

        if (velocity.y < -200) {
            velocity.y = -200;
        }

        if (position.y > GameRenderer.WORLD_HEIGHT - height - 1) {
            position.y = GameRenderer.WORLD_HEIGHT - height - 1;
            velocity.y = 0;
        }

        position.add(velocity.cpy().scl(delta));

        // Rotate counterclockwise
        if (velocity.y > 0) {
            rotation += 600 * delta;

            if (rotation > 20) {
                rotation = 20;
            }
        }

        // Rotate clockwise
        if (isFalling()) {
            rotation -= 480 * delta;
            if (rotation < -90) {
                rotation = -90;
            }

        }
    }

    @Override
    public void render(SpriteBatch batch, float runTime) {
        if (shouldntFlap()) {
            batch.draw(AssetLoader.bird, getX(), getY(),
                    getWidth() / 2.0f, getHeight() / 2.0f,
                    getWidth(), getHeight(), 1, 1, getRotation());

        } else {
            batch.draw(AssetLoader.birdAnimation.getKeyFrame(runTime), getX(),
                    getY(), getWidth() / 2.0f,
                    getHeight() / 2.0f, getWidth(), getHeight(),
                    1, 1, getRotation());
        }
    }

    public void onClick() {
        if (isAlive) {
            velocity.y = 140;
        }
    }

    public void die() {
        isAlive = false;
        velocity.y = 0;
    }

    public void decelerate() {
        acceleration.y = 0;
    }

    @Override
    public String toString() {
        return "Bird=<position: " + position + ", velocity: " + velocity + "acceleration: " + acceleration + ">";
    }

    public float getX() {
        return position.x;
    }

    private float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    private float getHeight() {
        return height;
    }

    private float getRotation() {
        return rotation;
    }

    public Circle getBoundingCircle() {
        return boundingCircle;
    }

    public boolean isAlive() {
        return isAlive;
    }

    private boolean isFalling() {
        return velocity.y < -110;
    }

    private boolean shouldntFlap() {
        return velocity.y < -70 || !isAlive;
    }

    public void reset(float y) {
        rotation = 0;
        position.y = y;
        velocity.x = 0;
        velocity.y = 0;
        acceleration.x = 0;
        acceleration.y = -460;
        isAlive = true;
    }
}
