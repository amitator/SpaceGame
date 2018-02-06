package ru.geekbrains.spacegame.core;

import com.badlogic.gdx.Game;

import ru.geekbrains.spacegame.core.screen.MenuScreen;

/**
 * Created by Igor Prus on 31-Jan-18.
 */

public class Space2DGame extends Game {
    @Override
    public void create(){
        setScreen(new MenuScreen(this));
    }

}
