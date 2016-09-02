package codeguru.mathybird.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollHandler implements GameObject {
    public static final int SCROLL_SPEED = -59;
    public static final int PIPE_GAP = 49;
    public static final int PIPE_START_X = 210;
    public static final int GRASS_HEIGHT = 11;
    public static final int PIPE_WIDTH = 22;
    public static final int PIPE_HEIGHT = 60;

    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;

    public ScrollHandler(float yPos) {
        frontGrass = new Grass(0, yPos, 143, GRASS_HEIGHT, SCROLL_SPEED);
        backGrass = new Grass(frontGrass.getTailX(), yPos, 143, 11, SCROLL_SPEED);

        pipe1 = new Pipe(PIPE_START_X, yPos + GRASS_HEIGHT, PIPE_WIDTH, PIPE_HEIGHT, SCROLL_SPEED);
        pipe2 = new Pipe(pipe1.getTailX() + PIPE_GAP, yPos + GRASS_HEIGHT, PIPE_WIDTH, PIPE_HEIGHT, SCROLL_SPEED);
        pipe3 = new Pipe(pipe2.getTailX() + PIPE_GAP, yPos + GRASS_HEIGHT, PIPE_WIDTH, PIPE_HEIGHT, SCROLL_SPEED);
    }

    public void update(float delta) {
        // Update our objects
        frontGrass.update(delta);
        backGrass.update(delta);
        pipe1.update(delta);
        pipe2.update(delta);
        pipe3.update(delta);

        // Check if any of the pipes are scrolled left,
        // and reset accordingly
        if (pipe1.isScrolledLeft()) {
            pipe1.reset(pipe3.getTailX() + PIPE_GAP);
        } else if (pipe2.isScrolledLeft()) {
            pipe2.reset(pipe1.getTailX() + PIPE_GAP);

        } else if (pipe3.isScrolledLeft()) {
            pipe3.reset(pipe2.getTailX() + PIPE_GAP);
        }

        // Same with grass
        if (frontGrass.isScrolledLeft()) {
            frontGrass.reset(backGrass.getTailX());

        } else if (backGrass.isScrolledLeft()) {
            backGrass.reset(frontGrass.getTailX());

        }
    }

    @Override
    public void render(SpriteBatch batch, float runTime) {
        frontGrass.render(batch, runTime);
        backGrass.render(batch, runTime);
        pipe1.render(batch, runTime);
        pipe2.render(batch, runTime);
        pipe3.render(batch, runTime);
    }

    public boolean collides(Bird bird) {
        return (pipe1.collides(bird) || pipe2.collides(bird) || pipe3.collides(bird));
    }

    public void stop() {
        frontGrass.stop();
        backGrass.stop();
        pipe1.stop();
        pipe2.stop();
        pipe3.stop();
    }
}
