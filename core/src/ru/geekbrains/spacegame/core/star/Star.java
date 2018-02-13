package ru.geekbrains.spacegame.core.star;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Rnd;
import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by Igor Prus on 07-Feb-18.
 */

public class Star extends Sprite{
    protected final Vector2 v = new Vector2();
    private Rect worldBounds;

    public Star(TextureAtlas atlas, float vx, float vy, float height) {
        super(atlas.findRegion("star"));
        v.set(vx, vy);
        setHeightProportions(Rnd.nextFloat(height * .5f, height * 3));
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        checkAndHandleBounds();
    }

    protected void checkAndHandleBounds(){
        if (getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
        if (getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
        if (getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
        if (getBottom() > worldBounds.getTop()) setTop(worldBounds.getBottom());
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float posY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(posX, posY);
    }
}
