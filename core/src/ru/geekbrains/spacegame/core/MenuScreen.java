package ru.geekbrains.spacegame.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.engine.Base2DScreen;

/**
 * Created by Igor Prus on 31-Jan-18.
 */

public class MenuScreen extends Base2DScreen {
    private SpriteBatch batch;
    private Texture background;
    private Texture playerShip;
    private Player player;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        batch.getProjectionMatrix().idt(); //getting current Matrix for our batch and make it unit matrix
        background = new Texture("stars.jpg");
        playerShip = new Texture("gamer_ship.png");
        player = new Player(playerShip, new Vector2(600, 50), 300);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(background, 0, 0);
        player.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        playerShip.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        player.setTargetPosition(screenX, Gdx.graphics.getHeight() - screenY);
        return true;
    }
}
