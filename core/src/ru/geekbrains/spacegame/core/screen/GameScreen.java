package ru.geekbrains.spacegame.core.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.core.Background;
import ru.geekbrains.spacegame.core.bullet.BulletPool;
import ru.geekbrains.spacegame.core.explosion.Explosion;
import ru.geekbrains.spacegame.core.explosion.ExplosionPool;
import ru.geekbrains.spacegame.core.star.TrackingStar;
import ru.geekbrains.spacegame.core.ship.MainShip;
import ru.geekbrains.spacegame.engine.Base2DScreen;
import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Rnd;

/**
 * Created by Igor Prus on 07-Feb-18.
 */

public class GameScreen extends Base2DScreen{
    private static final int STAR_COUNT = 30;
    private Background background;
    private Texture backgroundTexture;
    public TextureAtlas atlas;

    private TrackingStar[] star;
    private MainShip mainShip;

    private final BulletPool bulletPool = new BulletPool();
    private ExplosionPool explosionPool;

    private Sound soundExplosion;
    private Music music;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        soundExplosion = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.wav"));
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
        music.setLooping(true);
        music.play();
        backgroundTexture = new Texture("stars.jpg");
        background = new Background(new TextureRegion(backgroundTexture));
        atlas = new TextureAtlas("mainAtlas.tpack");
        mainShip = new MainShip(atlas, bulletPool);
        star = new TrackingStar[STAR_COUNT];

        for (int i = 0; i < star.length; i++) {
            star[i] = new TrackingStar(atlas, Rnd.nextFloat(-.005f, .005f), Rnd.nextFloat(-0.5f, -.1f), .007f, mainShip.getV());
        }
        this.explosionPool = new ExplosionPool(atlas, soundExplosion);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        deleteAllDestroyed();
        update(delta);
        draw();
    }

    public void draw() {
        Gdx.gl.glClearColor(.5f, .2f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length ; i++) {
            star[i].draw(batch);
        }
        mainShip.draw(batch);
        bulletPool.drawActiveObjects(batch);
        explosionPool.drawActiveObjects(batch);
        batch.end();
    }

    public void deleteAllDestroyed() {
        bulletPool.freeAllDestroyedActiveObjects();
        explosionPool.freeAllDestroyedActiveObjects();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length ; i++) {
            star[i].resize(worldBounds);
        }
        mainShip.resize(worldBounds);
    }

    public void update(float delta){
        for (int i = 0; i < star.length ; i++) {
            star[i].update(delta);
        }
        bulletPool.updateActiveObjects(delta);
        explosionPool.updateActiveObjects(delta);
        mainShip.update(delta);
    }

    @Override
    protected void touchUp(Vector2 touch, int pointer) {
        mainShip.touchUp(touch, pointer);
    }

    @Override
    public boolean keyDown(int keycode) {
        mainShip.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        mainShip.keyUp(keycode);
        return false;
    }

    @Override
    protected void touchDown(Vector2 touch, int pointer) {
        mainShip.touchDown(touch, pointer);
        Explosion explosion = explosionPool.obtain();
        explosion.set(.1f, touch);
    }

    @Override
    public void dispose() {
        super.dispose();
        backgroundTexture.dispose();
        atlas.dispose();
        bulletPool.dispose();
        explosionPool.dispose();
        soundExplosion.dispose();
    }
}
