package ru.geekbrains.spacegame.core;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by Igor Prus on 06-Feb-18.
 */

public class Background extends Sprite {
    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportions(worldBounds.getHeight()); //background height = worldbounds height
        pos.set(worldBounds.pos);           //Set background position to centre
    }
}
