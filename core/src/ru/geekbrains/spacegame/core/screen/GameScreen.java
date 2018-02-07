package ru.geekbrains.spacegame.core.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.spacegame.core.Background;
import ru.geekbrains.spacegame.core.star.Star;
import ru.geekbrains.spacegame.engine.Base2DScreen;
import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Rnd;

/**
 * Created by Igor Prus on 07-Feb-18.
 */

public class GameScreen extends Base2DScreen{
    private Background background;
    private Texture backgroundTexture;
    public TextureAtlas atlas;

    private Star[] star = new Star[100];

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("stars.jpg");
        background = new Background(new TextureRegion(backgroundTexture));
        atlas = new TextureAtlas("menuAtlas.tpack");
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(atlas, Rnd.nextFloat(-.005f, .005f), Rnd.nextFloat(-0.5f, -.1f), .01f);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        Gdx.gl.glClearColor(.5f, .2f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length ; i++) {
            star[i].draw(batch);
        }
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length ; i++) {
            star[i].resize(worldBounds);
        }

    }

    public void update(float delta){
        for (int i = 0; i < star.length ; i++) {
            star[i].update(delta);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        backgroundTexture.dispose();
        atlas.dispose();
    }
}
