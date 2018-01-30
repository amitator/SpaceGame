package ru.geekbrains.spacegame;

import com.badlogic.gdx.Game;

/**
 * Created by Igor Prus on 31-Jan-18.
 */

public class Space2DGame extends Game {
    @Override
    public void create(){
        setScreen(new MenuScreen());
    }

}
