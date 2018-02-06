package ru.geekbrains.spacegame.core.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import ru.geekbrains.spacegame.engine.Base2DScreen;

/**
 * Created by Igor Prus on 07-Feb-18.
 */

public class GameScreen extends Base2DScreen{
    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(.5f, .2f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        background.draw(batch);
//        buttonExit.draw(batch);
//        buttonPlay.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
