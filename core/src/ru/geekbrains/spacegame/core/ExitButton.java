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
//        pos.setLeft(.7f, -.4f);           //Set background position to centre
        this.pos.set(.2f, -.38f);
//        this.setLeft(.7f);
//        this.setBottom(-.4f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportions(.15f); //background width = worldbounds width
        pos.set(worldBounds.pos.set(.2f, -.38f));
//        pos.set(worldBounds.setBottom(-.4f));
    }
}
