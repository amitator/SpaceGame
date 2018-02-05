package ru.geekbrains.spacegame.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.engine.Base2DScreen;
import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by Igor Prus on 31-Jan-18.
 */

public class MenuScreen extends Base2DScreen {
    private Texture backgroundTexture;
    private Background background;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch.getProjectionMatrix().idt(); //getting current Matrix for our batch and make it unit matrix
        backgroundTexture = new Texture("stars.jpg");
        background = new Background(new TextureRegion(backgroundTexture));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    protected void touchUp(Vector2 touch, int pointer) {
        super.touchUp(touch, pointer);
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        batch.dispose();
        super.dispose();
    }

}
