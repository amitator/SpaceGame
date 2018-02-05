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
    private Texture background;
    private Texture playerShip;
    private Player player;
    private Sprite shipSprite;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch.getProjectionMatrix().idt(); //getting current Matrix for our batch and make it unit matrix
        background = new Texture("stars.jpg");
        playerShip = new Texture( "gamer_ship.png");
        player = new Player(playerShip, new Vector2(600, 50), 300);
        shipSprite = new Sprite(new TextureRegion(playerShip));
        shipSprite.setSize(.15f, .15f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
//        batch.draw(background, 0, 0);
//        player.render(batch);
        shipSprite.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
    }

    @Override
    protected void touchUp(Vector2 touch, int pointer) {
        super.touchUp(touch, pointer);
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        playerShip.dispose();
        super.dispose();
    }

}
