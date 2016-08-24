package codeguru.flappymath.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import codeguru.flappymath.gameobjects.Bird;
import codeguru.flappymath.gameobjects.Grass;
import codeguru.flappymath.gameobjects.Pipe;
import codeguru.flappymath.gameobjects.ScrollHandler;
import codeguru.flappymath.util.AssetLoader;

public class GameRenderer {
    public static final int PIPE_VERT_GAP = 45;
    public static final float GROUND_WIDTH = 136.0f;
    public static final float GROUND_HEIGHT = 37.0f;

    private final GameWorld world;
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private SpriteBatch batch = new SpriteBatch();
    private Bird bird;
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;

    public GameRenderer(GameWorld world) {
        OrthographicCamera cam = new OrthographicCamera();
        cam.setToOrtho(false, 136, 204);

        this.world = world;
        batch.setProjectionMatrix(cam.combined);
        shapeRenderer.setProjectionMatrix(cam.combined);

        initGameObjects();
    }

    private void initGameObjects() {
        bird = world.getBird();

        ScrollHandler scroller = world.getScroller();
        frontGrass = scroller.getFrontGrass();
        backGrass = scroller.getBackGrass();
        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3();
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw Dirt
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(147.0f / 255.0f, 80.0f / 255.0f, 27.0f / 255.0f, 1.0f);
        shapeRenderer.rect(0.0f, 0.0f, GROUND_WIDTH, GROUND_HEIGHT);
        shapeRenderer.end();

        batch.begin();
        batch.disableBlending();
        drawGrass();
        drawPipes();
        batch.enableBlending();
        drawSkulls();

        if (bird.shouldntFlap()) {
            batch.draw(AssetLoader.bird, bird.getX(), bird.getY(),
                    bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
                    bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());

        } else {
            batch.draw(AssetLoader.birdAnimation.getKeyFrame(runTime), bird.getX(),
                    bird.getY(), bird.getWidth() / 2.0f,
                    bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
                    1, 1, bird.getRotation());
        }

        batch.end();
    }

    private void drawGrass() {
        // Draw the grass
        batch.draw(AssetLoader.grass, frontGrass.getX(), frontGrass.getY(),
                frontGrass.getWidth(), frontGrass.getHeight());
        batch.draw(AssetLoader.grass, backGrass.getX(), backGrass.getY(),
                backGrass.getWidth(), backGrass.getHeight());
    }

    private void drawSkulls() {
        batch.draw(AssetLoader.skullDown, pipe1.getX() - 1,
                pipe1.getY() + pipe1.getHeight() - 14, 24, 14);
        batch.draw(AssetLoader.skullUp, pipe1.getX() - 1,
                pipe1.getY() + pipe1.getHeight() + PIPE_VERT_GAP, 24, 14);

        batch.draw(AssetLoader.skullDown, pipe2.getX() - 1,
                pipe2.getY() + pipe2.getHeight() - 14, 24, 14);
        batch.draw(AssetLoader.skullUp, pipe2.getX() - 1,
                pipe2.getY() + pipe2.getHeight() + PIPE_VERT_GAP, 24, 14);

        batch.draw(AssetLoader.skullDown, pipe3.getX() - 1,
                pipe3.getY() + pipe3.getHeight() - 14, 24, 14);
        batch.draw(AssetLoader.skullUp, pipe3.getX() - 1,
                pipe3.getY() + pipe3.getHeight() + PIPE_VERT_GAP, 24, 14);
    }

    private void drawPipes() {
        int winHeight = Gdx.graphics.getHeight();
        batch.draw(AssetLoader.bar, pipe1.getX(), pipe1.getY(), pipe1.getWidth(),
                pipe1.getHeight());
        batch.draw(AssetLoader.bar, pipe1.getX(), pipe1.getY() + pipe1.getHeight() + PIPE_VERT_GAP,
                pipe1.getWidth(), winHeight - pipe1.getHeight());

        batch.draw(AssetLoader.bar, pipe2.getX(), pipe2.getY(), pipe2.getWidth(),
                pipe2.getHeight());
        batch.draw(AssetLoader.bar, pipe2.getX(), pipe2.getY() + pipe2.getHeight() + PIPE_VERT_GAP,
                pipe2.getWidth(), winHeight - PIPE_VERT_GAP - pipe2.getHeight());

        batch.draw(AssetLoader.bar, pipe3.getX(), pipe3.getY(), pipe3.getWidth(),
                pipe3.getHeight());
        batch.draw(AssetLoader.bar, pipe3.getX(), pipe3.getY() + pipe3.getHeight() + PIPE_VERT_GAP,
                pipe3.getWidth(), winHeight - PIPE_VERT_GAP - pipe3.getHeight());
    }
}
