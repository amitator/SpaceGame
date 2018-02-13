package ru.geekbrains.spacegame.core.bullet;

import ru.geekbrains.spacegame.engine.pool.SpritesPool;

/**
 * Created by Igor Prus on 14-Feb-18.
 */

public class BulletPool extends SpritesPool<Bullet>{
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    public void debugLog() {
        System.out.println("BulletPool change active/free: " + activeObjects.size() + "/" + freeObjects.size());
    }
}
