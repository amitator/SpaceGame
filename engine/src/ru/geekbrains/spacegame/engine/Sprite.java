package ru.geekbrains.spacegame.engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Igor Prus on 06-Feb-18.
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

    public void setWithProportions(float width){
        setWidth(width);
        float scale = regions[frame].getRegionHeight() / (float) regions[frame].getRegionWidth();
        setHeight(width / scale);
    }

    public void setHeightProportions(float height){
        setHeight(height);
        float scale = regions[frame].getRegionHeight() / (float) regions[frame].getRegionWidth();
        setWidth(height * scale);
    }

    public void resize(Rect worldBounds){

    }

    protected void touchDown(Vector2 touch, int pointer){

    }

    protected void touchUp(Vector2 touch, int pointer){

    }

    protected void touchDragged(Vector2 touch, int pointer){

    }

    public float getAngle() {
        return angle;
    }

    public float getScale() {
        return scale;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
