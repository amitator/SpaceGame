package ru.geekbrains.spacegame.engine;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by usver on 06-Feb-18.
 */

public class ScaledOnTouchButton extends Sprite{
    private int pointer;
    private boolean pressed;
    private float pressScale;
    private final ActionListener actionListener;

    public ScaledOnTouchButton(TextureRegion region, float pressScale, ActionListener actionListener) {
        super(region);
        this.pressScale = pressScale;
        this.actionListener = actionListener;
    }

    @Override
    protected void touchDown(Vector2 touch, int pointer) {
        if (pressed || !isMe(touch)){
            return;
        }
        this.pointer = pointer;
        scale = pressScale;
        pressed = true;
    }

    @Override
    protected void touchUp(Vector2 touch, int pointer) {
        if (this.pointer == pointer || !pressed){
            return;
        }
        if (isMe(touch)){
            actionListener.actionPerformed(this);
        }
        pressed = false;
        scale = 1f;
    }
}
