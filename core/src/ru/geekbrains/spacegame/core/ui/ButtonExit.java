package ru.geekbrains.spacegame.core.ui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.spacegame.engine.ActionListener;
import ru.geekbrains.spacegame.engine.ScaledOnTouchButton;

/**
 * Created by Igor Prus on 06-Feb-18.
 */

public class ButtonExit extends ScaledOnTouchButton{
    public ButtonExit(TextureAtlas atlas, float pressScale, ActionListener actionListener) {
        super(atlas.findRegion("btExit"), pressScale, actionListener);
    }


}
