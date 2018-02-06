package ru.geekbrains.spacegame.core.ui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.spacegame.engine.ActionListener;
import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.ScaledOnTouchButton;

/**
 * Created by Igor Prus on 07-Feb-18.
 */

public class ButtonPlay  extends ScaledOnTouchButton{
    public ButtonPlay(TextureAtlas atlas, float pressScale, ActionListener actionListener) {
        super(atlas.findRegion("btPlay"), pressScale, actionListener);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setLeft(worldBounds.getLeft());
    }
}
