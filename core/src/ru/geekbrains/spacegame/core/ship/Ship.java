package ru.geekbrains.spacegame.core.ship;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.core.bullet.Bullet;
import ru.geekbrains.spacegame.core.bullet.BulletPool;
import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by Igor Prus on 14-Feb-18.
 */

public abstract class Ship extends Sprite {
    protected final Vector2 v = new Vector2(); //ship speed
    protected Rect worldBounds;

    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;

    protected final Vector2 bulletV = new Vector2(); //bullet speed
    protected float bulletHeight;
    protected int bulletDamage;

    public Ship (TextureRegion region, int rows, int cols, int frames){
        super(region, rows, cols, frames);

    }

    public void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, bulletDamage);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }
}
