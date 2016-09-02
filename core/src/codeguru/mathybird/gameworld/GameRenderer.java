package codeguru.mathybird.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import codeguru.mathybird.gameobjects.Bird;
import codeguru.mathybird.gameobjects.Grass;
import codeguru.mathybird.gameobjects.Pipe;
import codeguru.mathybird.gameobjects.ScrollHandler;

public class GameRenderer {
    public static final float GROUND_WIDTH = 136.0f;
    public static final float GROUND_HEIGHT = 37.0f;

    private final GameWorld world;
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private SpriteBatch batch = new SpriteBatch();
    private Bird bird;
    private ScrollHandler scroller;

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
        scroller = world.getScroller();
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
        scroller.render(batch, runTime);
        bird.render(batch, runTime);
        batch.end();
    }
}
