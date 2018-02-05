package ru.geekbrains.spacegame.engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by usver on 06-Feb-18.
 */

public class Sprite extends Rect{
    protected float angle;
    protected float scale = 1f;
    protected TextureRegion[] regions;
    protected int frame;

    public Sprite(TextureRegion region){
        if (region == null){
            throw new RuntimeException("Region is null");
        }
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void draw(SpriteBatch batch){
        batch.draw(
                regions[frame], //current region
                getLeft(), getBottom(), //point of draw
                halfWidth, halfHeight,  //point of  rotation
                getWidth(), getHeight(), //width and height
                scale, scale,
                angle                   //rotation angle
        );
    }
}
