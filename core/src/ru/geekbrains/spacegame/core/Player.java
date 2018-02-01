package ru.geekbrains.spacegame.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import javax.swing.text.Position;

/**
 * Created by Igor Prus on 31-Jan-18.
 */

public class Player {
    private Texture playerShip;
    private Vector2 position;
    private Vector2 targetPosition;
    private float speed;

    private final float SHIP_WIDTH = 100;
    private final float SHIP_HEIGHT = 140;

    public Player(Texture playerShip, Vector2 position, float speed) {
        this.playerShip = playerShip;
        this.position = position;
        this.targetPosition = new Vector2(position);
        this.speed = speed;
    }

    public void setTargetPosition(float x, float y){
        targetPosition.set(x - SHIP_WIDTH / 2, y - SHIP_HEIGHT / 2);
    }

    //runs 60 times per sec
    public void render(SpriteBatch batch){
        update(Gdx.graphics.getDeltaTime()); //in case it's not 60 tps
        batch.draw(playerShip, position.x, position.y);
    }

    public void update(float delta){
        Vector2 distance = new Vector2(targetPosition); //Creating new Vector from target points
        distance.sub(position); //subscribe ship vector(position) from target vector
//        System.out.println(distance.len());
        if(distance.len() > 3.f){
            Vector2 speedVector = distance.cpy().nor().scl(delta * speed); //normalization to get unit vector

            position.add(speedVector);
        }
    }

}
