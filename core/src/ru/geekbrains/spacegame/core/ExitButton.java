package ru.geekbrains.spacegame.core;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by Igor Prus on 06-Feb-18.
 */

public class ExitButton extends Sprite{
    public ExitButton(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setWithProportions(.15f); //background width = worldbounds width
        pos.set(.7f, -.4f);           //Set background position to centre
    }
}
