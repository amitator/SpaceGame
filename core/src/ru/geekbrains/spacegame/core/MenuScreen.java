package ru.geekbrains.spacegame.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.core.ui.ButtonExit;
import ru.geekbrains.spacegame.engine.ActionListener;
import ru.geekbrains.spacegame.engine.Base2DScreen;
import ru.geekbrains.spacegame.engine.Rect;

/**
 * Created by Igor Prus on 31-Jan-18.
 */

public class MenuScreen extends Base2DScreen implements ActionListener{
    private Texture backgroundTexture;
    private Background background;

    private static final float BUTTON_HEIGHT = .15f;
    private static final float BUTTON_PRESS_SCALE = .9f;

    private ButtonExit buttonExit;
    private TextureAtlas atlas;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void actionPerformed(Object src) {
        if (src == buttonExit){
            Gdx.app.exit();
        } else {
            throw new RuntimeException("Unknows src " + src);
        }
    }

    @Override
    public void show() {
        super.show();
        batch.getProjectionMatrix().idt(); //getting current Matrix for our batch and make it unit matrix
        backgroundTexture = new Texture("stars.jpg");
        background = new Background(new TextureRegion(backgroundTexture));
        atlas = new TextureAtlas("menuAtlas.tpack");
        buttonExit = new ButtonExit(atlas, BUTTON_PRESS_SCALE, this);
        buttonExit.setHeightProportions(BUTTON_HEIGHT);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        buttonExit.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    protected void touchDown(Vector2 touch, int pointer) {
        super.touchDown(touch, pointer);
        buttonExit.touchDown(touch, pointer);
    }

    @Override
    protected void touchUp(Vector2 touch, int pointer) {
        super.touchUp(touch, pointer);
        buttonExit.touchUp(touch, pointer);
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        atlas.dispose();
        batch.dispose();
        super.dispose();
    }

}
