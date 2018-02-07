package ru.geekbrains.spacegame.core.ui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Rnd;
import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by usver on 07-Feb-18.
 */

public class MainShip extends Sprite {
    private final Vector2 v = new Vector2();
    private Rect worldBounds;
    private Vector2 touch;

    public MainShip(TextureAtlas atlas, float vx, float vy, float height) {
        super(atlas.findRegion("main_ship"));
        v.set(vx, vy);
        setHeightProportions(height);
    }

    @Override
    public void update(float delta) {
//        pos.mulAdd(v, delta);
//        if (touch != null)
//            pos.mulAdd(v, touch);
//        checkAndHandleBounds();
    }

    protected void checkAndHandleBounds(){
        if (getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
        if (getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
        if (getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
        if (getBottom() > worldBounds.getTop()) setTop(worldBounds.getBottom());
    }

    @Override
    public void touchUp(Vector2 touch, int pointer) {
//        super.touchUp(touch, pointer);
//        this.touch = touch;

        pos.mulAdd(v, touch);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
//        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
//        float posY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
//        pos.set(posX, posY);
    }
}
