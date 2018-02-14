package ru.geekbrains.spacegame.core.explosion;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.spacegame.engine.Sprite;
import ru.geekbrains.spacegame.engine.pool.SpritesPool;

/**
 * Created by Igor Prus on 14-Feb-18.
 */

public class ExplosionPool extends SpritesPool<Explosion>{
    private final TextureRegion explosionRegion;
    private Sound  sound;

    public ExplosionPool(TextureAtlas atlas, Sound sound){
        explosionRegion = atlas.findRegion("explosion");
        this.sound = sound;
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(explosionRegion, 9, 9, 74, sound);
    }
}
