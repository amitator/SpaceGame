package ru.geekbrains.spacegame.core.explosion;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by Igor Prus on 14-Feb-18.
 */

public class Explosion extends Sprite {
    private float animateInterval = .017f; //time between animation frames
    private float animateTimer;
    private Sound sound;

    public Explosion(TextureRegion region, int rows, int cols, int frames, Sound sound) {
        super(region, rows, cols, frames);
        this.sound = sound;
    }

    public void set (float height, Vector2 pos) {
        this.pos.set(pos);
        setHeightProportions(height);
        sound.play();
    }

    @Override
    public void update(float delta) {
        animateTimer += delta;
        if (animateTimer >= animateInterval) {
            animateTimer = .0f;
            if (++frame == regions.length){
                destroy();
            }
        }
    }

    public void destroy() {
        setDestroyed(true);
        frame = 0;
    }
}
