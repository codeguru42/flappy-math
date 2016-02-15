package codeguru.flappymath.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameRenderer {
    private final OrthographicCamera cam;
    private final GameWorld world;

    public GameRenderer(GameWorld world) {
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);

        this.world = world;
    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");
        // Sets a Color to Fill the Screen with (RGB = 10, 15, 230), Opacity of 1 (100%)
        Gdx.gl.glClearColor(10 / 255.0f, 15 / 255.0f, 230 / 255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
