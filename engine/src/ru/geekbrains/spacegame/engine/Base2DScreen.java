package ru.geekbrains.spacegame.engine;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.SourceTree;

public class Base2DScreen implements Screen, InputProcessor{

    protected Game game;

    private Rect screenBounds; //bounds of draw area in px
    private Rect worldBounds; //bounds of world coordinates
    private Rect glBounds; //default bounds of world - GL

    protected Matrix4 worldToGl;
    protected Matrix3 screenToWorld;

    protected SpriteBatch batch;

    private final Vector2 touch = new Vector2();

    public Base2DScreen(Game game) {
        this.game = game;

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        this.screenBounds = new Rect();
        this.worldBounds = new Rect();
        this.glBounds = new Rect(0, 0, 1f, 1f);
        this.worldToGl = new Matrix4();
        this.screenToWorld = new Matrix3();
        if (batch !=  null){
            throw new RuntimeException("batch != null, repeats to set up screen without dispose");
        }
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        screenBounds.setSize(width, height);//SCREEN
        screenBounds.setLeft(0);            //SCREEN
        screenBounds.setBottom(0);          //SCREEN

        float scale = width / (float) height;//SCREEN TO WORLD
        worldBounds.setHeight(1f);            //SCREEN TO WORLD
        worldBounds.setWidth(1f * scale);    //SCREEN TO WORLD
        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, glBounds);//WORLD TO GL
        batch.setProjectionMatrix(worldToGl);                              //WORLD TO GL
        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);
        resize(worldBounds);
    }

    public void resize(Rect worldBounds){

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        System.out.println("touchDown x = " +touch.x + "\t" + "y = " + touch.y);
        touchDown(touch, pointer);
        return false;
    }

    protected void touchDown(Vector2 touch, int pointer){

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        System.out.println("touchUp x = " +touch.x + "\t" + "y = " + touch.y);
        touchUp(touch, pointer);
        return false;
    }

    protected void touchUp(Vector2 touch, int pointer){

    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        System.out.println("touchDragged x = " +touch.x + "\t" + "y = " + touch.y);
        touchDragged(touch, pointer);
        return false;
    }

    protected void touchDragged(Vector2 touch, int pointer){

    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
