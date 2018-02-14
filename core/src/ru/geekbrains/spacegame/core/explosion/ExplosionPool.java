package ru.geekbrains.spacegame.core.explosion;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.spacegame.engine.Sprite;
import ru.geekbrains.spacegame.engine.pool.SpritesPool;

/**
 * Created by Igor Prus on 14-Feb-18.
 */

public class ExplosionPool extends SpritesPool<Explosion>{
    private final TextureRegion explosionRegion;

    public ExplosionPool(TextureAtlas atlas){
        explosionRegion = atlas.findRegion("explosion");
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(explosionRegion, 9, 9, 74);
    }
}
