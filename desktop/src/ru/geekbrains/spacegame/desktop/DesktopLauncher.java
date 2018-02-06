package ru.geekbrains.spacegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.geekbrains.spacegame.core.Space2DGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Space2DGame(), config);
//		float scale = 480f / 854f;
		float scale = 3f / 4f;
		config.height = 720;
		config.width = (int) (config.height * scale);
	}
}
