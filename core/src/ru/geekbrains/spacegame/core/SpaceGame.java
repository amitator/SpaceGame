package ru.geekbrains.spacegame.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture backgroundImage;
	Texture playerShip;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		backgroundImage = new Texture("stars.jpg");
		playerShip = new Texture("gamer_ship.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(backgroundImage, 0,0);
		batch.draw(playerShip, 600, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		backgroundImage.dispose();
		playerShip.dispose();
	}
}
