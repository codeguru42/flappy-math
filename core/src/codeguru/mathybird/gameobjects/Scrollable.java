package codeguru.mathybird.gameobjects;

import com.badlogic.gdx.math.Vector2;

public abstract class Scrollable implements GameObject {
    protected Vector2 position;
    private Vector2 velocity;
    protected int width;
    protected int height;
    private boolean isScrolledLeft;

    public Scrollable(float x, float y, int width, int height, float scrollSpeed) {
        position = new Vector2(x, y);
        velocity = new Vector2(scrollSpeed, 0);
        this.width = width;
        this.height = height;
        isScrolledLeft = false;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));

        // If the Scrollable object is no longer visible:
        isScrolledLeft = position.x + width < 0;
    }

    // Reset: Should Override in subclass for more specific behavior.
    public void reset(float newX, float scrollSpeed) {
        position.x = newX;
        velocity.x = scrollSpeed;
        isScrolledLeft = false;
    }

    // Getters for instance variables
    public boolean isScrolledLeft() {
        return isScrolledLeft;
    }

    public float getTailX() {
        return position.x + width;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void stop() {
        velocity.x = 0;
    }
}
