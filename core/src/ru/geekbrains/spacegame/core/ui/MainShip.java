package ru.geekbrains.spacegame.core.ui;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacegame.engine.Rect;
import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by usver on 13-Feb-18.
 */

public class MainShip extends Sprite {
    private static final float SHIP_HEIGHT = 0.12f;
    private static final float BOTTOM_MARGIN = 0.05f;

    private final Vector2 v0 = new Vector2(0.2f, 0.0f);
    private final Vector2 v = new Vector2();
    private Rect worldBounds;

    private boolean pressedLeft;
    private boolean pressRight;

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"), 1, 2, 2);
        setHeightProportions(SHIP_HEIGHT);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (getRight() > worldBounds.getRight()) {
            setRight(worldBounds.getRight());
            stop();
        }
        if (getLeft() < worldBounds.getLeft()) {
            setLeft((worldBounds.getLeft()));
            stop();
        }
    }

    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setBottom(worldBounds.getBottom() + BOTTOM_MARGIN);
    }

    @Override
    public void touchDown(Vector2 touch, int pointer) {
        if (worldBounds.pos.x > touch.x) {
            moveLeft();
        } else {
            moveRight();
        }
    }

    @Override
    public void touchUp(Vector2 touch, int pointer) {
        stop();
    }

    public void keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = true;
                moveLeft();
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressRight = true;
                moveRight();
                break;
        }
    }

    public void keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = false;
                if (pressRight){
                    moveRight();
                } else {
                    stop();
                }
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressRight = false;
                if (pressedLeft) {
                    moveLeft();
                } else {
                    stop();
                }
                break;
        }
    }

    private void moveRight() {
        v.set(v0);
    }

    private void moveLeft() {
        v.set(v0).rotate(180);
    }

    private void stop() {
        v.setZero();
    }

}
