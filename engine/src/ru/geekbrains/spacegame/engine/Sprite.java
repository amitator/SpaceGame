package ru.geekbrains.spacegame.engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.utils.Regions;

/**
 * Created by Igor Prus on 06-Feb-18.
 */

public class Sprite extends Rect{
    protected float angle;
    protected float scale = 1f;
    protected TextureRegion[] regions;
    protected int frame;
    protected  boolean isDestroyed;

    public Sprite(){}

    public Sprite(TextureRegion region){
        if (region == null){
            throw new RuntimeException("Region is null");
        }
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    public Sprite(TextureRegion region, int rows, int cols, int frames){
        this.regions = Regions.split(region, rows, cols, frames);
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

    public void setWidthProportions(float width){
        setWidth(width);
        float scale = regions[frame].getRegionHeight() / (float) regions[frame].getRegionWidth();
        setHeight(width / scale);
    }

    public void setHeightProportions(float height){
        setHeight(height);
        float scale = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
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

    @Override
    public void update(float delta) {
        super.update(delta);
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

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}
